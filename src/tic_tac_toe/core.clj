(ns tic-tac-toe.core
  (:gen-class)
  (:require [tic-tac-toe.cli.game-runner :as game-runner]))

(defn -main [& args]
  (game-runner/start))
