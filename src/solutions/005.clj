(ns solutions.005)

(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (rem a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn solution []
  (reduce lcm (range 1 20)))
