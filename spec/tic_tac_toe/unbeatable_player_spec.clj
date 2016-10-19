(ns tic-tac-toe.unbeatable_player_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.unbeatable-player :refer :all]))

(describe "Unbeatable Player"

          (it "knows its mark"
              (should= "O" (get-mark)))

          (it "knows the available moves"
              (should= [0 1 2 3 4 5 6 7 8] (available-moves [nil nil nil nil nil nil nil nil nil])))

          (it "knows when a move is not available"
              (should= [1 2 3 4 5 6 7 8] (available-moves ["X" nil nil nil nil nil nil nil nil])))

          (it "chooses the only free space on a board"
              (should= 8 (get-move ["X" "O" "X" "O" "X" "O" "O" "X" nil])))

          (it "gets the correct score if it wins"
              (should= 2 (get-move ["O" "O" nil "O" "X" "X" "X" "X" nil])))

           (it "goes for a win if possible"
              (should= 2 (get-move ["O" "O" nil "O" "X" "X" "X" "X" nil])))

          (it "blocks if has to"
              (should= 2 (get-move ["X" "X" nil "X" "O" "O" "O" "X" nil])))

          (it "goes for a corner if board is empty"
              (should= 0 (get-move [nil nil nil nil nil nil nil nil nil])))

          (it "goes for the centre if corner is taken"
              (should= 4 (get-move ["X" nil nil nil nil nil nil nil nil])))

          (it "goes for a win"
              (should= 5 (get-move ["X" nil nil "O" "O" nil "X" nil "X"])))

          (it "goes for a block"
              (should= 1 (get-move ["X" nil "X" nil "O" nil nil nil nil])))

          (it "goes for a win over a block"
              (should= 7 (get-move ["X" "O" "X" nil "O" nil "X" nil nil]))))
