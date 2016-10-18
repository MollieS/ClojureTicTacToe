(ns tic-tac-toe.game
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.display :as display]
            [tic-tac-toe.reader :as reader]))

(defn player-mark
  [player-one?]
  (if player-one?
    "X"
    "O"))

(defn play
  ([]
   (play (reader/get-location) board/empty-board true))
  ([location board mark]
   (let [marked-board (board/update-board location (player-mark mark) board)]
     (display/show-board marked-board)
     (display/prompt-player)
     (recur (reader/get-location) marked-board (not mark))))) 

(defn start
  []
  (display/greet)
  (display/show-board board/empty-board)
  (display/prompt-player)
  (play))

