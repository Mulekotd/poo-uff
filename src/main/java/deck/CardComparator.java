package deck;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        // 1º critério: naipe
        int bySuit = c1.getSuit().compareTo(c2.getSuit());
        
        if (bySuit != 0) {
            return bySuit;
        }
        
        // 2º critério (desempate): rank crescente
        return Integer.compare(c1.getRank().getValue(), c2.getRank().getValue());
    }
}
