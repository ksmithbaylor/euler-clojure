(ns solutions.009
  (:require [clojure.core.matrix :as m]))

(defn make-children [triple]
  (map #(flatten (m/mmul % (map vector triple)))
       [[[-1 2 2]
         [-2 1 2]
         [-2 2 3]] [[1 2 2]
                    [2 1 2]
                    [2 2 3]] [[1 -2 2]
                              [2 -1 2]
                              [2 -2 3]]]))

(defn primitives
  ([] (primitives (conj clojure.lang.PersistentQueue/EMPTY [3 4 5])))
  ([q]
   (let [t (peek q)]
     (cons (vec t)
           (lazy-seq (primitives (apply (partial conj (pop q))
                                        (make-children t))))))))

(defn limit-triples [limit triples]
  (take-while (fn [ts]
                (every? #(< % limit) ts))
              triples))

(defn triples-less-than [limit]
  (apply concat (for [primitive (limit-triples limit (primitives))]
                  (limit-triples limit (for [mult (rest (range))]
                                         (m/mul primitive mult))))))

(defn solution []
  (->> (triples-less-than 1000)
       (filter #(= 1000 (reduce + %)))
       (first)
       (reduce *)))
