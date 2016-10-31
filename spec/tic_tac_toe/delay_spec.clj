(ns tic-tac-toe.delay_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.delay :refer :all]))

(describe "Delay"
          (with-stubs)
          
          (it "should sleep"
              (with-redefs [sleep (stub :sleep)]
                (delay))
              (should-have-invoked :sleep)))
