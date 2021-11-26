(ns cartao-de-credito.logics.expends-by-month
  (:require [cartao-de-credito.database.expends-db :as c.d.expends-db]))
(require '[clj-time.core :as t])

(defn expend-with-month
  [expend]
  (assoc expend :expend-month (t/month (get-in expend [:expend-info :date]))))

(defn values-by-month
  [expend]
  (get-in expend [:expend-info :value]))

(defn total-expended
  [expends-details]
  (->> expends-details
       (map values-by-month)
       (reduce +)))

(defn total-expends-by-month
  [[month expends]]
  {:month month
   :total-expended (total-expended expends)})

(defn grouped-by-month
  [[card-id expend-info]]
  {:card-id card-id
   :expends-per-month (->> expend-info
                           (group-by :expend-month)
                           (map total-expends-by-month))})

(defn grouped-by-card
  [expends]
  (->> expends
       (map expend-with-month)
       (group-by :card-id)
       (map grouped-by-month)))



(println (grouped-by-card (c.d.expends-db/all-expends)))
