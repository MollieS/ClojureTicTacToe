(ns tic-tac-toe.cli.game-runner_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.cli.display :as display]
            [tic-tac-toe.game.game :as game]
            [tic-tac-toe.cli.reader :as reader]
            [tic-tac-toe.cli.game-runner :refer :all]))


(describe "Game Runner"
        (with-stubs)

        (it "greets player"
            (with-redefs [start-game (stub :start-game {:return "game started"})
                          get-players (stub :get-players {:return nil})
                          display/clear-screen (stub :clear-screen)
                          replay? (stub :replay {:return false})]
              (should-contain "Welcome to Tic Tac Toe"
                              (with-out-str (start)))))

        (it "asks for player choice"
            (with-redefs [start-game (stub :start-game {:return "game started"})
                          reader/read-input (stub :read-input {:return "1"})
                          display/clear-screen (stub :clear-screen)
                          replay? (stub :replay {:return false})]
              (should-contain "What game would you like to play?"
                              (with-out-str (start)))))

        (it "converts player choice to human v human keyword"
            (with-redefs [start-game (stub :start-game {:return "game started"})
                          reader/read-input (stub :read-input {:return "1"})
                          display/clear-screen (stub :clear-screen)
                          replay? (stub :replay {:return false})]
              (should= :human-v-human
                       (get-menu-choice))))

        (it "converts player choice to computer v human keyword"
            (with-redefs [start-game (stub :start-game {:return "game started"})
                          reader/read-input (stub :read-input {:return "2"})
                          display/clear-screen (stub :clear-screen)
                          replay? (stub :replay {:return false})]
              (should= :human-v-computer
                       (get-menu-choice))))

        (it "converts player choice to computer v human keyword"
            (with-redefs [start-game (stub :start-game {:return "game started"})
                          reader/read-input (stub :read-input {:return "3"})
                          display/clear-screen (stub :clear-screen)
                          replay? (stub :replay {:return false})]
              (should= :computer-v-human
                       (get-menu-choice))))

        (it "converts player choice to computer v computer keyword"
            (with-redefs [start-game (stub :start-game {:return "game started"})
                          reader/read-input (stub :read-input {:return "4"})
                          display/clear-screen (stub :clear-screen)
                          replay? (stub :replay {:return false})]
              (should= :computer-v-computer
                       (get-menu-choice))))

        (it "asks for replay"
            (with-redefs [start-game (stub :start-game {:return "game started"})
                          reader/read-input (stub :read-input {:return "no"})
                          get-players (stub :get-players {:return nil})
                          display/clear-screen (stub :clear-screen)]
              (should-contain "Would you like to play again?"
                              (with-out-str (start)))))

        (it "says goodbye if replay option is no"
            (with-redefs [start-game (stub :start-game {:return "game started"})
                          reader/read-input (stub :read-input {:return "no"})
                          get-players (stub :get-players)
                          display/clear-screen (stub :clear-screen)]
              (should-contain "Goodbye!"
                              (with-out-str (start)))))

        (it "displays the winner if game is won"
            (with-redefs [reader/read-input (stub :read-input {:return "no"})
                          game/get-winner (stub :get-winner {:return "X"})
                          get-players (stub :get-players {:return nil})
                          display/clear-screen (stub :clear-screen)]
              (should-contain "X wins!"
                              (with-out-str (show-result ["X" "X" "X"])))))

        (it "displays the draw message if game is drawn"
            (with-redefs [reader/read-input (stub :read-input {:return "no"})
                          game/get-winner (stub :get-winner {:return nil})
                          get-players (stub :get-players {:return nil})
                          display/clear-screen (stub :clear-screen)]
              (should-contain "It's a draw"
                              (with-out-str (show-result ["X" "O" "X"]))))))
