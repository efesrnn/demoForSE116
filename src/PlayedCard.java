public class PlayedCard {
    static String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private int numberOfPlayed;
    private String cardface;
    private static PlayedCard[] cardfaces= new PlayedCard[13];

    public PlayedCard[] getCardfaces(){return cardfaces;}
    public int getNumberOfPlayed(){return numberOfPlayed;}
    public void increaseNumberOfPlayed(){numberOfPlayed++;}
    public String getCardface(){return cardface;}



    PlayedCard(){
        for(int i = 0;i<13;i++){
            cardfaces[i].cardface=number[i];
        }


    }
}
