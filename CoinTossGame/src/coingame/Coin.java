/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coingame;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajain
 */
class Coin {

    
    public enum coinOption {
        HEAD, TAIL
    }

    Coin.coinOption flip() {
        System.out.print("Coin is Flipped. Wait for result ....  ");
        try {
            for (int i = 0; i < 4; i++) {
            Thread.sleep(500);
                System.out.print(" .... ");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Coin.class.getName()).log(Level.SEVERE, null, ex);
        }
        long num = Math.round(Math.random() * 10); // 1 digit random
        if (num <= 5) {
            return Coin.coinOption.HEAD;
        }
        return Coin.coinOption.TAIL;
    }
}
