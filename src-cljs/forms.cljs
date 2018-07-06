(ns drakken-fire-spin.forms
  (:require [ajax.core :refer [GET]]))

(def send-btn (.getElementById js/document "send"))
(def db-str-in (.getElementById js/document "dbstr"))
(def run-str-in (.getElementById js/document "runstr"))
(def el (.getElementById js/document "cbresult"))

(.log js/console send-btn)

(defn post-response [response]
  (set! (.-innerHTML el) response))

(defn send-to-server [ev]
  (let [db-str (.-value db-str-in)
        run-str (.-value run-str-in)]

    (console.log (GET (str "/" db-str "&" run-str)  {:handler post-response}))
    (.log js/console run-str)
    (.log js/console ev)))

(.addEventListener send-btn "click" send-to-server)
(set! (.-innerHTML el) "the form portion is loaded woo!")

