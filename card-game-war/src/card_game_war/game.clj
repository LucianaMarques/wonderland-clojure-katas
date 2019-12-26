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
    (play-tie-round player1-card player2-card)
    (if (> rank1 rank2)
      player1-card
      (if (< rank1 rank2)
        player2-card
        (if (> suit1 suit2)
          player1-card
          player2-card)))))

(defn play-game [player1-cards player2-cards turn]
  (println "Turn " turn)
  (cond
    (empty? player1-cards) "Player 2 wins"
    (empty? player2-cards) "Player 1 wins"
    :else ((def first-card (peek player1-cards))
           (def second-card (peek player2-cards))
           (println "First player card: " first-card)
           (println "Second player card: " second-card)
           (def winning-card (play-round first-card second-card))
           (println "Winning card: " winning-card)
           (if (= winning-card second-card)
              (play-game (conj (rest player1-cards) first-card second-card)
                         (rest player2-cards)
                         (+ turn 1))
              (play-game (rest player1-cards)
                         (conj (rest player2-cards) first-card second-card)
                         (+ turn 1))))))

(play-game '([:diamond :king] [:club 3] [:heart 7])
           '([:spade :jack] [:club 2] [:heart 3]) 1)
;(play-game '([nil]) '([:club 2]))
