(use ['clojure.string :only ['split-lines 'split]])

; Utilities
(def parseInt #(Integer/parseInt %))
(def chop #(rest (reverse (rest (reverse %)))))

; Data
(def triangle
  (->> (slurp "inputs/018.txt")
       split-lines
       (map #(split % #" "))
       (map #(map parseInt %))
       (map vec)
       vec))

; Functionality
(defn middle-compress
  [top middle]
  (if (empty? middle)
    []
    (for [i (range (count middle))]
      (let [child (nth middle i)
            l (nth top i)
            r (nth top (inc i))]
        (+ child (max l r))))))

(defn compress
  [[top bottom]]
  (let [left (first bottom)
        middle (chop bottom)
        right (last bottom)
        new-left (+ left (first top))
        new-middle (middle-compress top middle)
        new-right (+ right (last top))]
    (vec (flatten [new-left new-middle new-right]))))

(defn max-path
  [triangle]
  (if (= 1 (count triangle))
    (apply max (flatten triangle))
    (recur (vec (cons (compress ((juxt first second) triangle))
                      (subvec triangle 2))))))

(defn solution
  []
  (max-path triangle))
