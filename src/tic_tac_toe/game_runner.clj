(ns tic-tac-toe.game-runner
  (:require [tic-tac-toe.display :as display]
            [tic-tac-toe.game_types :as game-types]
            [tic-tac-toe.marks :as marks]
            [tic-tac-toe.game :as game]
            [tic-tac-toe.reader :as reader]))

(def game-types {
                 1 :human-v-human
                 2 :human-v-computer
                 3 :computer-v-human
                 4 :computer-v-computer})

(defn get-replay-option []
  (display/ask-for-replay)
  (let [user-choice (reader/read-input)]
    user-choice))

(defn get-menu-choice []
  (let [choice (read-string (reader/read-input))]
    (if (contains? game-types choice)
      (get game-types choice)
      (recur))))

(defn- greet-player []
  (display/clear-screen)
  (display/greet))

(defn show-result [marked-board]
  (display/clear-screen)
  (display/show-board marked-board)
  (let [winner (game/get-winner marked-board)]
    (if (nil? winner)
      (display/draw)
      (display/show-winner winner))))

(defn play-game [players board player-one?]
  (display/clear-screen)
  (display/show-board board)
  (let [marked-board (game/play-move player-one? players board)]
    (if (game/is-game-over? marked-board)
      (show-result marked-board)
      (recur players marked-board (not player-one?)))))

(defn start-game [players]
  (display/clear-screen)
  (display/show-board (game/get-initial-board))
  (let [marked-board (game/play-move true players (game/get-initial-board))]
    (play-game players marked-board false)))

(defn get-players []
  (display/menu)
  (game-types/get-game (get-menu-choice)))

(defn replay? []
  (= (get-replay-option) "yes"))

(defn start []
  (greet-player)
  (start-game (get-players))
  (if (replay?)
    (start)
    (display/goodbye)))