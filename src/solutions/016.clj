(ns solutions.016)

(defn pow
  [n p]
  (reduce * (repeat p (bigint n))))

(def parseInt
  #(Integer/parseInt %))

(defn solution
  []
  (let [sum (pow 2 1000)
        digits (.split (str sum) "")
        digits-sum (reduce + (map parseInt digits))]
    digits-sum))
