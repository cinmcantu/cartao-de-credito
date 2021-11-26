(ns cartao-de-credito.logics.expends-by-category
  (:require [cartao-de-credito.database.expends-db :as c.d.expends-db]))

(defn total-expended
  [expends-details]
  (->> expends-details
       (map :value)
       (reduce +)
       (format "%.2f")))

(defn total-expends-by-category
  [[category expends]]
  {:category category
   :total-expended (total-expended expends)})

(defn expended-by-category
  [expends]
  (->> expends
       (map :expend-info)
       (group-by :category)
       (map total-expends-by-category)))


(defn expends-by-category-by-card-id
  [[card-id expends]]
  {:card_id card-id
   :expends-by-category (expended-by-category expends)})

(defn cards-expends-by-category
  [all-expends]
  (->> all-expends
       (group-by :card-id)
       (map expends-by-category-by-card-id)))


(let [transactions (c.d.expends-db/all-expends)]
  (->> transactions
       cards-expends-by-category
       (map println)))
