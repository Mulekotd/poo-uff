package deck;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return rank.getLabel() + " of " + suit;
    }
}
