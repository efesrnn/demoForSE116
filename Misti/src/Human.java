public class Human extends Players {
    private PointFileReader pointFileReader;

    public Human(PointFileReader pointFileReader) {
        this.pointFileReader = pointFileReader;
    }
    public void humanPlayer(int playedCard, Players players) {
        if (cardsOnArea.isEmpty()) {
            cardsOnArea.add(cardsOnHand.get(playedCard));
            cardsOnHand.remove(playedCard);
            cardNum--;
            return;
        }
        if (cardsOnHand.get(playedCard).getNumber().equals(players.cardsOnArea.get(players.cardsOnArea.size() - 1).getNumber())) {
            players.lastWinner = 1; // 1 means player took the last cards on the board
            if (cardsOnArea.size() == 1) {
                pistiCounter++;
                cardsOnHand.remove(playedCard);
                cardNum--;
                return;
            }

            for (int j = 0; j < cardsOnArea.size(); j++) {      // updating cards that are gathered
                gatheredCards.add(cardsOnArea.get(j));
            }
            gatheredCards.add(this.cardsOnHand.get(playedCard));
            cardsOnArea.clear();
            cardsOnHand.remove(playedCard);
            cardNum--;

        } else if (cardsOnHand.get(playedCard).getNumber().equals("J")) {
            if (cardsOnArea.size() != 1) {
                players.lastWinner = 1;
            }
            for (int j = 0; j < cardsOnArea.size(); j++) {      // updating cards that are gathered
                gatheredCards.add(cardsOnArea.get(j));
            }
            gatheredCards.add(this.cardsOnHand.get(playedCard));
            cardsOnArea.clear();
            cardsOnHand.remove(playedCard);
            cardNum--;

        } else {
            cardsOnArea.add(cardsOnHand.get(playedCard));
            cardsOnHand.remove(playedCard);
            cardNum--;
        }
    }
}
