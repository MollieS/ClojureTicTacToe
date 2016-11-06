(ns tic-tac-toe.players.delay-player
  (:require [tic-tac-toe.players.unbeatable-player :as computer]))

(defn sleep []
  (Thread/sleep 1000))

(defn delay-move []
  (sleep))

(defn get-move [board marks]
  (println "Computer is making a move...")
  (delay-move)
  (computer/get-move board marks))
