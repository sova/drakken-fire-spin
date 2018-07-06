(ns drakken-fire-spin.forms
  (:require [goog.dom :as dom]
            [goog.events :as events]))

(def send-btn (.getElementById js/document "send"))
(def db-str-in (.getElementById js/document "dbstr"))
(def run-str-in (.getElementById js/document "runstr"))
(def el (.getElementById js/document "cbresult"))

(.log js/console send-btn)

(defn send-to-server [ev]
  (let [db-str (.-value db-str-in)
        run-str (.-value run-str-in)]
    (.log js/console run-str)
    (.log js/console ev)))

(.addEventListener send-btn "click" send-to-server)
(set! (.-innerHTML el) "the form portion is loaded woo!")