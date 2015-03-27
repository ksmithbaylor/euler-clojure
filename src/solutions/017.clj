(ns solutions.017)

(def lengths {1 3, 2 3, 3 5, 4 4, 5 4, 6 3, 7 5, 8 5, 9 4, 10 3,
              11 6, 12 6, 13 8, 14 8, 15 7, 16 7, 17 9, 18 8, 19 8, 20 6,
              30 6, 40 5, 50 5, 60 5, 70 7, 80 6, 90 6, 1000 11})

(defmacro progress
  [n step func]
  `(let [r# ~step
         t# (- ~n r#)]
     (reduce + (map ~func [r# t#]))))

(defn wordlength
  [n]
  (cond
    (lengths n)         (lengths n)
    (< n 100)           (progress n (mod n 10) wordlength)
    (zero? (rem n 100)) (+ 7 (wordlength (/ n 100)))
    :else               (+ 3 (progress n (mod n 100) wordlength))))

(defn solution
  []
  (reduce + (map wordlength (range 1 1001))))
