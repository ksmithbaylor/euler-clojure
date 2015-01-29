(defn gcd
  [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn lcm
  "least common multiple of two positive integers"
  [a b]
  (/ (* a b) (gcd a b)))

(defn solution
  []
  (reduce lcm (range 1 20)))
