(ns tic-tac-toe.core
  (:gen-class
    :name ttt.core
    :methods [#^{:static true} [isOver [String] boolean]
              #^{:static true} [playMove [String int String] String]
              #^{:static true} [getCurrentMark [String] String]
              #^{:static true} [isDraw [String] boolean]
              #^{:static true} [winningSymbol [String] String]])
  (:require [tic-tac-toe.cli.game-runner :as game-runner]))

(defn -main [& args]
  (game-runner/start))

