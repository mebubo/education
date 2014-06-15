package c08_object_oriented_design;

import java.rmi.AccessException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class E08_01 {

    public static enum Suit {
        Hearts,
        Diamonds,
        Clubs,
        Spades
    }

    public static enum Rank {
        Ace(1),
        R2(2),
        R3(3),
        R4(4),
        R5(5),
        R6(6),
        R7(7),
        R8(8),
        R9(9),
        R10(10),
        Jack(11),
        Queen(12),
        King(13);

        private final int rank;

        private Rank(int i) {
            rank = i;
        }

        public int getRank() {
            return rank;
        }
    }

    public static abstract class Deck <T extends Card> {

        List<T> cards;

        protected Deck() {
            reset();
        }

        public void shuffle() {
            Collections.shuffle(cards);
        }

        public List<T> deal(int count) {
            ArrayList<T> result = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                result.add(cards.remove(cards.size() - 1));
            }
            return result;
        }

        public abstract T newCard(Suit s, Rank rank);

        public void reset() {
            this.cards = new ArrayList<T>();
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    cards.add(newCard(s, r));
                }
            }

        }

    }

    public static class RegularDeck extends Deck<Card> {
        @Override
        public Card newCard(Suit suit, Rank rank) {
            return new Card(suit, rank);
        }

    }

    public static class BlackJackDeck extends Deck<BlackJackCard> {

        @Override
        public BlackJackCard newCard(Suit suit, Rank rank) {
            return new BlackJackCard(suit, rank);
        }
    }

    public static class Card {
        private Suit suit;

        private Rank rank;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public Suit getSuit() {
            return suit;
        }

        public Rank getRank() {
            return rank;
        }

        public boolean isAce() {
            return rank.equals(Rank.Ace);
        }

        public int value() {
            return rank.getRank();
        }

        public boolean isFaceCard() {
            return rank.getRank() > 10;
        }
    }

    public  static class BlackJackCard extends Card {
        public BlackJackCard(Suit suit, Rank rank) {
            super(suit, rank);
        }

        @Override
        public int value() {
            int value = super.value();
            if (value > 10) {
                return 10;
            } else {
                return value;
            }
        }

        public int minValue() {
            return isAce() ? 1 : value();
        }

        public int maxValue() {
            return isAce() ? 11 : value();
        }
    }

    public static class Hand<T extends Card> {
        private List<T> cards = new ArrayList<T>();

        public void addCards(Collection<T> c) {
            cards.addAll(c);
        }

        public List<T> getCards() {
            return cards;
        }

        public int score() {
            return cards.stream().mapToInt(card -> card.value()).sum();
        }
    }

    public static class BlackJackHand extends Hand<BlackJackCard> {
        @Override
        public int score() {
            List<Integer> possibleScores = possibleScores();
            for (int i = possibleScores.size() - 1; i >= 0; i--) {
                Integer score = possibleScores.get(i);
                if (score <= 21) {
                    return score;
                }
            }
            return possibleScores.get(0);
        }

        public boolean busted() {
            return score() > 21;
        }

        public boolean isBlackJack() {
            List<BlackJackCard> cards = getCards();
            if (cards.size() != 2) {
                return false;
            }
            return (cards.get(0).isAce() && cards.get(1).isFaceCard()) || (cards.get(1).isAce() && cards.get(0).isFaceCard());
        }

        private List<Integer> possibleScores() {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            for (BlackJackCard c : getCards()) {
                if (!c.isAce()) {
                    result = offsetAll(result, c.value());
                } else {
                    List<Integer> tmp = offsetAll(result, c.minValue());
                    tmp.addAll(offsetAll(result, c.maxValue()));
                    result = tmp;
                }
            }
            Collections.sort(result);
            return result;
        }

        private List<Integer> offsetAll(List<Integer> result, int i) {
            return result.stream().map(x -> x + i).collect(Collectors.toList());
        }
    }

}
