(ns tic-tac-toe.game
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.display :as display]
            [tic-tac-toe.input-validator :as input-validator]
            [tic-tac-toe.rules :as rules]
            [tic-tac-toe.reader :as reader]))

(def player-one "X")
(def player-two "O")

(defn- set-up-turn [board]
  (display/clear-screen)
  (display/show-board board))

(defn- greet-player []
  (display/clear-screen)
  (display/greet)
  (display/menu))

(defn player-mark [player-one?]
  (if player-one?
    player-one
    player-two))

(defn- is-over?  [board]
  (rules/is-over? (board/get-winning-positions board) player-one player-two))

(defn get-replay-option []
  (display/ask-for-replay)
  (let [user-choice (read-string (reader/read-input))]
    user-choice))

(defn get-player-location [marked-board]
  (display/prompt-player)
  (let [location (reader/read-input)]
    (if (input-validator/invalid? location marked-board)
      (do
        (display/write (input-validator/validate location marked-board))
        (recur marked-board))
      (dec (read-string location)))))

(defn play-game [location board mark]
  (let [marked-board (board/update-board location (player-mark mark) board)]
    (set-up-turn marked-board)
    (if (is-over? marked-board)
      (display/show-winner (rules/get-winner (board/get-winning-positions marked-board) player-one player-two))
      (let [user-location (get-player-location marked-board)]
        (recur user-location marked-board (not mark))))))

(defn start-play []
  (let [location (get-player-location board/empty-board)]
    (play-game location board/empty-board true)))

(defn start []
  (greet-player)
  (display/show-board board/empty-board)
  (start-play)
  (let [replay-choice (get-replay-option)]
    (if (= replay-choice "yes")
      (start)
      (display/goodbye))))
