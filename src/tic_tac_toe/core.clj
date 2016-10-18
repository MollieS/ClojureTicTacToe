(ns tic-tac-toe.core
  (:gen-class)
  (:require [tic-tac-toe.game :as game]))

(defn -main 
  [& args]
  (game/start))

