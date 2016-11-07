(ns tic-tac-toe.cli.game-types
  (:require [tic-tac-toe.cli.human-player :as human-player]
            [tic-tac-toe.players.delay-player :as unbeatable-player]))

(defn get-game [game-type]
  (let [human-move human-player/get-move
        computer-move unbeatable-player/get-move]
    (cond
      (= game-type :human-v-human) [human-move human-move]
      (= game-type :human-v-computer) [human-move computer-move]
      (= game-type :computer-v-computer) [computer-move computer-move]
      (= game-type :computer-v-human) [computer-move human-move])))
