(ns tic-tac-toe.core-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.core :refer :all]
            [tic-tac-toe.game :as game]))

(describe "TicTacToe"
          (with-stubs)

          (it "starts the game"
              (with-redefs
                [game/start (stub :start {:return "started"})]
              (-main))
              (should-have-invoked :start)))
