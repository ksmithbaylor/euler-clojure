(defn solution
  []
  (- (reduce + (concat ((partial range 0 1000) 3) ((partial range 0 1000) 5)))
     (reduce + ((partial range 0 1000) 15))))
