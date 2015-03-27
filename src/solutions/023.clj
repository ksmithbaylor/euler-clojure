(ns solutions.023)

(defn sqrt ^double [^long n]
  (Math/sqrt n))

(defn sum-factors ^long [^long n]
  (let [end (long (sqrt n))]
    (loop [candidate 2 sum 1]
      (if (<= candidate end)
        (recur (unchecked-inc candidate)
               (if (= 0 (unchecked-remainder-int n candidate))
                 (+ sum candidate (unchecked-divide-int n candidate))
                 sum))
        (if (= n (unchecked-multiply end end))
          (unchecked-subtract sum end)
          sum)))))

(defn abundant? ^Boolean [^long n]
  (> (sum-factors n) n))

(defn abundants-below [^long n]
  (filter abundant? (range 1 n)))

(defn solution []
  (let [limit 28123
        abundants (vec (abundants-below limit))
        max-index (dec (count abundants))]
    (->> (range 1 limit)
         (pmap (fn ^long [^long n]
                (if (loop [i 0 a (nth abundants i)]
                      (if (>= a n)
                        false
                        (if (abundant? (unchecked-subtract n a))
                          true
                          (if (= i max-index)
                            false
                            (let [i (unchecked-inc i)]
                              (recur i (nth abundants i)))))))
                  0
                  n)))
         (reduce +))))
