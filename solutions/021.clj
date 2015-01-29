(def sqrt
  #(Math/pow % 0.5))

(defn factors [n]
  (->> (range 1 (sqrt n))
       (filter #(zero? (mod n %)))
       (map #(vector % (quot n %)))
       (flatten)
       (remove #(= n %))))

(def d
  (memoize (fn ^long [^long n]
    (reduce + (factors n)))))

(defn amicable? [^long n]
  (and (not (= n (d n)))
       (= n (d (d n)))))

(defn solution []
  (reduce + (flatten (filter amicable? (range 1 10000)))))
