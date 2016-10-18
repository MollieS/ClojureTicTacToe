(ns tic-tac-toe.display-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.display :refer :all]))

(describe "Display"
          (it "prints a welcome message"
              (should= "Welcome to Tic Tac Toe\n\n" (with-out-str (greet))))

          (it "prints an empty board"
              (should= "|-||-||-|\n|-||-||-|\n|-||-||-|\n" (with-out-str (show-board [nil nil nil nil nil nil nil nil nil]))))

          (it "prints a board with a mark"
              (should= "|X||-||-|\n|-||-||-|\n|-||-||-|\n" (with-out-str (show-board ["X" nil nil nil nil nil nil nil nil]))))

          (it "prompts player for move"
              (should= "Where would you like to make a move?\n\n" (with-out-str (prompt-player))))

          (it "knows if a cell is empty"
              (should= true (cell-empty? nil)))

          (it "knows if a cell is not empty"
              (should= false (cell-empty? "X")))

          (it "returns the correct symbol for an empty cell"
              (should= "-" (get-mark nil)))

          (it "returns the correct symbol for a marked cell"
              (should= "X" (get-mark "X")))

          (it "prints the winner"
              (should= "X wins!\n" (with-out-str (show-winner "X"))))

          (it "clears the screen"
              (should= "\033[2J\033[;H\n" (with-out-str (clear-screen))))) 

          (it "prints an invalid location message"
              (should= "hello is not a valid location" (with-out-str (invalid-location "hello"))))  
