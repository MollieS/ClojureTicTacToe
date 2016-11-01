(ns tic-tac-toe.cli.reader_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.cli.reader :refer :all]))

(describe "Reader"

          (it "reads user input"
              (should= "1" (with-in-str "1\n" (read-input)))))
