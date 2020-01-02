(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.string :as str]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn- get-distance [word1 word2]
  (->> (map = word1 word2) (remove true?) count))

(defn- sort-by-distance [target-word words]
  (sort-by #(get-distance target-word %) words))

(defn- remove-already-visited [visited-words doublets]
  (remove #(some #{%} visited-words) doublets))

(defn- get-doublets [word visited]
  (->> (filter (fn [w] (and (= (count word) (count w))
                            (= 1 (get-distance word w)))) words)
       (remove-already-visited visited) (sort-by-distance word)))

(defn doublets [word1 word2]
  (cond
    (= (count word1) (count word2)) (if (some #{word2} (get-doublets word1)) word2 [])
    :else []))

(doublets "look" "lock")