(ns solutions.013
  (:require [clojure.string :as s]))

(def input (slurp "inputs/013.txt"))

(def parseInt #(BigInteger. %))

(defn solution
  []
  (let [numbers (map parseInt (s/split-lines input))
        sum (reduce + numbers)
        first-ten (subs (str sum) 0 10)]
    (parseInt first-ten)))
