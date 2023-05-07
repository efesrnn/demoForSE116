public class Human extends Players {
    //private PointFileReader pointFileReader;

    //public Human(PointFileReader pointFileReader) {
    // this.pointFileReader = pointFileReader;
    //}
    public void humanPlayer(int playedCard, Players players) {
        if (cardsOnArea.isEmpty()) {
            cardsOnArea.add(cardsOnHand.get(playedCard));
            cardsOnHand.remove(playedCard);
            cardNum--;
        }
        if (cardsOnHand.get(playedCard).getNumber().equals(players.cardsOnArea.get(players.cardsOnArea.size() - 1).getNumber())) {
            if (cardsOnArea.size() == 1) {
                pistiCounter++;
            }
            cardsOnArea.add(cardsOnHand.get(playedCard));
            cardsOnHand.remove(playedCard);
            gatheredCards.addAll(cardsOnArea);
            cardsOnArea.clear();
            cardNum--;

        } else if (cardsOnHand.get(playedCard).getNumber().equals("J")) {
            cardsOnArea.add(cardsOnHand.get(playedCard));
            cardsOnHand.remove(playedCard);
            gatheredCards.addAll(cardsOnArea);
            cardsOnArea.clear();
            cardNum--;

        } else {
            cardsOnArea.add(cardsOnHand.get(playedCard));
            cardsOnHand.remove(playedCard);
            cardNum--;
        }
    }


}