(ns drakken-fire-spin.forms
  (:require [ajax.core :refer [GET]]))

(def send-btn (.getElementById js/document "send"))
(def db-str-in (.getElementById js/document "dbstr"))
(def run-str-in (.getElementById js/document "runstr"))
(def el (.getElementById js/document "cbresult"))

(defn post-response [response]
  ;(.log js/console response)

  (if (= "true" response)
    (set! (.-backgroundColor (.-style el)) "lightgreen")
    ;else
    (set! (.-backgroundColor (.-style el)) "orange"))
  ;always
  (set! (.-innerHTML el) response))


(defn send-to-server [ev]
  (let [db-str (.-value db-str-in)
        run-str (.-value run-str-in)]
    (GET (str "/" db-str "&" run-str)  {:handler post-response})))

(.addEventListener send-btn "click" send-to-server)
(set! (.-innerHTML el) "Loaded Javascript.")

