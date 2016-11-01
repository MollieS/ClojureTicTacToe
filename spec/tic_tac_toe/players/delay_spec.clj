(ns tic-tac-toe.players.delay_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.players.delay :refer :all]))

(describe "Delay"
          (with-stubs)
          
          (it "should sleep"
              (with-redefs [sleep (stub :sleep)]
                (delay))
              (should-have-invoked :sleep)))
