(ns drakken-fire-spin.views
  (:require [hiccup.page :refer :all]
            [hiccup.core :refer :all]
            [hiccup.form :refer :all]))

(defn scramble-query-page []
   (html
    [:head
      [:title "Scramble? Check Page"]]
    [:body
      [:p "Enter your strings in the input fields to check their result against the Scrambles algorithm."]
      [:input#dbstr {:placeholder "long string"} ]
      [:input#runstr {:placeholder "short string"}]
      [:button#send {:type "submit"} "scramble"]
      [:div#cbresult "waiting for result..."]]

      (include-js "/js/forms.js")))
