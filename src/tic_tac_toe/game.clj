(ns tic-tac-toe.game
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.display :as display]
            [tic-tac-toe.reader :as reader]))

(def player-one "X")
(def player-two "O")

(defn player-mark
  [player-one?]
  (if player-one?
    player-one 
    player-two))

(defn is-over?
  [board]
  (board/is-over? board player-one player-two))

(defn play
  ([]
   (display/clear-screen)
   (play (reader/get-location) board/empty-board true))
  ([location board mark]
   (let [marked-board (board/update-board location (player-mark mark) board)]
     (display/clear-screen)
     (display/show-board marked-board)
     (if (is-over? marked-board)
       (display/show-winner (board/get-winner marked-board "X" "O")) 
       (do 
         (display/prompt-player)
         (recur (reader/get-location) marked-board (not mark))))))) 

(defn start
  []
  (display/greet)
  (display/show-board board/empty-board)
  (display/prompt-player)
  (play))

