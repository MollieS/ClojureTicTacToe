(ns tic-tac-toe.input_validator_spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.input-validator :refer :all]))

(def board ["X" nil nil])

(describe "Input Validator"
          
          (it "knows if input is not a number"
              (should= true (invalid? "hello" board)))
          
          (it "knows if input is a number"
              (should= false (invalid? "2" board)))

          (it "knows if input is out of range" 
              (should= true (invalid? "20" board)))

          (it "knows if input is in range" 
              (should= false (invalid? "2" board)))

          (it "knows if cell is occupied"
              (should= true (invalid? "1" board)))

          (it "knows if cell is not occupied"
              (should= false (invalid? "2" board)))

          (it "gives correct message for invalid input"
              (should= "hello is not a number" (validate "hello" board)))

          (it "gives correct message for out-of-range input"
              (should= "20 is out of range" (validate "20" board)))

          (it "gives correct message for occupied cell input"
              (should= "board is occupied at 1" (validate "1" board)))
          )
