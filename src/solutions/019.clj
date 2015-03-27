(ns solutions.019)

(def divisible?
  #(zero? (rem %1 %2)))

(defn leap-year?
  [n]
  (if (divisible? n 100)
    (divisible? n 400)
    (divisible? n 4)))

(defn days
  [leap?]
  [31 (if leap? 29 28) 31 30 31 30 31 31 30 31 30 31])

(defn month
  [m y]
  (cons true (-> (leap-year? y)
                 days
                 (nth m)
                 dec
                 (repeat nil))))

(defn century-days
  [start]
  (flatten (for [y (range start (+ 100 start))
                 m (range 12)]
             (month m y))))

(defn solution
  []
  (->> (century-days 1901)
       (drop 5)
       (take-nth 7)
       (remove nil?)
       (count)))
