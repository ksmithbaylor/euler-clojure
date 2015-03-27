(ns main
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.data :as d]
            [clojure.string :as s]
            [answers.key :as a]))

(defn number->namespace [number]
  (str "solutions." number))

(defn unpad [padded]
  (Integer/parseInt padded))

(defn pad [number]
  (format "%03d" (unpad (str number))))

(def all-problem-numbers
  (->> (io/file "src/solutions")
       file-seq
       (map #(.getName %))
       (filter #(.endsWith % ".clj"))
       (map #(subs % 0 3))))

(apply require
       (map symbol
            (map number->namespace all-problem-numbers)))

(defn time+eval [f]
  (let [value (atom nil)
        duration-str (with-out-str (reset! value (time (f))))]
    [@value (s/trim-newline duration-str)]))

(defn my-results [problem-numbers]
  (->> problem-numbers
       (map number->namespace)
       (map #(str % "/solution"))
       (map symbol)
       (map resolve)
       (map time+eval)
       (interleave (map unpad problem-numbers))
       (apply (partial assoc (sorted-map)))))

(defn pass? [number answer]
  (= (a/answer-key number) answer))

(defn green [s]
  (str "\u001b[38;5;034m" s "\u001b[39m"))

(defn red [s]
  (str "\u001b[38;5;196m" s "\u001b[39m"))

(defn write-result-row [number [answer duration-str]]
  (.write (System/out)
          (.getBytes (str (format "%-6d" number)
                          (if (pass? number answer)
                            (green "PASS")
                            (red "FAIL"))
                          (format "%18s   " (str answer))
                          duration-str
                          "\n"))))

(defn run [which]
  (doseq [[number result] (my-results which)]
    (write-result-row number result)))

(defn -main [& args]
  (if (or (nil? args)
          (= (first args) "all"))
    (run all-problem-numbers)
    (run [(pad (first args))])))
