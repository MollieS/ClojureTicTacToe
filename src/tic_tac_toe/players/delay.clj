(ns tic-tac-toe.players.delay)

(defn sleep []
  (Thread/sleep 1000))

(defn delay []
  (sleep))
