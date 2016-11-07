(ns tic-tac-toe.players.unbeatable-player
  (:require [tic-tac-toe.game.board :as board]
            [tic-tac-toe.game.rules :as rules]))

(def top-corner 0)
(def middle 4)

(defn available-moves [board]
  (map
    first (filter (fn [[index element]] (nil? element))
                  (map-indexed vector board))))

(defn- get-mark [marks]
  (first marks))

(defn- get-opponent-mark [marks]
  (second marks))

(defn- get-current-mark [colour marks]
  (if colour
    (get-mark marks)
    (get-opponent-mark marks)))

(defn- get-score [winning-positions mark opponent-mark depth]
  (cond
    (rules/is-won-by? winning-positions opponent-mark) (* -10 depth)
    (rules/is-won-by? winning-positions mark) (* 10 depth)
    :else 0))

(defn- score [current-board depth marks]
  (let [winning-positions (board/get-winning-positions current-board)
        mark (get-mark marks)
        opponent-mark (get-opponent-mark marks)]
    (get-score winning-positions mark opponent-mark depth)))

(defn- max-score [colour best-move current-best-move move]
  (if (< (second best-move) (second current-best-move))
    (vector move (second current-best-move))
    best-move))

(defn- min-score [is-max-player best-position valued-position index-of-move]
  (if (> (second best-position) (second valued-position))
    (vector index-of-move (second valued-position))
    best-position))

(defn- get-best-move [colour best-move current-best-move move]
  (if colour
    (max-score colour best-move current-best-move move)
    (min-score colour best-move current-best-move move)))

(defn- min-max-score [colour]
  (if colour
    -1000
    1000))

(defn- is-over? [board marks]
  (rules/is-over? (board/get-winning-positions board)
                  (get-mark marks)
                  (get-opponent-mark marks)))

(defn- play-move [move board colour marks]
  (board/update-board move (get-current-mark colour marks) board))

(defn negamax [board depth colour marks]
  (if (is-over? board marks)
    [nil (score board depth marks)]
    (do
      (loop [[move & rest] (available-moves board)
             best-move [nil (min-max-score colour)]]
        (let [updated-board (play-move move board colour marks)
              score (negamax updated-board (dec depth) (not colour) marks)]
          (let [current-best-move (get-best-move colour best-move score move)]
            (if (empty? rest)
              current-best-move
              (recur rest current-best-move))))))))

(defn- is-empty? [board]
  (= 9 (count (available-moves board))))

(defn- centre-free? [board]
  (nil? (get board middle)))

(defn- second-move? [board]
  (= 8 (count (available-moves board))))

(defn get-move [board marks]
  (cond
    (is-empty? board) top-corner
    (and (second-move? board) (centre-free? board)) middle
    :else (let [move (negamax board 9 true marks)]
            (first move))))
