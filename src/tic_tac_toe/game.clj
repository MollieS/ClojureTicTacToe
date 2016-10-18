(ns tic-tac-toe.game
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.display :as display]
            [tic-tac-toe.input-validator :as input-validator]
            [tic-tac-toe.reader :as reader]))

(def player-one "X")
(def player-two "O")

(defn- set-up-turn
  [board]
  (display/clear-screen)
  (display/show-board board))

(defn player-mark
  [player-one?]
  (if player-one?
    player-one 
    player-two))

(defn is-over?
  [board]
  (board/is-over? board player-one player-two))

(defn get-player-location
  [marked-board]
  (display/prompt-player)
  (let [location (reader/get-location)]
    (if (input-validator/invalid? location marked-board)
      (do 
        (println (input-validator/validate location marked-board))
        (recur marked-board))
      (dec (read-string location)))))

(defn play-game
  [location board mark]
  (let [marked-board (board/update-board location (player-mark mark) board)]
    (set-up-turn marked-board)
    (if (is-over? marked-board)
      (display/show-winner (board/get-winner marked-board player-one player-two))
      (do 
        (let [user-location (get-player-location marked-board)]
          (recur user-location marked-board (not mark)))))))

(defn start-play
  ([]
   (let [location (get-player-location board/empty-board)]
   (play-game location board/empty-board true))))


(defn start
  []
  (display/clear-screen)
  (display/greet)
  (display/show-board board/empty-board)
  (start-play))

