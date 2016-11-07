(ns tic-tac-toe.cli.game-runner
  (:require [tic-tac-toe.cli.display :as display]
            [tic-tac-toe.cli.game-types :as game-types]
            [tic-tac-toe.cli.input-validator :as input-validator]
            [tic-tac-toe.game.marks :as marks]
            [tic-tac-toe.game.game :as game]
            [tic-tac-toe.cli.reader :as reader]))

(def game-types {
                 1 :human-v-human
                 2 :human-v-computer
                 3 :computer-v-human
                 4 :computer-v-computer})

(defn get-replay-option []
  (display/ask-for-replay)
  (let [user-choice (reader/read-input)]
    user-choice))

(defn- input-is-invalid [input]
  (cond
    (input-validator/empty-string? input) true
    (input-validator/not-a-number? input) true
    (not (contains? game-types (read-string input))) true
    :else false))

(defn get-menu-choice []
  (let [choice (reader/read-input)]
    (if (input-is-invalid choice)
      (do
        (display/invalid-choice)
        (recur))
      (get game-types (read-string choice)))))

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
