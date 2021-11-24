(ns cartao-de-credito.logics.join
  (:require [cartao-de-credito.database.card-db :as c.d.card-db]
            [cartao-de-credito.database.client-db :as c.d.client-db]
            [cartao-de-credito.database.expends-db :as c.d.expends-db]))


; Agrupar os cartoes por cliente

(defn client-cards
  [[client-id cards]]
  {:client-id client-id
   :cards cards})

(defn cards-grouped-by-client
  [cards]
  (->> cards
       (group-by :client-id)
       (map client-cards)))

; Manipular data dos gastos para obter o mês

; Agrupar por mes
; Somar os gastos por mês
; Agrupar por cartão
; Linkar com o cliente

(let [cards (c.d.card-db/all-cards)]
  (->> cards
       cards-grouped-by-client
       println))


