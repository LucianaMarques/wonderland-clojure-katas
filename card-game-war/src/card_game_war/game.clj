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

(defn play-round [player1-card player2-card]
  (def rank1 (get-rank player1-card))
  (def rank2 (get-rank player2-card))
  (cond
    (and (= suit1 suit2) (= rank1 rank2)) (play-tie-round player1-card player2-card)
    (> rank1 rank2) player1-card
    (< rank1 rank2) player2-card
    :else nil))

(defn- update-player-cards [player-cards cards-to-add]
  (concat (rest player-cards) [(first player-cards)] cards-to-add))

(defn- play-turn [player1-cards player2-cards turn cards-to-add]
  (println "Turn " turn)
  (if (empty? (rest player1-cards)) "Player 2 wins"
  (println "Player 1 cards " player1-cards)
  (println "Player 2 cards " player2-cards)
  (def player1-card (first player1-cards))
  (def player2-card (first player2-cards))
  (def round-result (play-round player1-card player2-card))
  (println "Round result: " winning-card)
  (cond
    (= round-result nil) (play-turn (rest player1-cards) (rest player2-cards) (+ turn 1)
                                    (concat (first player1-cards) (first player2-cards))))
    (= winning-card player1-card) (play-turn (update-player-cards player1-cards [player2-card])
                                             (rest player2-cards) (+ turn 1) cards-to-add)
    :else (play-turn (rest player1-cards) (update-player-cards player2-cards [player1-card])
                     (+ turn 1) cards-to-add)))

(defn play-game [player1-cards player2-cards]
  (cond
    (empty? player1-cards) "Player 2 wins"
    (empty? player2-cards) "Player 1 wins"
    :else (play-turn player1-cards player2-cards (+ turn 1))))
