import java.util.*;

public class Expert extends Players{
        private int playedCard;

        private ArrayList<Card> jokers= new ArrayList<Card>();
        private ArrayList<Character> leftCards= new ArrayList<Character>();
        private ArrayList<Integer> cardsOnHandNumbers = new ArrayList<>();

        private int[] leftCardsNumbers = new int[13];

        private int point; // şimdilik gerçek puanı koymak yerine sahte bir point koyuyorum gerçeğini koyup test ederiz sora
        public void expertBot(Players players) {
            Random rd = new Random();
            int random= rd.nextInt(cardsOnHand.size());
            int counter=0;
            jokers.add(new Card("♣","J"));
            jokers.add(new Card("♠","J"));
            jokers.add(new Card("♥","J"));
            jokers.add(new Card("♦","J"));
            for(int i=0;i<cardsOnHand.size()+counter;i++) {//burada elimizdeki herhangi bir kart üstteki kartla uyuşuyormu diye bakıyoruz.
                if (i< cardsOnHand.size()&&cardsOnArea.get(cardsOnArea.size() - 1).toString().indexOf(1) ==cardsOnHand.get(i).toString().indexOf(1)){
                    playedCard=i;
                    if(cardsOnArea.size()==1){
                        pistiCounter++;
                    }
                    cardNum--;
                    cardsOnHand.remove(i);
                    lastWinner=3;
                    gatheredCards.addAll(cardsOnArea);
                    break;
                }

                if(i>cardsOnHand.size()-2){counter++;}//eğer öncelikli kart bulunamadıysa joker için arttırıyoruz counterı
                if(i>cardsOnHand.size()-2&&cardsOnHand.get(i-3)==jokers.get(i-3)) {
                    playedCard=i-3;
                    cardsOnHand.remove(i-3);
                    cardNum--;
                    lastWinner=1;
                    gatheredCards.addAll(cardsOnArea);
                    break;
                } else if(counter==cardsOnHand.size()) {//asıl olay burada başlıyor
                    leftCards.clear();
                    cardsOnHandNumbers.clear();

                    for(int j=0;j<super.getDeck().allCards.size();j++){
                        leftCards.add(super.getDeck().allCards.get(i).toString().charAt(1));
                    }
                    for(int j=0;j<13;j++){
                        leftCardsNumbers[j]=0;
                    }
                    for(int j=0;j<leftCards.size();j++){
                        if (leftCards.get(j).equals("K")){leftCardsNumbers[12]++;}
                        else if (leftCards.get(j).equals("Q")){leftCardsNumbers[11]++;}
                        else if (leftCards.get(j).equals("J")){leftCardsNumbers[10]++;}
                        else if (leftCards.get(j).equals("A")){leftCardsNumbers[0]++;}
                        else{
                            leftCardsNumbers[Character.getNumericValue(leftCards.get(j))-1]++;
                        }
                    }
                    for(int j=0;j<cardsOnHand.size();j++) {
                        cardsOnHandNumbers.add(leftCardsNumbers[Character.getNumericValue(cardsOnHand.get(j).toString().charAt(1))]);
                    }
                    Collections.sort(cardsOnHandNumbers,Collections.reverseOrder());
                    for(int j=0;j<cardsOnHand.size();j++){
                        if (Character.getNumericValue(cardsOnHand.get(j).toString().charAt(1))==cardsOnHandNumbers.get(0)){
                            cardsOnArea.add(cardsOnHand.get(j));
                            cardsOnHand.remove(j);
                            cardNum--;

                        }
                    }


                    cardsOnHand.remove(0);//düzenle burayı
                    cardNum--;
                    break;
                }
            }
        }
    }



