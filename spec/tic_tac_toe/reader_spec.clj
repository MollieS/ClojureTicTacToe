(ns tic-tac-toe.reader_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.reader :refer :all]))

(describe "Reader"

          (it "should take user input and return valid location"
              (should= 0 (with-in-str "1\n" (get-location))))

          (it "should return nil for invalid input"
              (should= nil (with-in-str "invalid\n (get-location")))
          )
