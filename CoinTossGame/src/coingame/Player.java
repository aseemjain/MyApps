/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coingame;

/**
 *
 * @author ajain
 */
public class Player {
    
private   Coin.coinOption selectedOption; 

    public Coin.coinOption getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(Coin.coinOption selectedOption) {
        this.selectedOption = selectedOption;
    }
private   String name;
   
   public void claimCoinOption(String playerChoice){
   if(playerChoice.equalsIgnoreCase("1")){
      selectedOption = Coin.coinOption.HEAD; 
       System.out.println("Player has choosen " + Coin.coinOption.HEAD);
   }else{
      selectedOption = Coin.coinOption.TAIL; 
      System.out.println("Player has choosen " + Coin.coinOption.TAIL);
    }
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
