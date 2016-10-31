(ns tic-tac-toe.game
  (:require [tic-tac-toe.rules :as rules]
            [tic-tac-toe.board :as board]
            [tic-tac-toe.marks :as marks]))

(defn- get-current-player [players player-one?]
  (if player-one?
    (first players)
    (second players)))

(defn get-player-move [players board player-one?]
  (let [current-player (get-current-player players player-one?)
        current-marks (marks/get-mark-order player-one?)]
    (current-player board current-marks)))

(defn is-game-over? [current-board]
  (rules/is-over? (board/get-winning-positions current-board)
                  marks/mark-one
                  marks/mark-two))

(defn play-move [player-one? players current-board]
  (let [move (get-player-move players current-board player-one?)]
    (board/update-board move 
                        (marks/get-current-mark player-one?)
                        current-board)))

(defn get-initial-board []
  board/empty-board)

(defn get-winner [current-board]
  (let [winning-positions (board/get-winning-positions current-board )]
  (cond
    (rules/is-won-by? winning-positions marks/mark-one) marks/mark-one
    (rules/is-won-by? winning-positions marks/mark-two) marks/mark-two
    :else nil)))
