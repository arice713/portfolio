/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery;

import com.mycompany.flooringmastery.dao.ItemDAOFileImpl;
import com.mycompany.flooringmastery.dao.OrderDAOFileImpl;
import com.mycompany.flooringmastery.dao.TaxDAOFileImpl;
import com.mycompany.flooringmastery.ops.OrderController;

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {
        ItemDAOFileImpl itemDAO = new ItemDAOFileImpl();
        OrderDAOFileImpl orderDAO = new OrderDAOFileImpl();
        TaxDAOFileImpl taxDAO = new TaxDAOFileImpl();
        
        OrderController controller = new OrderController(orderDAO, itemDAO,taxDAO);
        controller.run();
    }
}