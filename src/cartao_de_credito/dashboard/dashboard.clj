(ns cartao-de-credito.dashboard.dashboard
  (:require [cartao-de-credito.database.card-db :as c.d.card-db]
            [cartao-de-credito.database.client-db :as c.d.client-db]
            [cartao-de-credito.database.expends-db :as c.d.expends-db]
            [cartao-de-credito.logics.join :as c.l.join]
            [cartao-de-credito.logics.expends-by-category :as c.l.expends-by-category]
            [cartao-de-credito.logics.search :as c.l.search]))


; Global symbols definitions
(def all-clients (c.d.client-db/all-clients))
(def all-cards (c.d.card-db/all-cards))
(def all-expends (c.d.expends-db/all-expends))

; All data
(println "All clients data")
(println all-clients)

(println "\nAll cards data")
(println all-cards)

(println "\nAll expends data")
(println all-expends)

; Expends grouped by category
(println "\nExpends grouped by category")
(println (c.l.expends-by-category/cards-expends-by-category all-expends))

; Monthly expends per client
(println "\nMonthly expends per client")
(println (c.l.join/all-client-expends-per-month))

; Searchs
(println "\nSearch per value")
(println (c.l.search/expends-per-value 30.99))

(println "\nSearch per place")
(println (c.l.search/expends-per-place "shell"))