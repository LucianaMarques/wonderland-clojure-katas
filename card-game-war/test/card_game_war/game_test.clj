(ns card-game-war.game-test
  (:require [clojure.test :refer :all]
            [card-game-war.game :refer :all]))


;; fill in  tests for your game
(deftest test-play-round
  (testing "the highest rank wins the cards in the round"
    (is (= [:heart :queen]
           (play-round [:heart :queen] [:heart :jack]))))
  (testing "queens are higher rank than jacks"
    (is (> (.indexOf ranks :queen) (.indexOf ranks :jack))))
  (testing "kings are higher rank than queens"
    (is (> (.indexOf ranks :king) (.indexOf ranks :queen))))
  (testing "aces are higher rank than kings"
    (is (> (.indexOf ranks :ace) (.indexOf ranks :king))))
  (testing "if the ranks are equal, clubs beat spades"
    (is (= [:club :king]
           (play-round [:spade :king] [:club :king]))))
  (testing "if the ranks are equal, diamonds beat clubs"
    (is (= [:diamond :jack]
           (play-round [:diamond :jack] [:club :jack]))))
  (testing "if the ranks are equal, hearts beat diamonds"
    (is (= [:heart :ace]
           (play-round [:heart :ace] [:diamond :ace])))))

(deftest test-play-game
  (testing "the player loses when they run out of cards"))

