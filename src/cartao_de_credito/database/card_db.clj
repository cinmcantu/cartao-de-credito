(ns cartao-de-credito.database.card-db)

(def card1 {:card-id "001"
            :card-info {:number "5001 1111 1111 1111"
                        :cvv "001"
                        :exp-date "2029-12-25"
                        :limit "1000.00"}
            :client-id "001"})

(def card2 {:card-id "002"
            :card-info {:number "5001 2222 2222 2222"
                        :cvv "002"
                        :exp-date "2029-12-25"
                        :limit "2000.00"}
            :client-id "003"})

(def card3 {:card-id "003"
            :card-info {:number "5001 3333 3333 3333"
                        :cvv "003"
                        :exp-date "2022-01-25"
                        :limit "10000.00"}
            :client-id "001"})

(def card4 {:card-id "004"
            :card-info {:number "5001 4444 4444 4444"
                        :cvv "004"
                        :exp-date "2023-04-25"
                        :limit "3000.00"}
            :client-id "002"})

(def card5 {:card-id "005"
            :card-info {:number "5001 5555 5555 5555"
                        :cvv "005"
                        :exp-date "2029-12-25"
                        :limit "5000.00"}
            :client-id "004"})

(def card6 {:card-id "006"
            :card-info {:number "5001 6666 6666 6666"
                        :cvv "006"
                        :exp-date "2029-12-25"
                        :limit "2000.00"}
            :client-id "005"})

(defn all-cards []
  [card1 card2 card3 card4 card5 card6])