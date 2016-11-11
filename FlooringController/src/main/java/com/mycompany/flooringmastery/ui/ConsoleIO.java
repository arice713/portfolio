/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {

    Scanner sc = new Scanner(System.in);

    public void print(String msg) {
        System.out.println(msg);
    }

    public String readString(String prompt) {

        System.out.println(prompt);
        
        return sc.nextLine();
    }

    public int readInt(String prompt) {
        boolean badInput;
        String result;
        int bob= 0;
        do {
            System.out.println(prompt);
                result = sc.nextLine();
            try {
                
                bob = Integer.parseInt(result);
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }

        } while (badInput);
        
        return bob;

    }

    public long readLong(String prompt) {
        boolean badInput;
        long result = 0;
        do {
            try {
                System.out.println(prompt);
                result = sc.nextLong();
                badInput = false;

            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();

            }
        } while (badInput);
        return result;
    }

    public long readlong(String prompt, long min, long max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);
        return result;
    }

    public float readFloat(String prompt) {
        boolean badInput;
        float result = 0;
        do {
            try {
                System.out.println(prompt);
                result = sc.nextFloat();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);
        return result;

    }

    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);

        } while (result < min || result > max);
        return result;
    }

    public double readDouble(String prompt) {
        boolean badInput;
        double result = 0;
        do {
            try {
                System.out.println(prompt);
                result = sc.nextDouble();
                badInput = false;

            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);
        return result;
    }

    public double readDouble(String prompt, double min, double max) {
        long result;
        do {
            result = readLong(prompt);

        } while (result < min || result > max);
        return result;
    }

    
}
