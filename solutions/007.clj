(defn primes "Generates an infinite, lazy sequence of prime numbers"
  ([] (primes {} 2))
  ([table prime]
   (let [reinsert (fn [table x factor] (update-in table [(+ factor x)] conj factor))]
     (if-let [factors (table prime)]
       (recur (reduce #(reinsert %1 prime %2) (dissoc table prime) factors) (inc prime))
       (lazy-seq (cons prime (primes (assoc table (* prime prime) (vector prime)) (inc prime))))))))

(defn solution []
  (last (take 10001 (primes))))
