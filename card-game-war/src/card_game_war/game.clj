(ns card-game-war.game)

;; feel free to use these cards or use your own data structure
(def suits [:spade :club :diamond :heart])
(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
(def cards
  (for [suit suits
        rank ranks]
    [suit rank]))

(defn- play-tie-round [card1 card2]
  (println card1)
  (println card2))

(defn- get-rank [card]
  (.indexOf ranks (peek card)))

(defn- get-suit [card]
  (.indexOf suits (first card)))

(defn play-round [player1-card player2-card]
  (def suit1 (get-suit player1-card))
  (def suit2 (get-suit player2-card))
  (def rank1 (get-rank player1-card))
  (def rank2 (get-rank player2-card))
  (if (and (= suit1 suit2) (= rank1 rank2))
    (play-tie-round player1-card player2-card))
  (if (> rank1 rank2) rank1 rank2)
  (if (> suit1 suit2) suit1 suit2))

(defn play-game [player1-cards player2-cards]
  (map play-round player1-cards player2-cards))
