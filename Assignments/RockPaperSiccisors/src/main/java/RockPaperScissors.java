
import static java.lang.Math.random;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class RockPaperScissors {
    


    public static void main (String [] args)
    {
     
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Enter a Selection!");
        System.out.println("1 for rock!");
        System.out.println("2 for paper!");
        System.out.println("3 for scissors!");
        
        Random number = new Random();
        int answer =number.nextInt(3)+1;
        
        
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
                
    }
       
}
