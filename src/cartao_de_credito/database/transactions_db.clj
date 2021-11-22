(ns cartao-de-credito.database.transactions-db)

(def transaction1 {:transaction-id "0000001"
                   :transaction-info {:value "30.99"
                                      :place "ifood"
                                      :category "restaurant"
                                      :date "2021-11-15 12:15:58"}
                   :card-id "001"})

(def transaction2 {:transaction-id "0000002"
                   :transaction-info {:value "40.00"
                                      :place "ponto certo"
                                      :category "transport"
                                      :date "2021-11-20 13:15:58"}
                   :card-id "004"})

(def transaction3 {:transaction-id "0000003"
                   :transaction-info {:value "20.50"
                                      :place "bolos e cia"
                                      :category "restaurant"
                                      :date "2021-11-16 10:15:38"}
                   :card-id "001"})

(def transaction4 {:transaction-id "0000004"
                   :transaction-info {:value "100.58"
                                      :place "petz"
                                      :category "pet"
                                      :date "2021-11-10 20:45:58"}
                   :card-id "002"})

(def transaction5 {:transaction-id "0000005"
                   :transaction-info {:value "250.86"
                                      :place "shell"
                                      :category "transport"
                                      :date "2021-11-25 07:15:58"}
                   :card-id "001"})

(def transaction6 {:transaction-id "0000006"
                   :transaction-info {:value "69.99"
                                      :place "boticario"
                                      :category "gift"
                                      :date "2021-11-02 14:02:58"}
                   :card-id "004"})

(def transaction7 {:transaction-id "0000007"
                   :transaction-info {:value "189.36"
                                      :place "japa"
                                      :category "restaurant"
                                      :date "2021-11-20 21:36:58"}
                   :card-id "005"})