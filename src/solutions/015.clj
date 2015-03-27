(ns solutions.015)

(defn underlying
  [n]
  (if (= n 0)
    1
    (/ (* 2 (inc (* 2 n)) (underlying (dec n))) (inc n))))

(defn paths
  [n]
  (* 2 (underlying (dec n))))

(defn solution
  []
  (paths 20))
