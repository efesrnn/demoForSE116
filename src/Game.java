import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Deck deck;

    private List<Players> players;
    private PointFileReader pointValueFileReader;

    private Game(String pointValuesFilename, List<Players> players) {
        this.deck = new Deck();
        this.players = players;
        this.pointValueFileReader = new PointFileReader(pointValuesFilename);
    }

    public void play() {
        // Game logic.......
    }
    public Game(){
        Scanner scanner = new Scanner(System.in);
       /* PointFileReader pointFileReader = new PointFileReader("C:\\Users\\efese\\OneDrive\\Masaüstü\\points.txt");
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

        // isterseniz deneyin dnemek için yazdım alt kısmı
        for (int i = 0; i < playersClass.cardsOnArea.size(); i++) {
            System.out.print(playersClass.cardsOnArea.get(i).getSuit() + playersClass.cardsOnArea.get(i).getNumber() + " ");
            if (i == playersClass.cardsOnArea.size() - 1) {
                System.out.println();
            }
        }
        boolean gameIsFinished = false;
        int round = roundCalculator();
        int turn = 0;
        while (!gameIsFinished) {
            while (round > 0) {
                turn = 4;
                round--;
                while (turn > 0) {
                    turn --;

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
            gameIsFinished = true;
        }

    }
    private int roundCalculator() {
        return 6;

        // oyuncu 2 kişiyse 6 round
        // oyuncu 3 kişiyse 4 round
        // oyuncu 4 kişiyse 3 round
    }
}