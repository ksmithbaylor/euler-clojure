(ns solutions.012
  (:require [solutions.010 :as s10]))

(defn triangle
  ^long [^long n]
  (unchecked-multiply n (unchecked-divide-int (unchecked-add n 1) 2)))

(declare primes)
(defn prime-factors
  [^long n]
  (loop [x n
         primes primes
         factors []]
    (if (seq primes)
      (let [[p & ps] primes]
        (cond (= 1 x)
                factors
              (zero? (unchecked-remainder-int x p))
                (recur (unchecked-divide-int x p) primes (conj factors p))
              :else
                (recur x ps factors)))
      factors)))

(defn num-factors
  [^long n]
  (->> (prime-factors n)
       (group-by identity)
       (vals)
       (map (comp inc count))
       (reduce *)))

(declare triangle-numbers)
(defn first-with-over-n-factors
  [^long n]
  (first (drop-while #(< (num-factors %) n) triangle-numbers)))

(defn solution
  []
  (def triangle-numbers
    (map triangle (iterate inc 1)))
  (def primes (s10/primes-below 250000))
  (first-with-over-n-factors 500))
