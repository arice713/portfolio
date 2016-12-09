/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook;

import java.util.InputMismatchException;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class ConsoleIOTest {
    
    

    @Test
    
        public float readFloat(String prompt){
        boolean badInput;
        float result = 0;
        do{
            try{
                System.out.println(prompt);
                result = sc.nextFloat();
                badInput = false;
            } catch (InputMismatchException ime){
                badInput = true;
                sc.nextLine();
            }
        }while (badInput);
        return result;
        
    }

    

