(ns tic-tac-toe.webplay.web-game
  (:gen-class
    :name ttt.webplay.web_game
    :methods [#^{:static true} [getCurrentMark [String] String]
              #^{:static true} [playMove [String int] String]
              #^{:static true} [isOver [String] boolean]])

  (:require [clojure.string :as str]
            [tic-tac-toe.game.marks :as marks]
            [tic-tac-toe.game.board :as board]
            [tic-tac-toe.game.game :as game]))

(defn is-empty? [board-state mark-one mark-two]
  (not (or (str/includes? board-state mark-one)
           (str/includes? board-state mark-two))))

(defn- mark-count [board-state mark]
  (count (filter #(= mark (str %))(seq board-state))))

(defn count-marks [board-state]
  (let [x-count (mark-count board-state marks/mark-one)
        o-count (mark-count board-state marks/mark-two)]
    (+ x-count o-count)))

(defn get-current-player [board-state]
  (if  (even? (count-marks board-state))
    marks/mark-one
    marks/mark-two))

(defn format-element [element]
  (if (= "-" (str element))
    nil 
    (str element)))

(defn is-over? [board-state]
  (let [board (into [] (map #(format-element %) (seq board-state)))]
    (game/is-game-over? board)))

(defn mark-board [board-state location]
      (let [current-board (into [] (map #(str %) (seq board-state)))]
            (if (= "-" (get current-board location))
            (str/join (board/update-board location (get-current-player board-state) current-board))
            board-state)))

(defn play-move [board-state location]
  (if (is-over? board-state)
    board-state 
    (mark-board board-state location)))

(defn -getCurrentMark [board-state]
  (get-current-player board-state))

(defn -isOver [board]
  (is-over? board))

(defn -playMove [board location]
  (play-move board location))

(defn -getCurrentMark [board-state]
  (get-current-player board-state))
