(ns drakken-fire-spin.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [drakken-fire-spin.handler :refer :all]
            [drakken-fire-spin.methods :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))


(deftest scrambles
  (is (= :consumed
         (scramble? "alfredjhitchcock" "hatch")))
  (is (= :consumed
         (scramble? "rekqodlw" "world")))
  (is (= :consumed
         (scramble? "caoaesuaoeuodedewaaroros" "codewars")))
  (is (= nil
         (scramble? "james" "sophia")))
  (is (= nil
         (scramble? "katas" "steak")))
  (is (= :consumed
         (scramble? "jumpjumpjmup" "jjj")))
  (is (= :consumed
         (scramble? "fallfallfall" "llllaal")))
  (is (= :consumed
         (scramble? "growgrowgrow" "rowrow")))
  (is (= :consumed
         (scramble? "jnitoinelareableodigrorectsc." "reals"))))
