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
  (char (rem (+ (int row)
                (- (int column)
                   (int \a)))
             (int \z))))

(defn concat_keyword [keyword times]
  (if (= times 1)
    (str keyword)
    (concat_keyword (str keyword keyword) (- times 1))))

(defn create_repeated_keyword [keyword size]
  (def keyword_seq (seq keyword))
  (take size (concat_keyword keyword size)))

(defn encode [keyword message]
  (def keyword_seq (create_repeated_keyword keyword (count message)))
  (map get_letter keyword_seq message))

(encode "vigilance" "meetmeontuesdayeveningatseven")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

