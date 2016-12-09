/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalc;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
 
        double principal;
        double rate;
        double simpleInterest;
        int time;
 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year number: ");
        principal = sc.nextDouble();
 
        System.out.print("The principal at the begging of the year: ");
        rate = sc.nextDouble();
 
        System.out.print("Interest for this year: ");
        time = sc.nextInt();
 
        simpleInterest = (principal * rate * time) / 100;
        System.out.println("Total amount of interest earned:  " + simpleInterest);
 
    } 
} 


