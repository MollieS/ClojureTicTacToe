(ns tic-tac-toe.game_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.game :refer :all]))

(describe "Game"
          (with-stubs)

          (it "knows the player's mark when X"
              (should= "X" (player-mark true)))

          (it "knows the player's mark when O"
              (should= "O" (player-mark false)))

          )




