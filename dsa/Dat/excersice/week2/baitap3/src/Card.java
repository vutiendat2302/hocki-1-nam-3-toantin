public class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    private static final String[] RANKS =
            {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private static final String[] SUITS = {"♣","♦","♥","♠"};

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    private int rankValue() {
        for (int i = 0; i < RANKS.length; i++) {
            if (RANKS[i].equals(rank)) return i;
        }
        return -1;
    }

    private int suitValue() {
        for (int i = 0; i < SUITS.length; i++) {
            if (SUITS[i].equals(suit)) return i;
        }
        return -1;
    }

    @Override
    public int compareTo(Card other) {
        if (this.rankValue() != other.rankValue()) {
            return this.rankValue() - other.rankValue();
        }
        return this.suitValue() - other.suitValue();
    }

    @Override
    public String toString() {
        return rank + " " + suit;
    }
}
