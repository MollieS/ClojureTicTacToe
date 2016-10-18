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

(defn show-winner
  [winner] (println (str winner " wins!")))

(defn clear-screen
  [] (println "\033[2J\033[;H"))

(defn invalid-location
  [input] (println (str input " is not a valid location")))

(defn- format-row
  [row] 
  (apply str (map #(str "|" (get-mark %) "|") row)))

(defn show-board
  [board]
  (let [[row-one row-two row-three] (partition 3 board)]
    (println (format-row row-one))
    (println (format-row row-two))
    (println (format-row row-three))))

