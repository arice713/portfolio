/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

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
        // TODO code application logic here
    
        System.out.println("LuckySevens");
       

        String StartingBet;
        String RollsDice;
        String PlayerWins;
        String PlayerLoses;
    
        
        StartingBet = getUserInput("How many dollars do you have?");
        
        System.out.println("");
    
    } 
    public static String getUserInput(String prompt) {
        Scanner sc= new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
        
    public static String getUserinput(String prompt) {
        Scanner sc= new Scanner (System.in);
        System.out.println(prompt);
        return sc.nextLine();
        
        RollsDice = getUserInput()
    } 
    }
    
}
