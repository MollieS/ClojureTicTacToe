(ns tic-tac-toe.delay)

(defn sleep []
  (Thread/sleep 1000))

(defn delay []
  (sleep))
