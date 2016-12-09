/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LuckySevens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader= new Scanner(System.in);
        
        System.out.println("How many dollars do you have?");
        String startingBet= reader.nextLine();
        int bet=Integer.parseInt(startingBet);
        int mostMoney=bet;
        int numberOfRolls=0;
        int highestRolls=0;
        Random number = new Random();
        do
        {
            int dice1=number.nextInt(6)+1;
            int dice2=number.nextInt(6)+1;
            numberOfRolls++;
        if ((dice1+dice2)==7)    
        {
            bet=bet+4;
            System.out.println("You win!!");
        }
        else
        {
            bet--;
        }  
        if( bet>mostMoney )
         {
           mostMoney=bet;
           highestRolls=numberOfRolls;
                    
         }
            
        } while(bet>=0);
        
        
        System.out.println("You're broke after"+numberOfRolls);
        System.out.println("You should have quit after"+highestRolls +"When you had"+mostMoney);
    }
}
