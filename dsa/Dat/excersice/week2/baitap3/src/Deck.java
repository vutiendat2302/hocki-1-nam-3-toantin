import java.util.ArrayList;
import java.util.List;

public class Deck {
    private static final String[] RANKS =
            {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final String[] SUITS = {"♠", "♥", "♦", "♣"};

    public static Card[] createDeck() {
        List<Card> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck.toArray(new Card[0]);
    }
}