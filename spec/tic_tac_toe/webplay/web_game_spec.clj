(ns tic-tac-toe.webplay.web_game_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.webplay.web-game :refer :all]))

(describe "Web Game" 

          (it "should know the current player when the board is empty"
              (should= "X" (get-current-player "---------")))

          (it "should know the current player when it is O's turn"
              (should= "O" (get-current-player "X--------")))

          (it "should know the current player when it is X's turn"
              (should= "X" (get-current-player "XO-------")))

          (it "should know when the game is over"
              (should= true (is-over? "XXX------")))

          (it "should place a mark on a board"
              (should= "X--------" (play-move "---------" 0 "hvh")))

          (it "should place the correct mark on the board"
              (should= "XO-------" (play-move "X--------" 1 "hvh")))

          (it "should not place a mark on the board if game is over"
              (should= "XXX------" (play-move "XXX------" 4 "hvh")))

          (it "does not let a mark be overridden"
              (should= "XOX------" (play-move "XOX------" 0 "hvh")))

          (it "plays a computer move when the computer is the second player"
              (should= "O---X----" (play-move "---------" 4 "hvc")))

          (it "plays a computer move when the computer is the first player"
              (should= "X--------" (play-move "---------" -1 "cvh")))

          (it "knows if it is a draw" 
              (should= true (draw? "XOXOXOOXX")))

          (it "knows the winning symbol" 
              (should= "X" (winning-symbol "XXXOO----"))))
