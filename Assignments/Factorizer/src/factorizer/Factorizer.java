/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorizer;

import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Factorizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        String numberToFactor;
        
        System.out.println("What number would you like to factor");
        numberToFactor= reader.nextLine();
        int number= Integer.parseInt(numberToFactor);
        
        System.out.println("The number you choose was" +number);
       
        int reduceNumber= number;
        ArrayList<Integer> bucket = new ArrayList<Integer>();
        
        
        do {// reduce number goes down by 1.
            //check 5 and compare to 6.
            reduceNumber--;
            int mod =number % reduceNumber; 
            if (mod==0){
             bucket.add(reduceNumber);
             
            }
           
   
        }while(reduceNumber > 1);
        System.out.println("Print total number of factors");
        System.out.println(bucket.size());
        
        System.out.println("Print all of the factors");
        for (int x : bucket){
            System.out.println(x);
            
        }
        
        int perfect= 0;
        for (int x : bucket) {
            System.out.println(x);
            perfect=perfect+x;
            
        }
        if(number == perfect)
        {
            System.out.println("Your number is perfect!");
        }    
        else
        {  
            System.out.println("Your number is not perfect");
        } 
    
        System.out.println("Print if the number prime");
        //1, 3, 5, 7, 11, 13, 17, 19, 23]
        
        if (bucket.size()==1)
        {
            System.out.println("Your number is Prime!");
        }
        else
        {
            System.out.println("Your number is not Prime!");
        }
    }    
}