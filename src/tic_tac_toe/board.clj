(ns tic-tac-toe.board)

(def empty-board
  (apply vector (take 9 (repeat nil))))

(defn update-board
  ([location mark]
   (update-board location mark empty-board))
  ([location mark board]
   (assoc board location mark)))

(defn- check-set
  [cell-set mark]
  (every? #{mark} cell-set))

(defn- get-rows
  [board]
  (partition 3 board))

(defn get-columns
  [board]
  (apply map vector (partition 3 board)))

(defn remove-indexes
  [indexed-board]
  (into [] (map last indexed-board)))

(defn- get-left-diagonal
  [board]
  (let [indexed-board (map-indexed vector board)
        even-indexes (filter (fn [[index element]] (even? index)) indexed-board)] 
    (remove-indexes (filter (fn [[index element]] ( = 0 (rem index 4))) even-indexes))))

(defn- get-right-diagonal
  [board]
  ["1"])

(defn get-diagonals
  [board]
  [(get-left-diagonal board)  [nil nil nil]]
  )

(defn- is-a-row-win?
  [board mark]
  (let [rows (get-rows board)
        winning-positions (map #(check-set % mark) rows)]
    (reduce #(or %1 %2) winning-positions)))

(defn- is-a-column-win?
  [board mark]
  (let [columns (get-columns board)
        winning-positions (map #(check-set % mark) columns)]
    (reduce #(or %1 %2) winning-positions)))

(defn- is-a-diagonal-win?
  [board mark]
  (let [diagonals (get-diagonals board)
        winning-positions (map #(check-set % mark) diagonals)]
    (reduce #(or %1 %2) winning-positions)))

(defn is-won?
  [board mark-one mark-two]
  (or
    (or (is-a-row-win? board mark-one) (is-a-row-win? board mark-two))
    (or (is-a-column-win? board mark-one) (is-a-column-win? board mark-two))
    (or (is-a-diagonal-win? board mark-one) (is-a-diagonal-win? board mark-two))))

