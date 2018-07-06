(ns drakken-fire-spin.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :refer :all]
            [hiccup.form :refer :all]
            [drakken-fire-spin.methods :refer :all]
            [drakken-fire-spin.views :refer :all]))

(defroutes app-routes
  (GET "/" [] (html [:h3 "Task 1: Complete the function (scramble str1 str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false."]
                    [:p]
                    [:h2 "Task 2"]
                    [:p "Create a web service that accepts two strings as a request and applies a function scramble? on them from previous task."]
                    [:a {:href "/query"} "query page"]

                    [:h2 "Task 3"]
                    [:p "Create a UI in ClojureScript within two inputs for strings and a scramble button. When the button is fired it should call the API from previous task and display a result."]
                    [:h2 "Notes"]
                    [:p "Please pay attention to tests, code readability and error cases."]))
  (GET "/:dbstr&:runstr" [dbstr runstr :as params]
       (let [result (scramble? dbstr runstr)]
         (if (nil? result)
           (html [:div.result "false"])
           ;else
           (html [:div.result "true"]))))

  (GET "/query" []
       (scramble-query-page))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
