import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    private ArrayList<cards> cards;

    public DeckOfCards() {
        cards = new ArrayList<cards>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards card = new cards(suit, rank);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void cut() {
        int splitPoint = (int) (Math.random() * cards.size());
        ArrayList<cards> topHalf = new ArrayList<cards>(cards.subList(0, splitPoint));
        ArrayList<cards> bottomHalf = new ArrayList<cards>(cards.subList(splitPoint, cards.size()));
        cards.clear();
        cards.addAll(bottomHalf);
        cards.addAll(topHalf);
    }

    public cards dealCard() {
        if (cards.isEmpty()) {
            return null;
        } else {
            return cards.remove(0);
        }
    }

    public void dealCards(ArrayList<Player> players, int numCards) {
        for (Player player : players) {
            for (int i = 0; i < numCards; i++) {
                Card card = dealCard();
                if (card != null) {
                    player.addCard(card);
                }
            }
        }
    }

    public void addCardsToBoard(Board board, int numCards) {
        for (int i = 0; i < numCards; i++) {
            Card card = dealCard();
            if (card != null) {
                board.addCard(card);
            }
        }
    }
}