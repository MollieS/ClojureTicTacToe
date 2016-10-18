(ns tic-tac-toe.display)

(defn cell-empty?
  [cell]
  (= cell nil))

(defn get-mark
  [cell]
  (if (cell-empty? cell)
    "-"
    cell))

(defn greet
  [] (println "Welcome to Tic Tac Toe\n"))

(defn prompt-player
  [] (println "Where would you like to make a move?\n"))

(defn show-board
  [board]
  (let [[row-one row-two row-three] (partition 3 board)]
    (println (apply str (map #(str "|" (get-mark %) "|") row-one)  ))
    (println (apply str (map #(str "|" (get-mark %) "|") row-two)  ))
    (println (apply str (map #(str "|" (get-mark %) "|") row-three)  )))
  )

