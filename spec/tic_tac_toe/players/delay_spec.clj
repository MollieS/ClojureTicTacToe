(ns tic-tac-toe.players.delay_player_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.players.delay-player :refer :all]))

(describe "Delay"
          (with-stubs)

          (it "should sleep"
              (with-redefs [sleep (stub :sleep)]
                (get-move ["X" "X" "X"] ["X", "O"]))
              (should-have-invoked :sleep)))
