package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>(Suit.values().length * Rank.values().length);
        this.populate();
    }

    // Getters

    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards);
    }

    public final void populate() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Cannot draw from an empty deck");
        }

        return cards.remove(cards.size() - 1);
    }
}
