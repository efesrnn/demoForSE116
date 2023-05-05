import java.util.*;

public class Deck {
    public ArrayList<Card> allCards;
    public Scanner scanner;

    public Deck() {
        String[] suit = {"♠", "♣", "♥", "♦"};
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        allCards = new ArrayList<Card>();

        for (int i = 0; i < 52; i++) {
            Card card = new Card(suit[i / 13], number[i % 13]);
            allCards.add(card);
        }

        scanner = new Scanner(System.in);
    }

    public void shuffle() {
        Collections.shuffle(allCards);
    }

    public void cut() {
        int inputNum = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter a number between 1 and 52:");
            try {
                inputNum = scanner.nextInt();
                if (inputNum >= 1 && inputNum <= 52) {
                    validInput = true;
                } else {
                    System.out.println("The number you have entered is invalid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
                scanner.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid value.");
            }
        }
        List<Card> tempArr = new ArrayList<Card>(allCards.size());

        for (Card card : allCards) {
            tempArr.add(card);
        }
        for (int i = 0; i < tempArr.size(); i++) {
            allCards.set(i, tempArr.get((inputNum + i) % 52));
        }
    }

    public void deal(Novice novice, Regular regular, Expert expert, Human human, Players players) {
        // Deal cards to players
        for (int i = allCards.size() - 1; i >= allCards.size() - 16; i -= 4) {
            novice.cardsOnHand.add(allCards.get(i - 3));
            regular.cardsOnHand.add(allCards.get(i - 2));
            expert.cardsOnHand.add(allCards.get(i - 1));
            human.cardsOnHand.add(allCards.get(i));
        }

        // Remove dealt cards from the deck
        allCards.subList(allCards.size() - 16, allCards.size()).clear();

        // Deal cards to the board
        for (int i = 0; i < 4; i++) {
            Card cardToAdd = allCards.get(allCards.size() - 1);
            allCards.remove(cardToAdd);
            players.cardsOnArea.add(cardToAdd);
        }
    }
    /*public void printCardsOnHand(Novice novice, Regular regular, Expert expert, Human human) {
        System.out.println("Cards on hand for Novice:");
        for (Card card : novice.cardsOnHand) {
            System.out.println(card.toString());
        }

        System.out.println("Cards on hand for Regular:");
        for (Card card : regular.cardsOnHand) {
            System.out.println(card.toString());
        }

        System.out.println("Cards on hand for Expert:");
        for (Card card : expert.cardsOnHand) {
            System.out.println(card.toString());
        }

        System.out.println("Cards on hand for Human:");
        for (Card card : human.cardsOnHand) {
            System.out.println(card.toString());
        }
    }

     */

}