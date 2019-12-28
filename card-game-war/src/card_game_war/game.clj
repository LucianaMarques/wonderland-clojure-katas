(ns card-game-war.game)

;; feel free to use these cards or use your own data structure
(def suits [:spade :club :diamond :heart])
(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
(def cards
  (for [suit suits
        rank ranks]
    [suit rank]))

(defn- get-rank [card]
  (.indexOf ranks (peek card)))

(defn play-round [player1-card player2-card]
  (def rank1 (get-rank player1-card))
  (def rank2 (get-rank player2-card))
  (cond
    (> rank1 rank2) player1-card
    (< rank1 rank2) player2-card
    :else nil))

(defn- update-player-cards [player-cards cards-to-add]
  (concat (rest player-cards) [(first player-cards)] cards-to-add))

(defn- get-tie-cards-to-add [player1-cards player2-cards]
  [(first player1-cards) (first (rest player1-cards))
   (first (rest (rest player1-cards)))
   (first (rest (rest (rest player1-cards))))
   (first player2-cards) (first (rest player2-cards))
   (first (rest (rest player2-cards)))
   (first (rest (rest (rest player2-cards))))])

(defn- play-turn [player1-cards player2-cards turn cards-to-add]
  (println "Turn " turn)
  (println "Player 1 cards " player1-cards)
  (println "Player 2 cards " player2-cards)
  (def player1-card (first player1-cards))
  (def player2-card (first player2-cards))
  (def round-result (play-round player1-card player2-card))
  (println "Round result: " round-result)
  (cond
    (= round-result nil) (cond
                           (< (count player1-cards) 4) "Player 2 wins"
                           (< (count player2-cards) 4) "Player 1 wins"
                           :else (play-turn (rest (rest (rest (rest player1-cards))))
                                            (rest (rest (rest (rest player2-cards))))
                                            (+ turn 1)
                                            (get-tie-cards-to-add player1-cards player2-cards)))
    (= round-result player1-card) (cond
                                    (empty? (rest player2-cards)) "Player 1 wins"
                                    :else (play-turn
                                               (update-player-cards player1-cards [player2-card])
                                               (rest player2-cards) (+ turn 1) []))
    :else (cond
            (empty? (rest player1-cards)) "Player 2 wins"
            :else (play-turn
                   (rest player1-cards)
                   (update-player-cards player2-cards (concat player1-card cards-to-add))
                   (+ turn 1) []))))

(defn play-game [player1-cards player2-cards]
  (cond
    (empty? player1-cards) "Player 2 wins"
    (empty? player2-cards) "Player 1 wins"
    :else (play-turn player1-cards player2-cards 1 [])))

