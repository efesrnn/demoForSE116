import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Players> players = Arrays.asList(new Novice(), new Regular(), new Expert(), new Human());
        Game game = new Game("pointValues.txt", players);
        game.play();

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