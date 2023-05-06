import java.util.ArrayList;

public class Players {
    public ArrayList<Card> cardsOnHand;
    public ArrayList<Card> gatheredCards;
    public int pistiCounter;

    public int cardNum = 4;
    public Deck deck = new Deck();
    public Deck getDeck(){
        return  deck;
    }
    public int lastWinner = -1; // 0:regular , 1:human, 2:novice, 3:expert earns the last rounds cards
    public static ArrayList<Card> cardsOnArea; // Make cardsOnArea static

    public Players() {
        cardsOnHand = new ArrayList<>();
        gatheredCards = new ArrayList<>();
        pistiCounter = 0;
        cardNum = 4;
        lastWinner = 0;
        if (cardsOnArea == null) { // Initialize cardsOnArea only if it's null
            cardsOnArea = new ArrayList<>();
        }
    }

   /* public PlayedCard allPlayedCard= new PlayedCard();
    public void keepTrackOfPlayedCards(ArrayList<Card> board,boolean isBeginning){
        if(!isBeginning){
            String cardfaceOfTopCard="1";

            for(int i = 0;i<13;i++){
                if(allPlayedCards.getCardfaces()[i].getCardface().equals(cardfaceOfTopCard)){
                    allPlayedCards.getCardfaces()[i].increaseNumberOfPlayed();
                }

            }
        }
    }*/



    // checks the gatheredCards[] if i gained special cards and calculates points needed
    // player who wins the last round gets the cards ( lastWinner: 0 or 1 ) needed
}