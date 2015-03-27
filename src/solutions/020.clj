(ns solutions.020)

(def factorial #(reduce * 1N (range 1 (inc %))))

(def char-to-int #(Character/digit % 10))

(defn solution
  []
  (->> (factorial 100)
       str
       (map char-to-int)
       (reduce +)))
