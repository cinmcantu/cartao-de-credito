(ns cartao-de-credito.database.expends-db)
(require '[clj-time.core :as t])

(def expend1 {:expend-id "0000001"
              :expend-info {:value 30.99
                            :place "ifood"
                            :category "restaurant"
                            :date (t/date-time 2021 10 14 4 3 27)}
              :card-id "001"})

(def expend2 {:expend-id "0000002"
              :expend-info {:value 40.00
                            :place "ponto certo"
                            :category "transport"
                            :date (t/date-time 2021 11 20 13 15 58)}
              :card-id "004"})

(def expend3 {:expend-id "0000003"
              :expend-info {:value 20.50
                            :place "bolos e cia"
                            :category "restaurant"
                            :date (t/date-time 2021 11 16 10 15 38)}
              :card-id "001"})

(def expend4 {:expend-id "0000004"
              :expend-info {:value 100.58
                            :place "petz"
                            :category "pet"
                            :date (t/date-time 2021 11 10 20 45 58)}
              :card-id "002"})

(def expend5 {:expend-id "0000005"
              :expend-info {:value 250.86
                            :place "shell"
                            :category "transport"
                            :date (t/date-time 2021 11 25 07 15 58)}
              :card-id "001"})

(def expend6 {:expend-id "0000006"
              :expend-info {:value 69.99
                            :place "boticario"
                            :category "gift"
                            :date (t/date-time 2021 11 02 14 02 58)}
              :card-id "004"})

(def expend7 {:expend-id "0000007"
              :expend-info {:value 189.36
                            :place "japa"
                            :category "restaurant"
                            :date (t/date-time 2021 11 20 21 36 58)}
              :card-id "005"})

(def expend8 {:expend-id "0000008"
              :expend-info {:value 200.00
                            :place "churras"
                            :category "restaurant"
                            :date (t/date-time 2021 11 20 21 36 58)}
              :card-id "005"})

(def expend9 {:expend-id "0000009"
              :expend-info {:value 79.99
                            :place "cacau show"
                            :category "gift"
                            :date (t/date-time 2021 11 02 14 02 58)}
              :card-id "005"})

(def expend10 {:expend-id "0000010"
               :expend-info {:value 79.99
                             :place "shell"
                             :category "transport"
                             :date (t/date-time 2021 12 23 14 02 58)}
               :card-id "003"})

(def expend11 {:expend-id "0000011"
               :expend-info {:value 79.99
                             :place "shell"
                             :category "transport"
                             :date (t/date-time 2021 11 23 14 02 58)}
               :card-id "003"})
(def expend12 {:expend-id "0000012"
               :expend-info {:value 19.99
                             :place "papelaria"
                             :category "study"
                             :date (t/date-time 2021 11 25 14 02 58)}
               :card-id "006"})


(defn all-expends []
  [expend1 expend2 expend3 expend4 expend5
   expend6 expend7 expend8 expend9 expend10
   expend11 expend12])