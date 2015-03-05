; Has a certainty of 99.9%
(defn prime?
  [n]
  (.isProbablePrime (biginteger n) 10))

(defn get-quadratic
  [a b]
  (fn [n]
    (+ (* n n)
       (* a n)
       b)))

(defn consecutive-primes
  [quadratic]
  (count (take-while prime? (map quadratic (range)))))

(defn max-by
  [f xs]
  (reduce #(if (> (f %1) (f %2)) %1 %2) xs))

(defn solution
  []
  (->> (for [a (range -999 1000)
             b (range -999 1000)]
         [(consecutive-primes (get-quadratic a b)) a b])
       (max-by first)
       rest
       (apply *)))
