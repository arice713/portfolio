/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.funwithconditionals;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class funWithConditionals {

    public static void main(String[] args) {
        final int OLD_AGE_MINIMUM = 55;
        final int YOUNG_AGE_mAXIMUM = 17;
        //Ask for a person's age
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your age!");
        String age = sc.nextLine();

        int myAge = Integer.parseInt(age);
        //If the person is older than 55, output "AARP Welcomes You!"
        if (myAge >= OLD_AGE_MINIMUM) {
            System.out.println("AARP Welcomes You");
        } else {
            System.out.println("You are not eligible for AARP.");
        }

        // If the person is older than the Old age minimum, output "ROck On"
        // If the person is younger than Young Age Maximum, out put "keep growing"
        //Otherwise, output "Work work..."
        if (myAge > OLD_AGE_MINIMUM) {
            System.out.println("Rock on!");
        } else if (myAge < YOUNG_AGE_MINIMUM) {
        } else if (myAge == OLD_AGE_MINIMUM || myAge == YOUNG_AGE_MAXIMUM) {
            System.out.println("One more year...one more year...");
        } else {
            System.out.println("work work...");
        }

        boolean isWednesday = true;
        if (isWednesday) {
            System.out.println("GAME NIGHT!!");
        } else {
            System.out.println("PBDs all night long:(");
        }

        //Using is NOT operator
        if (!isWednesday) {
            System.out.println("PBDs..make them stop!");
        } else {
            System.out.println("Abreak from pBDs!");

            //switch - can reorganize if...else if ... else if... whenits just a value
            //switch cannot operate with expressions
            String lunchChoice;
            System.out.println("Enter a day of the week:");
            String dayOfWeek = "Monday";

            //Monday -Hattie's
            //Tuesday - Subway
            //Wednesday - Spagetti Warehouse
            //Thursday - Pizzafire
            //Friday - Pita Pit
            //Saturday & Sunday - Home
            switch (dayOfWeek) 
                = sc.nextLine();
                    case "monday"
                    lunchChoice = "Hattie's";
                    break;
                case "tuesday"
                    lunchChoice = "Subway";
                    break;
                case "wednesday"
                    lunchChoice = "Spagetti Warehouse";
                    break;
                case "thursday"
                    lunchChoice = Pizzafire;
                    break;
                case "friday"
                    lunchChoice = "Pita Pit"
                    break;
                case "Saturday"
                case "Sunday"
                    lunchChoice = Home;
                    break;
                    defualt:
                    lunchChioce = "invaild";

                    //Loops
                    //Do...while -run at least once
                    do {
                        System.out.println("Enter anyday of the week or enter anyday to stop:");
                        dayOfWeek = sc.nextLine();
                        System.out.println("You Entered:" + dayOfWeek);
                    } while (dayOfWeek) !="friday");
                 
                 //while loop - only runs while condition is true
                 //The while loop may not necessarily execute
                 //This while won't excute, based on the conditions from our
                 //previous do...while
                 
                 while (dayofWeek != "friday") {
                        System.out.println("While loop - Enter anything or enter friday to stop")
                        dayOfWeek = sc.nextLine();
                        System.out.println("You enetered:" + dayOfWeek) //However, this will run is while will run
                                //This will run once anthen when number is 43, the while will ext
                        int number = 42;
                        while (number % 2 == 0) {
                            System.out.println("Number:" + number);
                            number += 1; //Number = number

                        }

                        System.out.println("===============");
                        System.out.println("For loops");

                        //Let's look at numbers 1-10
                        //For even numbers, print number + "; even"
                        //Else print number + ":odd"
                        for (int loopCounter = 1; loopCounter <<= 10; loopCounter++) {
                            if (loopCounter % 2 == 0) {
                                System.out.println(loopCounter + ":even");
                            } else {
                                System.out.println(loopCounter + ":odd");

                            }

                        }
                        //Lets look at the other steps
                        for (int randomwCounter = 0; randomCounter <= 5 randomCounter++){
                            //random numbers are between 1 and 10 inclusive
                            Random rGen =new Random();
                            int randomInt =rGen.nextInt(10) + 1;
                            System.out.printerln("Random number " + randomCounter + "")
                                   
                           
                        }
                            
                    }
            }

        }
    }

}
