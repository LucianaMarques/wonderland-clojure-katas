(ns alphabet-cipher.coder)
(require '[clojure.string :as str])

(def letter_map {:a "abcdefghijklmnopqrstuvwxyz"
                 :b "bcdefghijklmnopqrstuvwxyza"
                 :c "cdefghijklmnopqrstuvwxyzab"
                 :d "defghijklmnopqrstuvwxyzabc"
                 :e "efghijklmnopqrstuvwxyzabcd"
                 :f "fghijklmnopqrstuvwxyzabcde"
                 :g "ghijklmnopqrstuvwxyzabcdef"
                 :h "hijklmnopqrstuvwxyzabcdefg"
                 :i "ijklmnopqrstuvwxyzabcdefgh"
                 :j "jklmnopqrstuvwxyzabcdefghi"
                 :k "klmnopqrstuvwxyzabcdefghij"
                 :l "lmnopqrstuvwxyzabcdefghijk"
                 :m "mnopqrstuvwxyzabcdefghijkl"
                 :n "nopqrstuvwxyzabcdefghijklm"
                 :o "opqrstuvwxyzabcdefghijklmn"
                 :p "pqrstuvwxyzabcdefghijklmno"
                 :q "qrstuvwxyzabcdefghijklmnop"
                 :r "rstuvwxyzabcdefghijklmnopq"
                 :s "stuvwxyzabcdefghijklmnopqr"
                 :t "tuvwxyzabcdefghijklmnopqrs"
                 :u "uvwxyzabcdefghijklmnopqrst"
                 :v "vwxyzabcdefghijklmnopqrstu"
                 :w "wxyzabcdefghijklmnopqrstuv"
                 :x "xyzabcdefghijklmnopqrstuvw"
                 :y "yzabcdefghijklmnopqrstuvwx"
                 :z "zabcdefghijklmnopqrstuvwxy"})

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

