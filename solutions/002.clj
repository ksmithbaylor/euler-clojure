(defn fibs
  "Produces the fibonacci sequence as a lazy sequence"
  ([] (fibs 1 1))
  ([a b] (cons a (lazy-seq (fibs b (+ a b))))))

(defn solution
  []
  (->> (take-while #(< % 4e6) (fibs))
       (filter even?)
       (reduce +)))
