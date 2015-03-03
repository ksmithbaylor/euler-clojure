(defn mod-pow
  [base exponent modulus]
  (.modPow (biginteger base)
           (biginteger exponent)
           (biginteger modulus)))

(defn rsl
  [n]
  (if-let [found (first (filter #(= 1 (mod-pow 10 % n)) (range 1 n)))]
    [n found]
    [n 0]))

(defn solution
  []
  (->> (range 1 1001)
       (map rsl)
       (sort-by second)
       last
       first))
