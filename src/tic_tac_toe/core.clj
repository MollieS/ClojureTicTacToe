(ns tic-tac-toe.core
  (:gen-class)
  (:require [tic-tac-toe.game-runner :as game-runner]))

(defn -main [& args]
  (game-runner/start))

