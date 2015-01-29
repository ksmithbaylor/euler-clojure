(defn primes-below
  [limit]
  (let [bs (java.util.BitSet. limit)]
    (.flip bs 0 2)
    (doseq [i (range 2 limit)]
      (if (not (.get bs i))
        (doseq [j (range (+ i i) limit i)]
          (.set bs j))))
    (remove #(.get bs %) (range limit))))

(defn solution
  []
  (reduce + (primes-below 2e6)))
