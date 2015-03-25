(defn multiples-of-under [nums limit]
  (set (flatten (map #(range 0 limit %)
                     nums))))

(defn solution []
  (reduce + (multiples-of-under [3 5] 1000)))
