/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalc;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SimpleCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        System.out.println("Please choose from the following menu!");
        System.out.println("a. Add");
        System.out.println("b. Subtract");
        System.out.println("c.  Divide");
        System.out.println("d.  Multiply");
        
        System.out.println("please enter in an equation!");
        String choice = sc.nextLine();
        System.out.println();

        
        if (choice == a)
        {
            add();
            
        }
        else if (choice == b)
        {
            subtract();
            
        }
        else if (choice = c)
        {
            divide();
        }
        else if (choice = d)
        {
            multiply();
            
        }
        
        System.out.println();
        sc.close();
    }
    
    
}
