import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CompareCard implements Comparator<Card> {
    private static final Map<String, Integer> RANK_ORDER = new HashMap<>();
    private static final Map<String, Integer> SUIT_ORDER = new HashMap<>();

    static {
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for (int i = 0; i < ranks.length; i++) {
            RANK_ORDER.put(ranks[i], i);
        }
        // quy ước chất bài: ♠ > ♥ > ♦ > ♣
        SUIT_ORDER.put("♠", 3);
        SUIT_ORDER.put("♥", 2);
        SUIT_ORDER.put("♦", 1);
        SUIT_ORDER.put("♣", 0);
    }

    @Override
    public int compare(Card c1, Card c2) {
        int rankDiff = RANK_ORDER.get(c1.getRank()) - RANK_ORDER.get(c2.getRank());
        if (rankDiff != 0) return rankDiff;
        return SUIT_ORDER.get(c1.getSuit()) - SUIT_ORDER.get(c2.getSuit());
    }
}
