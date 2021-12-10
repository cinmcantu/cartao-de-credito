(ns cartao-de-credito.add-expends-test
  (:require [clojure.test :refer :all]
            [cartao-de-credito.logics.add-expends :refer :all]
            [schema.core :as s]
            [clj-time.core :as t])
  (:import (clojure.lang ExceptionInfo)))

(s/set-fn-validation! true)

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
             (add-expend one-item-client-expends-list expend))))

    (testing "Should return an error if the schema is not valid"
      (is (thrown? ExceptionInfo (add-expend {} {}))))))


(deftest list-client-expends-test
  (let [complete-list [{:client-id   "001"
                        :expend-list []}
                       {:client-id   "002"
                        :expend-list []}
                       {:client-id   "003"
                        :expend-list []}]]

    (testing "Find list from client 001"
      (is (= {:client-id   "001"
              :expend-list []}
             (list-client-expends "001" complete-list))))

    (testing "Don't find any client 004"
      (is (nil? (list-client-expends "004" complete-list))))

    (testing "Doesn't match schema"
      (is (thrown? ExceptionInfo (list-client-expends 1 complete-list)))
      (is (thrown? ExceptionInfo (list-client-expends "001" [{:client-id 1}]))))))


(deftest expends-per-category-test
  (let [client-expends-list
        {:client-id   "001"
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
                        :card-id     "001"}]}]
    (testing "List per category"
      (is (= {"transport" [{:expend-id   "0000002"
                            :expend-info {:value    30.99
                                          :place    "ponto certo"
                                          :category "transport"
                                          :date     (t/date-time 2021 11 20 13 15 58)}
                            :card-id     "004"}],
              "food" [{:expend-id   "0000003"
                       :expend-info {:value    50.00
                                     :place    "Mc Donalds"
                                     :category "food"
                                     :date     (t/date-time 2021 12 01 13 15 58)}
                       :card-id     "001"}]}
             (expends-per-category (:expend-list client-expends-list)))))))





