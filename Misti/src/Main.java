import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PointFileReader pointFileReader = new PointFileReader("C:\\Users\\efese\\OneDrive\\Masaüstü\\points.txt");
        pointFileReader.printPointValues();
        List<Players> players = Arrays.asList(new Novice(), new Regular(), new Expert(), new Human(pointFileReader));
        Game game = new Game("points.txt", players);
        game.play();

        Deck deck = new Deck();

        Expert expert = new Expert();
        Human human = new Human(pointFileReader);
        Novice novice = new Novice();
        Regular regular = new Regular();
        Players playersClass = new Players();

        deck.shuffle();
        deck.cut();
        deck.deal(novice, regular, expert, human, playersClass);

        // Print initial board state
        for (int i = 0; i < playersClass.cardsOnArea.size(); i++) {
            System.out.print(playersClass.cardsOnArea.get(i).getSuit() + playersClass.cardsOnArea.get(i).getNumber() + " ");
            if (i == playersClass.cardsOnArea.size() - 1) {
                System.out.println();
            }
        }

        // isterseniz deneyin dnemek için yazdım alt kısmı
        for (int i = 0; i < playersClass.cardsOnArea.size(); i++) {
            System.out.print(playersClass.cardsOnArea.get(i).getSuit() + playersClass.cardsOnArea.get(i).getNumber() + " ");
            if (i == playersClass.cardsOnArea.size() - 1) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("*-*-*-*----YOUR HAND----*-*-*-*");
        for( int i= 0; i< 4 ; i++){
            System.out.print(human.cardsOnHand.get(i).getSuit() + human.cardsOnHand.get(i).getNumber() + " ");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print(" " + (i + 1) + " ");
        }
        System.out.println();
        System.out.println("Please choose the card you want to play.<3 ");
        int selectedCard = scanner.nextInt();
        human.humanPlayer(selectedCard - 1, playersClass);
        System.out.println("<-<-<-<-<-<->BOARD<->->->->->->");
        for (int i = 0; i < playersClass.cardsOnArea.size(); i++) {
            System.out.print(playersClass.cardsOnArea.get(i).getSuit() + playersClass.cardsOnArea.get(i).getNumber() + " ");
        }
        System.out.println();

    }
}