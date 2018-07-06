(defproject drakken-fire-spin "0.0.8"
  :description "For Pavel and Lukas of Fintech"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [hiccup "1.0.5"]
                 [cljs-ajax "0.7.3"]
                 [duratom "0.3.3"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.7"]]
  :ring {:handler drakken-fire-spin.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}}
  :cljsbuild {
    :builds [{
        ; The path to the top-level ClojureScript source directory:
        :source-paths ["src-cljs"]
        ; The standard ClojureScript compiler options:
        ; (See the ClojureScript compiler documentation for details.)
        :compiler {
          :output-to "resources/public/js/forms.js"
          :optimizations :whitespace
          :pretty-print true}}]})
