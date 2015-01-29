(defn largest-consecutive-sum
  [length digits]
  (let [digits (vec digits)]
    (reduce max (for [i (range (- (count digits) (dec length)))]
           (reduce * (subvec digits i (+ i length)))))))

(defn solution
  []
  (->> (slurp "inputs/008.txt")
       (remove (partial = \newline))
       (map #(Integer/parseInt (str %)))
       (largest-consecutive-sum 13)))
