(require '[clojure.core.reducers :as r])

(defn largest-consecutive-sum
  [length digits]
  (reduce max 0 (r/map #(r/fold * %)
                       (for [i (range (- (count digits)
                                         (dec length)))]
                         (subvec digits i (+ i length))))))

(defn solution []
  (->> (slurp "inputs/008.txt")
       (remove (partial = \newline))
       (map #(Integer/parseInt (str %)))
       (largest-consecutive-sum 13)))
