
package blackjack;

import java.util.Scanner;

public class BlackJack {

  
    static Game gam =new Game();;
    static int card_num = 2;
    static int i = 0;
    static Scanner in= new Scanner(System.in);
;
    public static void main(String[] args) {

        gam.generate();
        for (int i = 1; i <= 3; i++) {
            System.out.println("player"+i);
            System.out.println("Enter your name : ");
            String name = in.next();
            gam.setname(name);
        }
        gam.setname("dealer");
        GUI gui = new GUI();
        gui.runGUI(gam.card, gam.player[0].c, gam.player[1].c, gam.player[2].c, gam.player[3].c);
        while (i < 3) {
            int k=i+1;
            System.out.println("player :"+k);
            System.out.println("------------------------------");
            k++;
            System.out.println("hit or stand");
            String c = in.next();
            if (gam.player[i].getScore() < 21) {
                if (c.equals("hit") && gam.player[i].getScore() <= 21) {
                    gam.hit(i, card_num);
                    gui.updatePlayerHand(gam.player[i].c[card_num], i);
                    card_num++;
                } 
               
                else if (c.equals("stand") || gam.player[i].getScore() >= 21) {
                   i++;
                }
                 if(gam.player[i].getScore() >= 21){
                    i++;
                }
            }
            else {
                i++;
            }
            
        }
        while (i == 3) {
            if (gam.player[i].getScore() < 21||gam.player[i].getScore()<gam.val()) {
                if (gam.player[i].getScore() < 21) {
                    gam.hit(i, card_num);
                    gui.updateDealerHand(gam.player[i].c[card_num], gam.card);
                    card_num++;
                } else if (gam.player[i].getScore() >= 21) {
                    break;
                }
            } else {
                break;
            }
        }
        gam.win();
    }
}
