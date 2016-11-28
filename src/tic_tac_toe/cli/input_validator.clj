(ns tic-tac-toe.cli.input-validator
  (:require [clojure.string :as str]))

(defn not-a-number? [input]
  (let [letters (re-find #"[^0-9]" input)]
    (< 0 (count letters))))

(defn- out-of-range? [input board]
  (let [input (read-string input)]
    (or
      (< (count board) input)
      (> 1 input))))

(defn- occupied? [input board]
  (not (nil? (get board (dec (read-string input))))))

(defn empty-string? [input]
  (or (= "\n" input)
      (str/blank? input)))

(defn validate [input board]
  (cond
    (empty-string? input) "please choose a number"
    (not-a-number? input) (str input " is not a number")
    (out-of-range? input board) (str input " is out of range")
    (occupied? input board) (str "board is occupied at " input)))

(defn invalid? [input board]
  (cond
    (empty-string? input) true
    (not-a-number? input) true
    (out-of-range? input board) true
    (occupied? input board) true
    :else false))
