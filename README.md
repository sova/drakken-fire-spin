# Drakken Fire Spin

This is a solution to the puzzle for fintech company as seen at [Clojure Challenge][]

[clojure challenge]: https://tinyurl.com/ClojureChallenge

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To compile the javascript and start a web server for the application, run:

    lein cljsbuild once && lein ring server

will start a server on port 3000

If you prefer, you may run

    lein ring server-headless

and navigate to localhost:3000/ manually.

## License

Copyright © 2018 Vaso Vukotic [sova.kuliana@gmail.com]
