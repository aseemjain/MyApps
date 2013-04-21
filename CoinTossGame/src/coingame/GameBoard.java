/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coingame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ajain
 */
public class GameBoard {
    
    public static void main(String[] args) throws IOException {
        System.out.println("################### Welcome to Coin toss Game ################### ");
        System.out.println("Rules : \n There are 2 players in the game. \n Player one will select the option Head/Tail "
                + "\n The coin is flipped and winner is declared");
        Coin coin = new Coin();
        Player p1 = new Player();
        System.out.println("\n Player One please enter your choice as 1 for Head and  2 for Tail ? ");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        p1.claimCoinOption(br.readLine());
        Player p2 = new Player();
        Coin.coinOption winningOption = coin.flip();
        
        
        if(winningOption.equals(p1.getSelectedOption()))
            System.out.println("\nPlayer 1 won");
        else{
            System.out.println("\n Player 2 won");
        }
        
    }
    
    
}
