import java.util.ArrayList;

public class Players {
    public ArrayList<Card> cardsOnHand;
    public ArrayList<Card> gatheredCards;
    public int pistiCounter;
    public int cardNum;
    public int lastWinner;
    public static ArrayList<Card> cardsOnArea; // Make cardsOnArea static

    public Players() {
        cardsOnHand = new ArrayList<>();
        gatheredCards = new ArrayList<>();
        pistiCounter = 0;
        cardNum = 0;
        lastWinner = 0;
        if (cardsOnArea == null) { // Initialize cardsOnArea only if it's null
            cardsOnArea = new ArrayList<>();
        }
    }



    // checks the gatheredCards[] if i gained special cards and calculates points needed
    // player who wins the last round gets the cards ( lastWinner: 0 or 1 ) needed
}
