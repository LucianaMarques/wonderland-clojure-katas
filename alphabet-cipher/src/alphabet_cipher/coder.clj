(ns alphabet-cipher.coder)
(require '[clojure.string :as str])

(def letter_map {:A "abcdefghijklmnopqrstuvwxyz",
                 :B "bcdefghijklmnopqrstuvwxyza",
                 :C "cdefghijklmnopqrstuvwxyzab",
                 :D "defghijklmnopqrstuvwxyzabc",
                 :E "efghijklmnopqrstuvwxyzabcd",
                 :F "fghijklmnopqrstuvwxyzabcde",
                 :G "ghijklmnopqrstuvwxyzabcdef",
                 :H "hijklmnopqrstuvwxyzabcdefg",
                 :I "ijklmnopqrstuvwxyzabcdefgh",
                 :J "jklmnopqrstuvwxyzabcdefghi",
                 :K "klmnopqrstuvwxyzabcdefghij",
                 :L "lmnopqrstuvwxyzabcdefghijk",
                 :M "mnopqrstuvwxyzabcdefghijkl",
                 :N "nopqrstuvwxyzabcdefghijklm",
                 :O "opqrstuvwxyzabcdefghijklmn",
                 :P "pqrstuvwxyzabcdefghijklmno",
                 :Q "qrstuvwxyzabcdefghijklmnop",
                 :R "rstuvwxyzabcdefghijklmnopq",
                 :S "stuvwxyzabcdefghijklmnopqr",
                 :T "tuvwxyzabcdefghijklmnopqrs",
                 :U "uvwxyzabcdefghijklmnopqrst",
                 :V "vwxyzabcdefghijklmnopqrstu",
                 :W "wxyzabcdefghijklmnopqrstuv",
                 :X "xyzabcdefghijklmnopqrstuvw",
                 :Y "yzabcdefghijklmnopqrstuvwx",
                 :Z "zabcdefghijklmnopqrstuvwxy"})

(defn create_letter_map []
  {})

(defn concat_keyword [keyword times]
  (if (= times 1)
    (str keyword)
    (concat_keyword (str keyword keyword) (- times 1))))

(concat_keyword "stone" 2)

(defn create_repeated_keyword [keyword size]
  (def keyword_seq (seq keyword))
  (take size (concat_keyword keyword size)))

;; (take size (for [char keyword_seq] (int char)))))

(create_repeated_keyword "abc" 1)

(create_repeated_keyword "abc" 5)


;; create repeated keyword string
;; create string map
;; access string map by keyword and message string
;; return it
;; (def m (str/split message #""))

(defn encode [keyword message]
  (int (first (seq message))))

(encode "key" "ma")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

