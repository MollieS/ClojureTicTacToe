(ns tic-tac-toe.rules)

(defn- check-set [cell-set mark]
  (every? #{mark} cell-set))

(defn- is-full? [winning-positions]
  (reduce #(and %1 %2) (map #(not (nil? %)) (flatten winning-positions))))

(defn- is-a-win? [cell-collection mark]
  (let [winning-positions (map #(check-set % mark) cell-collection)]
    (reduce #(or %1 %2) winning-positions)))

(defn is-won-by? [winning-positions mark]
  (is-a-win? winning-positions mark))

(defn is-won? [winning-positions mark-one mark-two]
  (or (is-a-win? winning-positions mark-one)
      (is-a-win? winning-positions mark-two)))

(defn is-drawn? [winning-positions mark-one mark-two]
  (and (is-full? winning-positions)
       (not (is-won? winning-positions mark-one mark-two))))

(defn is-over? [winning-positions mark-one mark-two]
  (or (is-won? winning-positions mark-one mark-two)
      (is-drawn? winning-positions mark-one mark-two)))

(defn get-winner [winning-positions mark-one mark-two]
  (cond
    (is-won-by? winning-positions mark-one) mark-one
    (is-won-by? winning-positions mark-two) mark-two
    :else nil))
