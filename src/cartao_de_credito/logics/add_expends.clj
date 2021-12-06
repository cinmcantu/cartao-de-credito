(ns cartao-de-credito.logics.add-expends
  (:require [cartao-de-credito.model.expends :as c.m.expends]
            [schema.core :as s]
            [clj-time.core :as t]))

(s/set-fn-validation! true)

(s/defn add-expend :- c.m.expends/ClientExpendsList
    [client-list :- c.m.expends/ClientExpendsList , new-expend :- c.m.expends/Expend]
  (update-in client-list [:expend-list] #(conj % new-expend)))


