(ns tic-tac-toe.input-validator)

(defn not-a-number?  [input]
  (let [location (read-string input)]
    (not (number? location))))

(defn out-of-range?  [input board]
  (< (count board) (read-string input)))

(defn occupied?  [input board]
  (not (nil? (get board (dec (read-string input))))))

(defn validate [input board]
  (cond
    (not-a-number? input) (str input " is not a number")
    (out-of-range? input board) (str input " is out of range")
    (occupied? input board) (str "board is occupied at " input)))

(defn invalid?  [input board]
  (if (not-a-number? input)
    true
    (or
      (out-of-range? input board)
      (occupied? input board))))
