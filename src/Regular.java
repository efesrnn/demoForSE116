public class Regular extends Players{
    public void regularPlayer( Players players ){
        if (cardsOnArea.isEmpty()) {
            int random = (int) (Math.random() * this.cardNum);
            while (cardsOnHand.get(random).getNumber().equals("J")) {
                random = (int) (Math.random() * cardNum);
            }
            System.out.println("The computer played: " + this.cardsOnHand.get(random).getSuit() + this.cardsOnHand.get(random).getNumber());
            cardsOnArea.add(cardsOnHand.get(random));
            cardsOnHand.remove(random);
            cardNum--;
            return;
        }

        for (int i = 0; i < this.cardNum; i++) {
            if ( this.cardsOnHand.get(i).getNumber().equals(players.cardsOnArea.get(players.cardsOnArea.size() - 1).getNumber())) {
                System.out.println("The computer played: " + this.cardsOnHand.get(i).getSuit() + this.cardsOnHand.get(i).getNumber());
                players.lastWinner = 0;
                if (cardsOnArea.size() == 1) {
                    pistiCounter++;
                    this.cardsOnHand.remove(i);
                    cardNum--;
                    return;
                }
                for (int j = 0; j < players.cardsOnArea.size(); j++) {
                    gatheredCards.add(players.cardsOnArea.get(j));

                }
                this.cardsOnArea.clear();
                gatheredCards.add(this.cardsOnHand.get(i));
                this.cardsOnHand.remove(i);
                cardNum--;
                return;
            }
        }
        for (int i = 0; i < this.cardNum; i++) {
            if ( this.cardsOnHand.get(i).getNumber().equals("J")) {
                System.out.println("The computer played: " + this.cardsOnHand.get(i).getSuit() + this.cardsOnHand.get(i).getNumber());
                players.lastWinner = 0;
                for (int j = 0; j < players.cardsOnArea.size(); j++) {
                    gatheredCards.add(players.cardsOnArea.get(j));

                }
                this.cardsOnArea.clear();
                gatheredCards.add(this.cardsOnHand.get(i));
                this.cardsOnHand.remove(i);
                cardNum--;
                return;
            }
        }
        int random = (int) (Math.random() * this.cardNum);
        while (cardsOnHand.get(random).getNumber().equals("J")) {
            random = (int) (Math.random() * cardNum);
        }
        System.out.println("The computer played: " + this.cardsOnHand.get(random).getSuit() + this.cardsOnHand.get(random).getNumber());
        cardsOnArea.add(cardsOnHand.get(random));
        cardsOnHand.remove(random);
        cardNum--;

    }

}