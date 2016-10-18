(ns tic-tac-toe.game_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.game :refer :all]))

(describe "Game"
          (with-stubs)

          (it "knows the player's mark when X"
              (should= "X" (player-mark true)))

          (it "knows the player's mark when O"
              (should= "O" (player-mark false)))
          
          (it "knows when the game is over"
              (should= true (is-over? ["X" "X" "X" nil nil nil nil "O" "O"])))

          (it "shows the winner"
              (should-contain "X wins" (with-out-str (play 2 ["X" "X" nil nil nil nil nil "O" "O"] true)))))




