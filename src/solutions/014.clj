(ns solutions.014)

(defn collatz-length
  ^long [^long n]
  (loop [x n acc 1]
    (if (= 1 x)
      acc
      (recur (if (zero? (rem x 2))
               (bit-shift-right x 1)
               (inc (* 3 x)))
             (inc acc)))))

(defn max-collatz [[^long a ^long ac] ^long b]
  (let [bc (long (collatz-length b))]
    (if (> bc ac)
      [b bc]
      [a ac])))

(defn solution
  []
  (first (reduce max-collatz [1 1] (range 1 1e6))))
