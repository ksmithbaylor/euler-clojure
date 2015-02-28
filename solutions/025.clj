(defn first-fib-term-with-digits
  [n]
  (let [upper-limit (apply * (repeat (dec n) 10N))]
    (loop [a 1N b 1N c 0]
    (if (> a upper-limit)
      (inc c)
      (recur b
             (+ a b)
             (inc c))))))

(defn solution
  []
  (first-fib-term-with-digits 1000))
