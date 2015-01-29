(defn lpf [x]
  (loop [x x i 3]
    (cond (> i (Math/sqrt x))
            x
          (zero? (rem x i))
            (recur (/ x i) i)
          :else
            (recur x (+ i 2)))))

(defn solution
  []
  (lpf 600851475143))
