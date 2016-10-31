(ns tic-tac-toe.display-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.display :refer :all]))

(describe "Display"
          (it "prints a welcome message"
              (should= "Welcome to Tic Tac Toe\n\n"
                       (with-out-str (greet))))

          (it "prints an empty board"
              (should= "|-||-||-|\n|-||-||-|\n|-||-||-|\n"
                       (with-out-str (show-board [nil nil nil nil nil nil nil nil nil]))))

          (it "prints a board with a mark"
              (should= "|X||-||-|\n|-||-||-|\n|-||-||-|\n"
                       (with-out-str (show-board ["X" nil nil nil nil nil nil nil nil]))))

          (it "prompts player for move"
              (should= "Where would you like to make a move?\n\n"
                       (with-out-str (prompt-player))))

          (it "knows if a cell is empty"
              (should= true
                       (cell-empty? nil)))

          (it "knows if a cell is not empty"
              (should= false
                       (cell-empty? "X")))

          (it "returns the correct symbol for an empty cell"
              (should= "-"
                       (get-mark nil)))

          (it "returns the correct symbol for a marked cell"
              (should= "X"
                       (get-mark "X")))

          (it "prints the winner"
              (should= "X wins!\n"
                       (with-out-str (show-winner "X"))))

          (it "prints a message if it is a draw"
              (should= "It's a draw\n"
                       (with-out-str (draw))))

          (it "clears the screen"
              (should= "\033[2J\033[;H\n"
                       (with-out-str (clear-screen))))

          (it "prints an invalid location message"
              (should= "hello is not a valid location\n"
                       (with-out-str (invalid-location "hello"))))

          (it "prompts for a play again option"
              (should= "Would you like to play again? (yes or no)\n"
                       (with-out-str (ask-for-replay))))

          (it "prints goodbye"
              (should= "Goodbye!\n"
                       (with-out-str (goodbye))))

          (it "offers a menu"
              (should= (str "What game would you like to play?\n"
                            "1. Human v Human\n"
                            "2. Human v Unbeatable Player\n"
                            "3. Unbeatable Player v Human\n"
                            "4. Unbeatable Player v Unbeatable Player\n")
                       (with-out-str (menu)))))
