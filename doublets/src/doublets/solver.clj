(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn- get-doublets [word]
  )

(defn doublets [word1 word2]
  (if (= (count word1) (count word2))
    (doublets (get-doublet word1) word2)
    []))
