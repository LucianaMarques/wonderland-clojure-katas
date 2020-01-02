(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.string :as str]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn- differs-by-one-letter [word1 word2]
  (->> (map = word1 word2) (remove true?) count (= 1)))

(defn- get-doublets [word]
  (filter (fn [w] (and (= (count word) (count w)) (differs-by-one-letter word w))) words))

(get-doublets "book")

(defn doublets [word1 word2]
  (cond
    (= (count word1) (count word2)) (get-doublets word1)
    :else []))

(doublets "look" "lock")