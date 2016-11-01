(ns tic-tac-toe.game.marks)

(def mark-one "X")
(def mark-two "O")

(defn get-mark-order [player-one?]
  (if player-one?
    [mark-one mark-two]
    [mark-two mark-one]))

(defn get-current-mark [player-one?]
  (first (get-mark-order player-one?)))
