(ns tic-tac-toe.board)

(def empty-board
  (apply vector (take 9 (repeat nil))))

(defn- get-rows [board]
  (partition 3 board))

(defn- get-columns [board]
  (apply map vector (partition 3 board)))

(defn- remove-indexes [indexed-board]
  (vec (map last indexed-board)))

(defn- find-even-indexes [board]
  (filter (fn [[index element]] (even? index)) board))

(defn- find-left-diagonal [diagonals]
  (filter (fn [[index element]] (zero? (rem index 4))) diagonals))

(defn- find-right-diagonal [diagonals]
  (filter (fn [[index element]] (and (pos? index) (< index 8))) diagonals))

(defn- get-indexed-diagonals [board]
  (let [indexed-board (map-indexed vector board)
        even-indexes (find-even-indexes indexed-board)]
    even-indexes))

(defn- get-left-diagonal [board]
  (let [diagonals (get-indexed-diagonals board)]
    (remove-indexes (find-left-diagonal diagonals))))

(defn- get-right-diagonal [board]
  (let [diagonals (get-indexed-diagonals board)]
    (remove-indexes (find-right-diagonal diagonals))))

(defn- get-diagonals [board]
  [(get-left-diagonal board) (get-right-diagonal board)])

(defn get-winning-positions [board]
  (concat (get-rows board)
          (get-columns board)
          (get-diagonals board)))

(defn update-board
  ([location mark]
   (update-board location mark empty-board))
  ([location mark board]
   (assoc board location mark)))
