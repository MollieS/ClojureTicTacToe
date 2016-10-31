(ns tic-tac-toe.marks_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.marks :refer :all]))

(describe "Marks"

          (it "knows player-one mark"
              (should= "X" mark-one))

          (it "knows player-two mark"
              (should= "O" mark-two))

          (it "knows the order of the marks when it is player one's turn"
              (should= ["X" "O"] (get-mark-order true)))

          (it "knows the order of the marks when it is player two's turn"
              (should= ["O" "X"] (get-mark-order false)))

          (it "returns the current mark when it is player one's turn"
              (should= "X" (get-current-mark true)))

          (it "returns the current mark when it is player two's turn"
              (should= "O" (get-current-mark false)))
          )
