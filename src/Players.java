import java.util.ArrayList;

public class Players {

    public ArrayList<Card> cardsOnHand = new ArrayList<Card>();
    public ArrayList<Card> gatheredCards = new ArrayList<Card>();
    public ArrayList<Card> cardsOnArea = new ArrayList<Card>();
    public int cardNum = 0;
    public int lastWinner = -1;
    public int pistiCounter;


    // checks the gatheredCards[] if i gained special cards and calculates points needed
    // player who wins the last round gets the cards ( lastWinner: 0 or 1 ) needed
}
