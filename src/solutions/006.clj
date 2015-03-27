(ns solutions.006)

(defn square [x] (* x x))
(defn square-all [xs] (map square xs))
(defn sum [xs] (reduce + xs))

(defn solution []
  (let [xs (range 101)]
    (- ((comp square sum) xs)
       ((comp sum square-all) xs))))
