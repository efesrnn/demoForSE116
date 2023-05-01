import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Expert expert = new Expert();
        Human human = new Human();
        Novice novice = new Novice();
        Regular regular = new Regular();

        deck.shuffle();
        deck.cut();
        deck.deal(novice, regular, expert, human);

        // deck.printCardsOnHand(novice, regular, expert, human);

        
    }

}