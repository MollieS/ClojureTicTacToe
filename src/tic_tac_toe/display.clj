(ns tic-tac-toe.display)

(defn write [message]
  (println message))

(defn cell-empty? [cell]
  (nil? cell))

(defn get-mark [cell]
  (if (cell-empty? cell)
    "-"
    cell))

(defn greet []
  (write "Welcome to Tic Tac Toe\n"))

(defn prompt-player []
  (write "Where would you like to make a move?\n"))

(defn show-winner [winner]
  (write (str winner " wins!")))

(defn clear-screen []
  (write "\033[2J\033[;H"))

(defn invalid-location [input]
  (write (str input " is not a valid location")))

(defn- format-row [row]
  (apply str (map #(str "|" (get-mark %) "|") row)))

(defn show-board [board]
  (let [[row-one row-two row-three] (partition 3 board)]
    (write (format-row row-one))
    (write (format-row row-two))
    (write (format-row row-three))))

(defn ask-for-replay []
  (write "Would you like to play again?"))

(defn goodbye []
  (write "Goodbye!"))
