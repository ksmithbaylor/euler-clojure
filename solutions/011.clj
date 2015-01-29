(use ['clojure.string :only ['split-lines 'split]])

(def rows
  (->> (slurp "inputs/011.txt")
       (split-lines)
       (map #(split % #" "))
       (map #(map (fn [x] (Integer/parseInt x)) %))
       (map vec)
       (vec)))

(defn rotate
  [slices]
  (apply (partial map vector) slices))

(def cols (rotate rows))

(defn products
  [slices length]
  (->> slices
       (map (partial partition length 1))
       (apply concat)
       (map (partial reduce *))))

(defn shift
  [input]
  (let [counts (range (count input))
        turn-to-nils (fn [numbers] (map #(take % (repeat nil)) numbers))
        front-nils (turn-to-nils counts)
        back-nils (turn-to-nils (reverse counts))
        pairs (interleave front-nils input back-nils)
        combined (->> pairs (partition 3) (map (partial apply concat)))]
    combined))

(defn diagonals
  [slices length]
  (->> (shift slices)
       (rotate)
       (map (partial remove nil?))
       (filter #(<= length (count %)))))

(defn diagonal-products
  [slices length]
  (products (diagonals slices length) length))

(defn solution
  []
  (apply max (concat (products rows 4)
                     (products cols 4)
                     (diagonal-products rows 4)
                     (diagonal-products (reverse cols) 4))))
