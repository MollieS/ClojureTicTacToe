(ns tic-tac-toe.unbeatable_player_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.unbeatable-player :refer :all]))

(def human-first ["O" "X"])
(def computer-first ["X" "O"])

(describe "Unbeatable Player"

          (it "knows the available moves"
              (should= [0 1 2 3 4 5 6 7 8] (available-moves [nil nil nil nil nil nil nil nil nil])))

          (it "knows when a move is not available"
              (should= [1 2 3 4 5 6 7 8] (available-moves ["X" nil nil nil nil nil nil nil nil])))

          (it "chooses the only free space on a board"
              (should= 8 (get-move ["X" "O" "X" "O" "X" "O" "O" "X" nil] human-first)))

           (it "goes for a win if possible"
              (should= 2 (get-move ["O" "O" nil "O" "X" "X" "X" "X" nil] human-first)))

          (it "blocks if has to"
              (should= 2 (get-move ["X" "X" nil "X" "O" "O" "O" "X" nil] human-first)))

          (it "goes for a corner if board is empty"
              (should= 0 (get-move [nil nil nil nil nil nil nil nil nil] human-first)))

          (it "goes for the centre if corner is taken"
              (should= 4 (get-move ["X" nil nil nil nil nil nil nil nil] human-first)))

          (it "goes for a win"
              (should= 5 (get-move ["X" nil nil "O" "O" nil "X" nil "X"] human-first)))

          (it "goes for a block"
              (should= 1 (get-move ["X" nil "X" nil "O" nil nil nil nil] human-first)))

          (it "goes for a win over a block1"
              (should= 7 (get-move ["X" "O" "X" "X" "O" nil nil nil nil] human-first)))

          (it "goes for a win over a block2"
              (should= 7 (get-move ["X" "O" "X" nil "O" nil "X" nil nil] human-first)))

          (it "goes for a block"
              (should= 2 (get-move ["X" nil nil nil "O" nil "O" nil "X"] computer-first)))

          (it "goes for a block"
              (should= 6 (get-move ["X" nil "O" nil "O" nil nil nil "X"] computer-first)))

          )
