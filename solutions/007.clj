; Adapted from http://diditwith.net/2009/01/20/YAPESProblemSevenPart2.aspx
; and http://stackoverflow.com/a/7625207
(defn lazy-primes
  "Generates an infinite, lazy sequence of prime numbers"
  ([] (lazy-primes {} 2))
  ([table cand] ; table maps primes to their factors.
   ; reinsert "adds" factor to the list at table[factor + x].
   (let [reinsert (fn [table x factor]
                    (update-in table [(+ factor x)] conj factor))]
     ; if table contains the current candidate, "remove" it and
     ; reinsert all of its factors. if the table doesn't contain
     ; the candidate (meaning it is prime), emit it from the lazy
     ; sequence and "add" its square to the table.
     (if-let [factors (table cand)]
       (recur (reduce #(reinsert %1 cand %2)
                      (dissoc table cand)
                      factors)
              (inc cand))
       (lazy-seq (cons cand (lazy-primes (assoc table (* cand cand) (vector cand))
                                         (inc cand))))))))

(defn solution []
  (nth (lazy-primes) 10000))
