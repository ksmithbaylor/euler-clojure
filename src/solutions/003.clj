(ns solutions.003)

(defn largest-prime-factor [x]
  (loop [x x i 3]
    (cond (> i (Math/sqrt x)) x
          (zero? (rem x i)) (recur (/ x i) i)
          :else (recur x (+ i 2)))))

(defn solution []
  (largest-prime-factor 600851475143))
