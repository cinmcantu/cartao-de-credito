(ns cartao-de-credito.logics.join
  (:require [cartao-de-credito.database.card-db :as c.d.card-db]
            [cartao-de-credito.database.client-db :as c.d.client-db]
            [cartao-de-credito.database.expends-db :as c.d.expends-db]
            [cartao-de-credito.logics.expends-by-month :as c.l.expends-by-month]))


(defn client-cards
  [client-id cards]
  {:client-id client-id
   :cards-id (keep #( if(= client-id (:client-id %)) (:card-id %)) cards)})

(def card-expends-per-month (->> (c.d.expends-db/all-expends)
                                 c.l.expends-by-month/grouped-by-card))

(defn cards-by-clients []
  (->> (c.d.client-db/all-clients)
       (map #(client-cards (:client-id %) (c.d.card-db/all-cards)))))

(defn sum-similar
  [sequence key-grouped key-to-sum]
  (map (fn [[grp-key values]]
         {key-grouped grp-key
          key-to-sum (reduce + (map key-to-sum values))})
       (group-by key-grouped sequence)))

(defn all-expends
  [cards-expends]
  (apply concat (map :expends-by-month cards-expends)))

(defn client-expends-information!
  [card-id]
  (first (filter #(= card-id (:card-id %)) card-expends-per-month)))

(defn client-expends-per-month
  [client]
  {:client-id        (:client-id client)
   :expends-by-month (sum-similar
                       (all-expends (map client-expends-information! (:cards-id client)))
                       :month
                       :total-expended)})

(defn all-client-expends-per-month []
  (->> (cards-by-clients)
       (map client-expends-per-month)))



