import java.util.*;

public class Expert extends Players{
        private int playedCard;
        private ArrayList<Character> leftCards= new ArrayList<Character>();
        private ArrayList<Integer> cardsOnHandNumbers = new ArrayList<>();

        private int[] leftCardsNumbers = new int[13];

        private int point; // şimdilik gerçek puanı koymak yerine sahte bir point koyuyorum gerçeğini koyup test ederiz sora
        public void expertBot(Players players) {
            Random rd = new Random();
            int random= rd.nextInt(cardsOnHand.size());
            int counter=0;
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
                if(i>cardsOnHand.size()-2&&cardsOnHand.get(i-3).getNumber().equals("J")) {
                    playedCard=i-3;
                    cardsOnHand.remove(i-3);
                    cardNum--;
                    lastWinner=1;
                    gatheredCards.addAll(cardsOnArea);
                    break;
                } else if(counter==cardsOnHand.size()) {//asıl olay burada başlıyor
                    cardsOnHandNumbers.clear();
                    for(int j=0;j<13;j++){
                        leftCardsNumbers[j]=0;
                    }
                    for(int j=0;j<super.getDeck().allCards.size();j++){
                        if (super.getDeck().allCards.get(j).getNumber().equals("K")){leftCardsNumbers[12]++;}
                        else if (super.getDeck().allCards.get(j).getNumber().equals("Q")){leftCardsNumbers[11]++;}
                        else if (super.getDeck().allCards.get(j).getNumber().equals("J")){leftCardsNumbers[10]++;}
                        else if (super.getDeck().allCards.get(j).getNumber().equals("A")){leftCardsNumbers[0]++;}
                        else{
                            leftCardsNumbers[Integer.parseInt(super.getDeck().allCards.get(j).getNumber())-1]++;
                        }
                    }
                    for(int j=0;j<cardsOnHand.size();j++) {
                        if (cardsOnHand.get(j).getNumber().equals("K")){cardsOnHandNumbers.add(leftCardsNumbers[12]);}
                        else if (cardsOnHand.get(j).getNumber().equals("Q")){cardsOnHandNumbers.add(leftCardsNumbers[11]);}
                        else if (cardsOnHand.get(j).getNumber().equals("J")){cardsOnHandNumbers.add(leftCardsNumbers[10]);}
                        else if (cardsOnHand.get(j).getNumber().equals("A")){cardsOnHandNumbers.add(leftCardsNumbers[0]);}
                        else {
                            cardsOnHandNumbers.add(leftCardsNumbers[Character.getNumericValue(cardsOnHand.get(j).toString().charAt(1))]);
                        }
                    }
                    Collections.sort(cardsOnHandNumbers,Collections.reverseOrder());//dağıtılmayan kartların sayılarını çoktan aza doğru sıralar

                    for(int j=0;j<cardsOnHand.size();j++){
                        int number;
                        if(cardsOnHand.get(j).getNumber().equals("K")){number=12;}
                        else if (cardsOnHand.get(j).getNumber().equals("Q")){number=11;}
                        else if(cardsOnHand.get(j).getNumber().equals("J")){number=10;}
                        else {number=Integer.parseInt(cardsOnHand.get(j).getNumber());}
                        if (leftCardsNumbers[number]==cardsOnHandNumbers.get(0)){
                            cardsOnArea.add(cardsOnHand.get(j));
                            cardsOnHand.remove(j);
                            cardNum--;
                            break;
                        }
                    }
                }
            }
        }
    }



