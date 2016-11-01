(ns tic-tac-toe.game.rules_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.game.rules :refer :all]))

(describe "Rules"

          (it "knows the winner when it is O"
              (should= "O" (get-winner [["O" "O" "O"]] "X" "O")))

          (it "knows the winner when it is X"
              (should= "X" (get-winner [["X" "X" "X"]] "X" "O")))

          (it "knows if it is a draw"
              (should= true (is-drawn? [["X" "O" "X"]] "X" "O")))

          (it "knows if it is not a draw"
              (should= false (is-drawn? [["X" "X" "X"]] "X" "O")))

          (it "knows when the game is won by X"
              (should= true (is-won? [["X" "X" "X"]] "X" "O")))

          (it "knows when the game is won by O"
              (should= true (is-won? [["O" "O" "O"]] "X" "O")))

          (it "knows if the game is over when won"
              (should= true (is-over? [["X" "X" "X"]] "X" "O")))

          (it "knows if the game is over when drawn"
              (should= true (is-over? [["X" "O" "X"]] "X" "O")))

          (it "knows if the game is not over when the board is empty"
              (should= false
                       (is-over? [[nil nil nil] [nil nil nil] [nil nil nil]] "X" "O")))

          (it "knows if the game is not over when the board is not empty"
              (should= false
                       (is-over? [[nil nil nil] ["X" nil "O"] [nil nil nil]] "X" "O"))))
