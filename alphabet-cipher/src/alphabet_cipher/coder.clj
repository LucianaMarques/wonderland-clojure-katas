(ns alphabet-cipher.coder)
(require '[clojure.string :as str])

(defn get_letter [column row]
  (def temp_res (+ (int column) (- (int row) (int \a))))
  (if (<= temp_res (int \z))
    (char temp_res)
    (char (+ (int (rem temp_res (int \z))) (- (int \a) 1)))))

(defn concat_keyword_recursive [keyword times]
  (if (= times 1)
    (str keyword)
    (concat_keyword_recursive (str keyword keyword) (- times 1))))

(defn create_repeated_keyword [keyword size]
  (def max_size (int (+ (rem (count keyword) size) (/ (count keyword) size))))
  (take size (concat_keyword_recursive keyword max_size)))

(defn encode [keyword message]
  (def keyword_seq (create_repeated_keyword keyword (count message)))
  (apply str (map get_letter keyword_seq message)))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

