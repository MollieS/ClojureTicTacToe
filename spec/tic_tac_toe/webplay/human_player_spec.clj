(ns tic-tac-toe.webplay.human-player-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.webplay.human_player :refer :all]))

(describe "Human Player"
          (it "should return an int of a string"
              (should= 1 (get-move "1")))
          )
