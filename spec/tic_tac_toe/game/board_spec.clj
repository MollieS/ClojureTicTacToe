(ns tic-tac-toe.game.board_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.game.board :refer :all]))

(describe "Board"
          (it "updates an empty board at given position with given mark"
              (should= ["X" nil nil nil nil nil nil nil nil]
                       (update-board 0 "X")))

          (it "updates a given board at given position with given mark"
              (should= ["X" "O" nil]
                       (update-board 1 "O" ["X" nil nil])))

          (it "can seperate the rows"
              (let [winning-positions
                    (get-winning-positions [1 2 3 4 5 6 7 8 9])]
                (should-contain '(1 2 3) winning-positions)
                (should-contain '(4 5 6) winning-positions)
                (should-contain '(7 8 9) winning-positions)))

          (it "can seperate the columns"
              (let [winning-positions
                    (get-winning-positions [1 2 3 4 5 6 7 8 9])]
                (should-contain '(1 4 7) winning-positions)
                (should-contain '(2 5 8) winning-positions)
                (should-contain '(3 6 9) winning-positions)))

          (it "can seperate the diagonals"
              (let [winning-positions
                    (get-winning-positions [1 2 3 4 5 6 7 8 9])]
                (should-contain '(1 5 9) winning-positions)
                (should-contain '(3 5 7) winning-positions))))
