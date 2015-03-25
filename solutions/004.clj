(defn is-palindromic? [x]
  (let [s (str x)]
    (= s (clojure.string/reverse s))))

(defn largest-palindromic [nums]
  (apply max (filter is-palindromic? nums)))

(defn solution []
  (largest-palindromic (for [x (range 1e2 1e3)
                             y (range x 1e3)]
                         (int (* x y)))))
