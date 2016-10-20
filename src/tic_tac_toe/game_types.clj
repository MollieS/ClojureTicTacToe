(ns tic-tac-toe.game_types
  (:require [tic-tac-toe.human-player :as human-player]
            [tic-tac-toe.unbeatable-player :as computer-player]))

(defn get-game [game-type]
  (cond
    (= game-type :human-v-human) [human-player/get-move human-player/get-move]
    (= game-type :human-v-computer) [human-player/get-move computer-player/get-move]
    (= game-type :computer-v-computer) [computer-player/get-move computer-player/get-move]
    (= game-type :computer-v-human) [computer-player/get-move human-player/get-move]))
