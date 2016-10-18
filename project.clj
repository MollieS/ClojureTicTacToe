(defproject tic-tac-toe "0.1.0-SNAPSHOT"
  :description "Tic Tac Toe"
  :url "N/A"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC2"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"] [lein-cloverage "1.0.7"]]
  :main tic-tac-toe.core
  :test-paths ["spec"])
