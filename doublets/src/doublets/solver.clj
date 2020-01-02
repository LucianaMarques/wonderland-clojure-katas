(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.string :as str]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn- get-doublet [word]
  (filter (fn [w] (and (str/ends-with? w (apply str (rest word)))
                       (not= w word))) words))

(defn- get-doublets [word]
  )

(defn doublets [word1 word2]
  (cond
    (= (count word1) (count word2)) (get-doublet word1)
    :else []))

(doublets "look" "lock")