/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;
import static java.util.Random.*;

/**
 *
 * @author xtreme
 */
public class Game {
        int won = 0;
    Player[] player = new Player[4];
    int numofcard = 52;
    Card[] card = new Card[numofcard];
    Card[] totalCards = new Card[52];
    int VALID;
    int dealar_score;
    int n = 52;

    void generate() {
   
        int index = 0;
        for(int k=0;k<4;k++) {
            for (int i = 0; i < 13; i++) {
                int val=i+1;
                if(val>10)val=10;
                Card crd = new Card(k,i, val);
                card[index] = crd;
                index++;
            }
        }

    }

    Card randomCard() {
        int z = card.length;
        Card crdChois = null;
        Random r = new Random();
        int randomChoise = r.nextInt(z);
        if (card[randomChoise].equals(null)) {
            randomCard();
        }
        crdChois = new Card(card[randomChoise].getSuit(), card[randomChoise].getRank(), card[randomChoise].getValue());
        card[randomChoise].equals(null);
        return crdChois;
    }
    void push() {
        if(player[0].getScore()<=21&&player[1].getScore()<=21&&player[2].getScore()<=21){
       if(player[0].getScore()==player[1].getScore()||player[0].getScore()==player[2].getScore()||player[0].getScore()==player[3].getScore()){
           System.out.println("Push");
       }
       else if(player[1].getScore()==player[0].getScore()||player[1].getScore()==player[2].getScore()||player[1].getScore()==player[3].getScore()){
           System.out.println("Push");
       }
       else if(player[2].getScore()==player[0].getScore()||player[2].getScore()==player[1].getScore()||player[2].getScore()==player[3].getScore()){
           System.out.println("Push");
       }
       else if(player[3].getScore()==player[0].getScore()||player[3].getScore()==player[1].getScore()||player[3].getScore()==player[2].getScore()){
           System.out.println("Push");
       }
       else win();
        }
        else System.out.println("the maximum score is " + player[3].getScore() + " and the winner is " + player[3].getName());

       
    }

    void setname(String n1) {

        int index = 0;
        int score = 0;
        Player player1 = new Player(n1);
        for (int i = 0; i < 2; i++) {
            player1.c[i] = randomCard();
            score = score + player1.c[i].getValue();
        }
        player1.setName(n1);
        player1.setScore(score);
        while (index < 4) {
            if (null == player[index]) {
                player[index] = player1;
                break;
            } else {
                index++;
            }
        }
        System.out.println();

    }

    void hit(int i, int ind) {
        int score = player[i].getScore();
       // System.out.println(score);
        player[i].c[ind] = randomCard();
        score = score + player[i].c[ind].getValue();
        if(score==21){
            player[i].setBlack(true);
        }
        else if(score>=21){
            player[i].setOut(true);
        }
        player[i].setScore(score);
        System.out.println(player[i].getScore());
    }

    void win() {
    int max = 0;
    int arr[]=new int[4];
        for (int i = 0; i < 4; i++) {
            if (player[i].getScore() >VALID && player[i].getScore()<=21) {
              
                VALID = player[i].getScore();
                max = i;
            }
        }
        System.out.println("the maximum score is " + VALID + " and the winner is " + player[max].getName());
    }
    
    void print_scores(){
        System.out.println("Player 1 score"+player[0].getScore());
        System.out.println("Player 2 score"+player[1].getScore());
        System.out.println("Player 3 score"+player[2].getScore());
        System.out.println("Player 4 score"+player[3].getScore());
    }
  
   public int val(){
        int l=0;
         for (int i = 0; i < 4; i++) {
            if (player[i].getScore() > VALID && player[i].getScore() <= 21) {
                VALID = player[i].getScore();
                l=i;
            }
        }
         return VALID;
   } 
}