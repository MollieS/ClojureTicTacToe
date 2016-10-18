(ns tic-tac-toe.board)

(def empty-board
  (apply vector (take 9 (repeat nil))))

(defn- check-set
  [cell-set mark]
  (every? #{mark} cell-set))

(defn- get-rows
  [board]
  (partition 3 board))

(defn- get-columns
  [board]
  (apply map vector (partition 3 board)))

(defn- remove-indexes
  [indexed-board]
  (into [] (map last indexed-board)))

(defn- get-indexed-diagonals
  [board]
  (let [indexed-board (map-indexed vector board)
        even-indexes (filter (fn [[index element]] (even? index)) indexed-board)]
    even-indexes))

(defn- get-left-diagonal
  [board]
  (let [diagonals (get-indexed-diagonals board)] 
    (remove-indexes (filter (fn [[index element]] (= 0 (rem index 4))) diagonals))))

(defn- get-right-diagonal
  [board]
  (let [diagonals (get-indexed-diagonals board)]
    (remove-indexes (filter (fn [[index element]] (and (> index 0) (< index 8))) diagonals))))

(defn- get-diagonals
  [board]
  [(get-left-diagonal board) (get-right-diagonal board)])

(defn- get-winning-positions
  [board]
    (concat (get-rows board) (get-columns board) (get-diagonals board)))

(defn- is-full?
  [board]
  (reduce #(and %1 %2) (map #(not (nil? %)) board)))

(defn- is-a-win?
  [cell-collection mark]
  (let [winning-positions (map #(check-set % mark) cell-collection)]
    (reduce #(or %1 %2) winning-positions)))

(defn is-won-by?
  [board mark]
  (is-a-win? (get-winning-positions board) mark))

(defn is-won?
  [board mark-one mark-two]
  (or (is-a-win? (get-winning-positions board) mark-one) (is-a-win? (get-winning-positions board) mark-two)))

(defn is-drawn?
  [board mark-one mark-two]
  (and (is-full? board)
       (not (is-won? board mark-one mark-two))))

(defn is-over?
  [board mark-one mark-two] 
  (or (is-won? board mark-one mark-two)
      (is-drawn? board mark-one mark-two)))

(defn get-winner
  [board mark-one mark-two]
  (cond 
    (is-won-by? board mark-one) mark-one
    (is-won-by? board mark-two) mark-two
    :else nil))

(defn update-board
  ([location mark]
   (update-board location mark empty-board))
  ([location mark board]
   (assoc board location mark)))

