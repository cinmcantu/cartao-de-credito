(ns cartao-de-credito.logics.search
  (:require [cartao-de-credito.database.expends-db :as c.d.expends-db]))

(defn search-by-key
  [list key value]
  (filter #(= value (get-in % key))list))

(defn expends-per-value
  [value]
  (search-by-key (c.d.expends-db/all-expends) [:expend-info :value] value))

(defn expends-per-place
  [place]
  (search-by-key (c.d.expends-db/all-expends) [:expend-info :place] place))