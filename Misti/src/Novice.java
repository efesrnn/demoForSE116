public class Novice extends Players{
    public void novicePlayer( Players players){
        if (cardsOnArea.isEmpty()) {
            int random = (int) (Math.random() * this.cardNum);
            System.out.println("The computer played: " + this.cardsOnHand.get(random).getSuit() + this.cardsOnHand.get(random).getNumber());
            cardsOnArea.add(cardsOnHand.get(random));
            cardsOnHand.remove(random);
            cardNum--;
            return;
        }

        int random = (int) (Math.random() * this.cardNum);
        Card playedCard = this.cardsOnHand.get(random);
        System.out.println("The computer played: " + playedCard.getSuit() + playedCard.getNumber());

        if (playedCard.getNumber().equals("j")) {
            System.out.println("The computer earned all cards on the area.");
            for (Card card : this.cardsOnArea) {
                gatheredCards.add(card);
            }
            this.cardsOnArea.clear();
            players.lastWinner = 2;
        }else if ( playedCard.getNumber().equals(players.cardsOnArea.get(players.cardsOnArea.size() - 1).getNumber())){
            if (cardsOnArea.size() == 1) {
                pistiCounter++;
            }
            for (Card card : this.cardsOnArea) {
                gatheredCards.add(card);
            }
            this.cardsOnArea.clear();
            players.lastWinner = 2;
        } else{
            this.cardsOnArea.add(playedCard);
        }
        this.cardsOnHand.remove(playedCard);
        cardNum--;

    }
}
