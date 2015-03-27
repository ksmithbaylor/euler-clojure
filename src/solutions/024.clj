(ns solutions.024)

(defn vec->int
  [v]
  (reduce + (map (partial reduce *)
                 (map vector
                      (reverse v)
                      (map #(apply * (repeat % 10)) (range (count v)))))))

(defn nth-permutation
  [i n]
  (loop [i (dec i)
         k 0
         orig (range n)
         nums []]
    (if (= k n)
      (vec->int nums)
      (let [f (reduce * (range 1 (- n k)))
            d (int (/ i f))
            x (nth orig d)]
        (recur (mod i f)
               (inc k)
               (remove #(= x %) orig)
               (conj nums x))))))

(defn solution
  []
  (nth-permutation 1e6 10))
