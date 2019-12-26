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

(defn- update-player-cards [player-cards card-to-add]
  (concat (rest player-cards) [(first player-cards)] [card-to-add]))

(defn play-game [player1-cards player2-cards turn]
  (cond
    (empty? player1-cards) "Player 2 wins"
    (empty? player2-cards) "Player 1 wins"
    :else (
           (println "Turn " turn)
           (println "Player 1 cards " player1-cards)
           (println "Player 2 cards " player2-cards)
           (def player1-card (first player1-cards))
           (def player2-card (first player2-cards))
           (def winning-card (play-round player1-card player2-card))
           (println "Winning card " winning-card)
           (println (empty? (rest player2-cards)))
           (println (empty? (rest player1-cards)))
           (println (= winning-card player1-card))
           (if (= winning-card player1-card)
             (if
              (empty? (rest player2-cards))
               "Player 1 wins"
               (play-game (update-player-cards player1-cards player2-card)
                          (rest player2-cards)
                          (+ turn 1)))
             (if
              (empty? (rest player1-cards))
               "Player 2 wins"
               (play-game (rest player1-cards)
                          (update-player-cards player2-cards player1-card)
                          (+ turn 1))))
           )))

(play-game '([:diamond :king] [:club 3] [:heart 7])
           '([:spade :jack] [:club 2] [:heart 3]) 1)
