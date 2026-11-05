import java.util.ArrayList;
import java.util.List;

import deck.Card;
import deck.CardComparator;
import deck.Deck;

public class ProgramaComparador {
    private static final int HAND_SIZE = 10;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        List<Card> hand = new ArrayList<>();

        System.out.println("Cartas recebidas:");
        for (int i = 0; i < HAND_SIZE; i++) {
            Card card = deck.draw();
            System.out.println("  " + card);
            hand.add(card);
        }

        hand.sort(new CardComparator());

        System.out.println("\nMão organizada:");
        for (Card card : hand) {
            System.out.println("  " + card);
        }
    }
}
