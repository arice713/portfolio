/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsrefactored;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Rockpaperscissorsrefactored {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args){
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Enter a Selection!");
        System.out.println("1 for rock!");
        System.out.println("2 for paper!");
        System.out.println("3 for scissors!");
        
            
        

        public static String generateComputersChoice()
        {
            Random randomGenrator = new Random();
            int randomNumber = randomGenrator.nextInt(3);

            String choice = "none";
            switch(randomNumber){
            case 1: choice = "1";
                break;
            case 2: choice = "2";
                break;
            case 3: choice = "3";
                break;
            }
            return choice;
            }

        String option;
         option= reader.nextLine();
         int selection= Integer.parseInt(option); 
         System.out.println(""+answer);
         if (selection==answer)
         {
             System.out.println("Game is a tie!");
         }
         if (selection==1 )    
         {
             if(answer==2)
            {
                System.out.println("computer is the winner!");
            }   
             else
             {
                 System.out.println("Player is the winner!");
             }
          }
          if(selection==2)
          {
              if(answer==3)
              {
                  System.out.println("computer is the winner!");
              }
              else
              {
                  System.out.println("Player is the winner!");
              }
          }
           if (selection==3)
           {
               if(answer==1)
               {
                   System.out.println("computer is the winner!");
               }
               else
               {
                   System.out.println("Player is the winner!");
               }
            
           }

          


            int ties = 0;
            int playerWins = 0;
            int compWins = 0;

            for(int i = 0; i < 3; i ++)
            {



      
         
           System.out.println( "\nTies: " +ties+);
           System.out.println("\nComputer Wins: " +compWins+);
           System.out.println("\nPlayer Wins: " + playerWins+);
           System.out.println("\n\n Program Terminating", "Results",1);
        }
}
}