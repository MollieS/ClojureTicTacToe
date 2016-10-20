(ns tic-tac-toe.human-player_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.display :as display]
            [tic-tac-toe.reader :as reader]
            [tic-tac-toe.human-player :refer :all]))

(describe "Human Player"
          (with-stubs)

          (it "prompts for locations"
              (with-redefs [display/prompt-player (stub :prompt-player)
                            reader/read-input (stub :read-input {:return "1"})]
                (get-move [nil nil nil] nil))
              (should-have-invoked :prompt-player))

          (it "reads input"
              (with-redefs [reader/read-input (stub :read-input {:return "1"})]
                (get-move [nil nil nil] nil)
                (should-have-invoked :read-input)))

          (it "decreases valid move"
              (should= 0 (with-in-str "1\n" (get-move [nil nil nil] ["X" "O"])))))
