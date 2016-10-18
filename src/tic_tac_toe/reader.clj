(ns tic-tac-toe.reader)

(defn get-location
  []
  (let [input (read-line)] 
    (dec (read-string input))))
