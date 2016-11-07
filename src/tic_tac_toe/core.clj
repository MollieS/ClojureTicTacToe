(ns tic-tac-toe.core
  (:gen-class
    :name ttt.core
    :methods [#^{:static true} [isOver [String] boolean]
              #^{:static true} [playMove [String int String] String]
              #^{:static true} [getCurrentMark [String] String]
              #^{:static true} [isDraw [String] boolean]
              #^{:static true} [winningSymbol [String] String]])
  (:require [tic-tac-toe.cli.game-runner :as game-runner]
            [tic-tac-toe.webplay.web-game :as web-game]))

(defn -main [& args]
  (game-runner/start))

(defn -isOver [board]
  (web-game/is-over? board))

(defn -playMove [board location game-type]
  (web-game/play-move board location game-type))

(defn -getCurrentMark [board-state]
  (web-game/get-current-player board-state))

(defn -isDraw [board-state]
  (web-game/draw? board-state))

(defn -winningSymbol [board-state]
  (web-game/winning-symbol board-state))
