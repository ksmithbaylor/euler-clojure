(defn solution
  []
  (->> (for [x (range 1e2 1e3)
             y (range x   1e3)] (* x y))
       (map int)
       (map str)
       (filter #(= % (clojure.string/reverse %)))
       (map #(Integer/parseInt %))
       (apply max)))
