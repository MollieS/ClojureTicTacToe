(ns tic-tac-toe.cli.game_types_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.cli.game-types :refer :all]))

(describe "Game Types"
          (it "returns human-player functions for a human v human game"
              (should-be-a tic_tac_toe.cli.human_player$get_move
                           (first (get-game :human-v-human)))
              (should-be-a tic_tac_toe.cli.human_player$get_move
                           (second (get-game :human-v-human))))

          (it "returns human-player and computer-player functions for a human v computer game"
              (should-be-a tic_tac_toe.cli.human_player$get_move
                           (first (get-game :human-v-computer)))
              (should-be-a tic_tac_toe.players.unbeatable_player$get_move
                           (second (get-game :human-v-computer))))

          (it "returns computer-player functions for a computer v computer game"
              (should-be-a tic_tac_toe.players.unbeatable_player$get_move
                           (first (get-game :computer-v-human)))
              (should-be-a tic_tac_toe.cli.human_player$get_move
                           (second (get-game :computer-v-human))))

          (it "returns computer-player functions for a computer v computer game"
              (should-be-a tic_tac_toe.players.unbeatable_player$get_move
                           (first (get-game :computer-v-computer)))
              (should-be-a tic_tac_toe.players.unbeatable_player$get_move
                           (second (get-game :computer-v-computer)))))
