(defn fibs
  ([] (fibs 1N 1N))
  ([a b] (cons a (lazy-seq (fibs b (+ a b))))))


(defn solution
  []
  (inc (count (take-while #(> (apply * (repeat 999 10N)) %)
                          (fibs)))))
