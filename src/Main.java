import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*PointFileReader pointFileReader = new PointFileReader("C:\\Users\\efese\\OneDrive\\Masaüstü\\points.txt");
        pointFileReader.printPointValues();
        List<Players> players = Arrays.asList(new Novice(), new Regular(), new Expert(), new Human(pointFileReader));
        Game game = new Game("points.txt", players);
        game.play();*/

        //Deck deck = new Deck();

        Expert expert = new Expert();
        //Human human = new Human(pointFileReader);
        Human human = new Human();
        Novice novice = new Novice();
        Regular regular = new Regular();
        Players playersClass = new Players();//decki player classına aldım

        playersClass.getDeck().shuffle();
        playersClass.deck.cut();
        playersClass.deck.deal(novice, regular, expert, human, playersClass);

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
        System.out.println("-------YOUR HAND-------");
        for( int i= 0; i< 4 ; i++){
            System.out.print(human.cardsOnHand.get(i).getSuit() + human.cardsOnHand.get(i).getNumber() + " ");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print(" " + (i + 1) + " ");
        }
        System.out.println();
        int selectedCard = -1;
        while (selectedCard < 1 || selectedCard > playersClass.cardNum) {
            System.out.println("Please choose a card between 1 and " + playersClass.cardNum + ": ");
            try {
                selectedCard = scanner.nextInt();
                if (selectedCard < 1 || selectedCard > playersClass.cardNum) {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next(); // clear the input buffer
            }
        }
        System.out.println("<-<-<-<-<-<->BOARD<->->->->->->");
        for (int i = 0; i < playersClass.cardsOnArea.size(); i++) {
            System.out.print(playersClass.cardsOnArea.get(i).getSuit() + playersClass.cardsOnArea.get(i).getNumber() + " ");
        }
        System.out.println();

    }
}