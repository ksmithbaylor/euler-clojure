(use '[leiningen.exec :only (deps)])
(deps '[[net.mikera/core.matrix "0.29.1"]])
(use 'clojure.core.matrix)

(def mA [[-1 2 2]
         [-2 1 2]
         [-2 2 3]])
(def mB [[1 2 2]
         [2 1 2]
         [2 2 3]])
(def mC [[1 -2 2]
         [2 -1 2]
         [2 -2 3]])

(defn make-children
  [triple]
  (let [parent (map vector triple)
        children (map #(flatten (mmul % parent)) [mA mB mC])]
    children))

(defn primitives
  ([] (primitives (conj clojure.lang.PersistentQueue/EMPTY [3 4 5])))
  ([q]
   (let [t (peek q)]
     (cons (vec t)
           (lazy-seq (primitives (apply (partial conj (pop q)) (make-children t))))))))

(defmacro limit-triples-sequence
  [limit s]
  `(take-while
     (fn [triple#]
       (every? #(< % ~limit) triple#))
     ~s))

(defn triples-less-than
  [n]
  (apply concat
    (for [primitive (limit-triples-sequence n (primitives))]
      (limit-triples-sequence n
        (for [mult (rest (range))]
          (mul mult primitive))))))

(defn solution
  []
  (->> (triples-less-than 1000)
       (filter #(= 1000 (reduce + %)))
       (first)
       (reduce *)))
