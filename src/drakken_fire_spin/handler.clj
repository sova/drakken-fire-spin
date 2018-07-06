(ns drakken-fire-spin.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :refer :all]
            [hiccup.form :refer :all]
            [drakken-fire-spin.methods :refer :all]
            [drakken-fire-spin.views :refer :all]
            [clojure.java.io :as io]))

(def method-file (io/resource "methods.clj"))

(defroutes app-routes
  (GET "/" [] (html [:p {:style "background-color: lightblue;
                                 font-size: 24px;"} "To run: " [:em "lein cljsbuild once && lein ring server"]]

                    [:h2 "Task 1: Methods.clj"]
                    [:p "Complete the function (scramble str1 str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false."]
                    [:img {:src "method.png"}]
                    [:h2 "Task 2: Handler.clj"]
                    [:p "Create a web service that accepts two strings as a request and applies a function scramble? on them from previous task."]
                    [:img {:src "webservice.png"}]
                    [:h2 "Task 3: Forms.cljs"]
                    [:p "(Create a UI in ClojureScript within two inputs for strings and a scramble button. When the button is fired it should call the API from previous task and display a result.)"]
                    [:div.scrambler {:style "background-color: hsl(170, 50%, 80%);
                                             min-height: 200px;
                                             padding-top: 20px;"}
                     (scramble-query-page)]
                    [:img {:src "clojurescript-result.png"}]
                    [:p "Thanks for your consideration!"]
                    [:p "sova.kuliana@gmail.com"]))


  (GET "/:dbstr&:runstr" [dbstr runstr :as params]
       (let [result (scramble? dbstr runstr)]
         (if (nil? result)
           (concat "false")
           ;else
           (concat"true"))))

  (GET "/query" []
       (scramble-query-page))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
