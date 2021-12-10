(ns cartao-de-credito.model.expends
  (:require [schema.core :as s]
            [clj-time.core :as t]
            [cartao-de-credito.database.expends-db :as c.d.expends-db])
  (:import (org.joda.time DateTime)))

(def Expend
  {:expend-id   s/Str
   :expend-info {:value    Double
                 :place    s/Str
                 :category s/Str
                 :date     DateTime}
   :card-id s/Str})

(def ExpendsList [Expend])

(def ClientExpendsList {:client-id s/Str
                        :expend-list ExpendsList})

(def ExpendsListPerCategory {s/Str [Expend]})

;(println (s/validate Expend {:expend-id "0000001"
;                             :expend-info {:value 30.99
;                                           :place "ifood"
;                                           :category "restaurant"
;                                           :date (t/date-time 2021 10 14 4 3 27)}
;                             :card-id "001"}))
;
;(println (s/validate ExpendsList (c.d.expends-db/all-expends)))
;(println (s/validate ClientExpendsList {}))
;(println (s/validate Expend {}))




