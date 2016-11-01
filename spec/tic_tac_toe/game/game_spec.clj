(ns tic-tac-toe.game.game_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.game.rules :as rules]
            [tic-tac-toe.game.board :as board]
            [tic-tac-toe.players.unbeatable-player :as unbeatable-player]
            [tic-tac-toe.cli.human-player :as human-player]
            [tic-tac-toe.game.game :refer :all]))

(def human-player-stubs [(fn [board mark] {:move "X" :player "human"})
                         (fn [board mark] {:move "O" :player "human"})])

(defn get-move-stub [board mark] "called human mark")
(defn get-move2-stub [board mark] "called computer mark")

(def human-computer
  [human-player/get-move unbeatable-player/get-move])

(describe "Game"
          (with-stubs)

          (it "gets the first player's move in a human v human game"
              (let [move (get-player-move human-player-stubs nil true)]
                (should= "X" (:move move))
                (should= "human" (:player move))))

          (it "gets the second player's move in a human v human game"
              (let [move (get-player-move human-player-stubs nil false)]
                (should= "O" (:move move))
                (should= "human" (:player move))))

          (it "checks if the game is over"
              (with-redefs [rules/is-over? (stub :is-over?)
                            board/get-winning-positions 
                            (stub :winning-positions {:return ["X" "X" "X"]})]
                (is-game-over? ["X" "X" "X"]))
              (should-have-invoked :is-over?
                                   {:with [["X" "X" "X"] "X" "O"]}))

          (it "gives the first player the corret arguments"
              (with-redefs [board/update-board
                            (stub :update/board {:return "board-updated"})
                            get-move-stub (stub :get-move)
                            get-move2-stub (stub :get-move2)]
                (get-player-move 
                  [get-move-stub get-move2-stub] [nil nil nil] true)
                (should-have-invoked :get-move
                                     {:with [[nil nil nil] ["X" "O"]]})))

          (it "gives the second player the corret arguments"
              (with-redefs [board/update-board (stub :update/board {:return "board-updated"})
                            get-move-stub (stub :get-move)
                            get-move2-stub (stub :get-move2)]
                (get-player-move
                  [get-move-stub get-move2-stub] [nil nil nil] false)
                (should-have-invoked :get-move2
                                     {:with [[nil nil nil] ["O" "X"]]})))

          (it "knows the winner"
              (should= "X" (get-winner ["X" "X" "X" nil nil nil nil nil nil])))

          (it "knows if there is no winner"
              (should= nil (get-winner [nil nil nil nil nil nil nil nil nil]))))
