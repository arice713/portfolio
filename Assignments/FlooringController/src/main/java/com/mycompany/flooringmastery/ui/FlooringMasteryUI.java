/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.ui;

import com.mycompany.flooringmastery.dao.ItemDAO;
import com.mycompany.flooringmastery.dao.OrderDAO;
import com.mycompany.flooringmastery.dao.TaxDAO;
import java.io.Console;
import java.io.IOException;
import static java.lang.System.console;
import java.util.Collection;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryUI {

    static ConsoleIO console  = new ConsoleIO();

    String date = "";

    public static void printMenu() {
        console.print("Menu");
        console.print("1. Place an order.");
        console.print("2. Search for order by Id.");
        console.print("3. Delete Order.");
        console.print("4. Update order.");
        console.print("5. Save and exit program.");
    }

}
