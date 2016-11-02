(ns tic-tac-toe.core
  (:gen-class)
  (:require [tic-tac-toe.cli.game-runner :as game-runner]
             [ tic-tac-toe.webplay.web-game :as web-game] 
             [ tic-tac-toe.webplay.human_player :as human]))

(defn -main [& args]
  (game-runner/start))
