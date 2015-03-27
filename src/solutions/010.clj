(ns solutions.010
  (:require [solutions.007 :as s7]))

(defn solution
  []
  (reduce + (take-while (partial > 2e6)
                        (s7/lazy-primes))))
