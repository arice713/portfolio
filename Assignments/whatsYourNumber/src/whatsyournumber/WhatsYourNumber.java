/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsyournumber;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WhatsYourNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner reader = new Scanner(System.in);
        Random random = new Random();
        int minNum = 1;
        int maxNum = 20;
        int comp = random.nextInt(minNum - maxNum +1) +minNum;
        int user;
        int guesses = 0;
        
        do
        {
            System.out.println("Please enter a number!");
            user = input.nextInt();
            guesses++;
            System.out.println(minNum + (guesses +1));
            System.out.println("Thanks for playing!");
        }
        }
        
        
       
        
    }
    
