(ns solutions.022
  (:require [clojure.string :as s]))

(def names
  (-> (slurp "inputs/022.txt")
      (.replaceAll "\"" "")
      (s/split #",")
      sort))

(def name-positions
  (map vector names (rest (range))))

(defn alpha-value [s]
  (reduce + (map #(- (int %) (dec (int \A))) s)))

(defn name-score [[s p]]
  (* (alpha-value s) p))

(defn solution
  []
  (reduce + (map name-score name-positions)))
