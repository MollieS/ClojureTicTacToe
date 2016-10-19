(ns tic-tac-toe.unbeatable-player
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.rules :as rules]))

(def mark "O")
(def opponent-mark "X")

(defn available-moves [board]
  (map first (filter (fn [[index element]] (nil? element)) (map-indexed vector board))))

(defn score [board depth]
  (cond
    (rules/is-won-by? (board/get-winning-positions board) opponent-mark) (* -10 depth)
    (rules/is-won-by? (board/get-winning-positions board) mark) (* 10 depth)
    :else 0))

(defn get-current-mark [colour]
  (if colour
    mark
    opponent-mark))

(defn sort-moves [moves sorted-moves]
  (if (empty? moves)
    sorted-moves
    (do
      (let [current-move (first moves)
            move (first current-move)
            score (last current-move)
            updated-moves (assoc sorted-moves move score)]
        (recur (rest moves) updated-moves)))))

(defn get-best-move [moves]
  (let [sorted-moves (sort-moves moves {})]
    (key (apply max-key val sorted-moves))))

(defn negamax [board colour depth]
  (if (rules/is-over? (board/get-winning-positions board) mark opponent-mark)
    (score board depth)
    (do
      (for [move (available-moves board)]
        (let [updated-board (board/update-board move (get-current-mark colour) board)
              score (negamax updated-board (not colour) (dec depth))
              score  (into [] (flatten [move score]))]
          score)))))

(defn get-mark []
  mark)

(defn get-move [board]
  (cond
    (= 9 (count (available-moves board))) 0
    (and (= 8 (count (available-moves board))) (nil? (get 4 board))) 4
    :else (let [move (apply vector (negamax board true 9)) ]
      (get-best-move move ))))

