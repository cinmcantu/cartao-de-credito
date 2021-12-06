(ns cartao-de-credito.add-expends-test
  (:require [clojure.test :refer :all]
            [cartao-de-credito.logics.add-expends :refer :all]
            [schema.core :as s]
            [clj-time.core :as t])
  (:import (clojure.lang ExceptionInfo)))



(deftest add-expend-test
  (let [empty-client-expends-list {:client-id   "001"
                                   :expend-list []}
        one-item-client-expends-list {:client-id   "001"
                                      :expend-list [{:expend-id   "0000002"
                                                     :expend-info {:value    30.99
                                                                   :place    "ponto certo"
                                                                   :category "transport"
                                                                   :date     (t/date-time 2021 11 20 13 15 58)}
                                                     :card-id     "004"}]}
        expend {:expend-id   "0000003"
                :expend-info {:value    50.00
                              :place    "Mc Donalds"
                              :category "food"
                              :date     (t/date-time 2021 12 01 13 15 58)}
                :card-id     "004"}]

    (testing "Should add a new expend on a list"
      (is (= {:client-id   "001"
              :expend-list [{:expend-id   "0000003"
                             :expend-info {:value    50.00
                                           :place    "Mc Donalds"
                                           :category "food"
                                           :date     (t/date-time 2021 12 01 13 15 58)}
                             :card-id     "004"}]}
             (add-expend empty-client-expends-list expend)))

      (is (= {:client-id   "001"
              :expend-list [{:expend-id   "0000002"
                             :expend-info {:value    30.99
                                           :place    "ponto certo"
                                           :category "transport"
                                           :date     (t/date-time 2021 11 20 13 15 58)}
                             :card-id     "004"}
                            {:expend-id   "0000003"
                             :expend-info {:value    50.00
                                           :place    "Mc Donalds"
                                           :category "food"
                                           :date     (t/date-time 2021 12 01 13 15 58)}
                             :card-id     "004"}]}
             (add-expend one-item-client-expends-list expend))))))


;(testing "Should refuse if new expend is not valid"
;  (is ((try
;         (add-expend empty-client-expends-list {})
;         false
;         (catch ExceptionInfo e
;           (= :not-added (:error ex-data e)))))))



