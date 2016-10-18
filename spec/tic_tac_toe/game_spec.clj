(ns tic-tac-toe.game_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.display :as display]
            [tic-tac-toe.reader :as reader]
            [tic-tac-toe.game :refer :all]))

(describe "Game"
          (with-stubs)

          (it "knows the player's mark when X"
              (should= "X" (player-mark true)))

          (it "knows the player's mark when O"
              (should= "O" (player-mark false)))
          
          (it "knows when the game is over"
              (should= true (is-over? ["X" "X" "X" nil nil nil nil "O" "O"])))

          (it "greets the player"
              (with-redefs [start-play (stub :start-play {:return "game is started"})
                            display/greet (stub :greet) {:return "greeting"}]
              (start))
              (should-have-invoked :greet))

          (it "shows the board"
              (with-redefs [start-play (stub :start-play {:return "game is started"})
                            display/show-board (stub :show-board) {:return "board shown"}]
              (start))
              (should-have-invoked :show-board))

          (it "starts play"
              (with-redefs [start-play (stub :start-play {:return "game is started"})]
              (start))
              (should-have-invoked :start-play))

          (it "starts the game with an empty board and player one as true"
              (with-redefs [play-game (stub :play-game {:return "play has begun"})
                            reader/get-location (stub :get-location {:return "1"})]
              (start-play))
              (should-have-invoked :play-game {:with [0 [nil nil nil nil nil nil nil nil nil] true]}))

          (it "prompts player"
              (with-redefs [play-game (stub :play-game {:return "game is playing"})
                            reader/get-location (stub :get-location {:return "1"})
                            display/prompt-player (stub :prompt-player) {:return "player prompt shown"}]
              (start))
              (should-have-invoked :prompt-player))

          (it "shows the winner"
              (should-contain "X wins" (with-out-str (play-game 2 ["X" "X" nil nil nil nil nil "O" "O"] true))))
          )




