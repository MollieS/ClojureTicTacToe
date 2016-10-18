(ns tic-tac-toe.board_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.board :refer :all]))

(describe "Board" 
          (it "updates an empty board at given position with given mark"
              (should= ["X" nil nil nil nil nil nil nil nil] (update-board 0 "X")))

          (it "updates a given board at given position with given mark"
              (should= ["X" "O" nil nil nil nil nil nil nil] (update-board 1 "O" ["X" nil nil nil nil nil nil nil nil])))

          (it "knows if there is a winning combination in a row"
              (should= true (is-won? ["X" "X" "X" nil nil nil nil nil nil] "X" "O")))

          (it "knows if there is not winning combination in a row"
              (should= false (is-won? ["X" "O" "X" nil nil nil nil nil nil] "X" "O")))

          (it "knows if there is not winning combination in a row"
              (should= false (is-won? ["X" "O" "X" nil nil nil nil nil nil] "O" "X")))

          (it "knows if there is a winning combination in the second row"
              (should= true (is-won? [nil nil nil "X" "X" "X" nil nil nil] "X" "O")))

          (it "knows if there is a winning combination in the third row"
              (should= true (is-won? [nil nil nil nil nil nil "X" "X" "X"] "X" "O")))

          (it "knows if there is a winning combination in the third row"
              (should= true (is-won? [nil nil nil nil nil nil "X" "X" "X"] "X" "O")))

          (it "knows if there is a winning combination in the first column"
              (should= true (is-won? ["X" nil nil "X" nil nil "X" nil nil] "X" "O")))

          (it "knows if there is a winning combination in the second column"
              (should= true (is-won? [nil "X" nil nil "X" nil "nil X" nil] "X" "O")))

          (it "knows if there is a winning combination in the third column"
              (should= true (is-won? [nil nil "X" nil nil "X" nil nil "X"] "X" "O")))

          (it "knows if there is a winning combination in the left diagonal"
              (should= true (is-won? ["X" nil nil nil "X" nil nil nil "X"] "X" "O"))))

