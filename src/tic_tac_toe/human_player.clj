(ns tic-tac-toe.human-player
  (:require [tic-tac-toe.reader :as reader]
            [tic-tac-toe.display :as display]
            [tic-tac-toe.input-validator :as input-validator]))

(defn- get-valid-location [location current-board]
  (display/clear-screen)
  (display/show-board current-board)
  (display/write (input-validator/validate location current-board))
  (display/prompt-player)
  (let [new-location (reader/read-input)]
    (if (input-validator/invalid? new-location current-board)
      (recur new-location current-board)
      (dec (read-string new-location)))))

(defn get-player-location [current-board marks]
  (display/prompt-player)
  (let [location (reader/read-input)]
    (if (input-validator/invalid? location current-board)
      (get-valid-location location current-board)
      (dec (read-string location)))))

(defn get-move [board marks]
  (get-player-location board marks))
