(ns tic-tac-toe.webplay.web-game
  (:require [clojure.string :as str]
            [tic-tac-toe.game.marks :as marks]
            [tic-tac-toe.game.board :as board]
            [tic-tac-toe.game.rules :as rules]
            [tic-tac-toe.players.unbeatable-player :as computer-player]
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

(defn player-one? [board-state]
  (= marks/mark-one (get-current-player board-state)))

(defn format-element [element]
  (if (= "-" (str element))
    nil
    (str element)))

(defn format-board [board-state]
  (into [] (map #(format-element %) (seq board-state))))

(defn is-over? [board-state]
  (let [board (format-board board-state)]
    (game/is-game-over? board)))

(defn mark-board [board-state location]
  (let [current-board (into [] (map #(str %) (seq board-state)))]
    (if (= "-" (get current-board location))
      (str/join (board/update-board location (get-current-player board-state) current-board))
      board-state)))

(defn get-updated-board-state [board-state location]
  (if (is-over? board-state)
    board-state
    (mark-board board-state location)))

(defn play-move [board-state location game-type]
  (let [marked-board (get-updated-board-state board-state location)]
    (if (= game-type "hvh")
      marked-board
      (recur marked-board
             (computer-player/get-move (format-board marked-board)
                                       (marks/get-mark-order (player-one? marked-board)))
             "hvh"))))

(defn draw? [board-state]
  (rules/is-drawn? (format-board board-state)
                   marks/mark-one
                   marks/mark-two))

(defn winning-symbol [board-state]
  (let [winning-positions (board/get-winning-positions (format-board board-state))]
    (rules/get-winner winning-positions marks/mark-one marks/mark-two)))
