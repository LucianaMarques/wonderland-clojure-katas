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

(defn create_repeated_keyword [keyword size]
  "keyword")


;; create repeated keyword string
;; create string map
;; access string map by keyword and message string
;; return it

(defn encode [keyword message]
  ;; (def m (count (str/split message #"")))

  )

(encode "key" "ma")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

