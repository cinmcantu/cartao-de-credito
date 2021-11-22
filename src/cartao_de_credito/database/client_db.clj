(ns cartao-de-credito.database.client-db)

(def client1 {:client-id "001"
              :client-info {:name "Cinthia"
                            :cpf "111.111.111-11"
                            :email "cinthia@email.com"}})

(def client2 {:client-id "002"
              :client-info {:name "Pedro"
                            :cpf "222.222.222-22"
                            :email "pedro@email.com"}})

(def client3 {:client-id "003"
              :client-info {:name "Thiago"
                            :cpf "333.333.333-33"
                            :email "thiago@email.com"}})

(def client4 {:client-id "004"
              :client-info {:name "Day"
                            :cpf "444.444.444-44"
                            :email "day@email.com"}})

(def client5 {:client-id "005"
              :client-info {:name "Jonatas"
                            :cpf "555.555.555-55"
                            :email "hilbert@email.com"}})

(defn all-clients []
  [client1 client2 client3 client4 client5])