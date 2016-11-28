# Clojure Tic Tac Toe

[![Build Status](https://travis-ci.org/MollieS/ClojureTicTacToe.svg?branch=master)](https://travis-ci.org/MollieS/ClojureTicTacToe)

Tic Tac Toe command line application built in Clojure

### Requirements

* Clojure 1.8.0
* Leiningen 2.7.1
* Java 8

### How to run

* `git clone git@github.com:MollieS/ClojureTicTacToe.git`
* `cd ClojureTicTacToe`
* `lein run`

### How to test

* From within the repository, run `lein spec`

### Web Jar

* This project also includes a package intended to be used with a Java Project.  It offers five static methods that can be used in a Java project, defined in the core file. 

* To use this jar, run the command `lein uberjar` in the repository.  The jar will be created in the target directory and can then be copied to the lib folder of a Java project to use.
