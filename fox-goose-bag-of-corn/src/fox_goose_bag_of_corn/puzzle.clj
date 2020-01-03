(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(defn- move-you-from-boat [pos]
  (def right (peek pos))
  (def left (first pos))
  (def boat (->> (rest pos) first))
  [(conj left :you) [:boat] right])

(defn- move-corn-from-boat []
  [[:fox] [:boat] [:goose :corn :you]])

(defn- move-fox-from-boat []
  [[:goose] [:boat] [:fox :corn :you]])

(defn- move-goose-from-boat [pos]
  (def right (peek pos))
  (def left (first pos))
  (def boat (->> (rest pos) first))
  (cond
    (= right []) [[:fox :corn] [:boat] [:goose :you]]
    (= right [:corn]) [[:fox :goose :you] [:boat] [:corn]]
    :else [left [:boat] [:fox :goose :corn :you]]))

(defn- move-from-boat [pos]
  (def right (peek pos))
  (def left (first pos))
  (def boat (->> (rest pos) first))
  (def animal (->> (pop boat) peek))
  (cond
    (= animal :goose) (move-goose-from-boat pos)
    (= animal :fox) (move-fox-from-boat)
    (= animal :corn) (move-corn-from-boat)
    :else (move-you-from-boat pos)))

(move-from-boat [[] [:boat :goose :you] [:fox :corn]])

(defn- extract-from-right [right]
  (cond
    (= right [:goose :you]) [[:goose] [:boat :you]]
    (= right [:goose :corn :you]) [[:corn] [:boat :goose :you]]
    (= right [:fox :corn :you]) [[:fox :corn] [:boat :you]]))

(defn- move-right-to-boat [pos]
  (def right (peek pos))
  (def left (first pos))
  (def boat (->> (rest pos) first))
  (into [] (reverse (conj (extract-from-right right) left))))

(defn- extract-from-left [left]
  (cond
    (= left [:fox :goose :corn :you]) [[:fox :corn] [:boat :goose :you]]
    (= left [:fox :corn :you]) [[:fox] [:boat :corn :you]]
    (= left [:fox :goose :you]) [[:goose] [:boat :fox :you]]
    (= left [:goose :you]) [[] [:boat :goose :you]]))

(defn- move-left-to-boat [pos]
  (def right (peek pos))
  (def left (first pos))
  (def boat (->> (rest pos) first))
  (conj (extract-from-left left) right))

(defn- update-pos [pos]
  (def right (peek pos))
  (def left (first pos))
  (def boat (->> (rest pos) first))
  (cond
    (some #(= :you %) right) (move-right-to-boat pos)
    (some #(= :you %) left) (move-left-to-boat pos)
    (some #(= :you %) boat) (move-from-boat pos)))

(defn- increment-plan [positions]
  (if (= (peek positions) [[] [:boat] [:fox :goose :corn :you]])
    positions
    (increment-plan (conj positions (update-pos (peek positions))))))

(defn river-crossing-plan []
  (increment-plan start-pos))
