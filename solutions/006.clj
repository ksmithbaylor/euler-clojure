(defn square
  [^Integer x]
  (* x x))

(defn solution
  []
  (let [x  100
        xs (range 1 (inc x))]
    (- (->> xs (reduce +) square)
       (->> xs (map square) (reduce +)))))


(+ 1 1)
(solution)
