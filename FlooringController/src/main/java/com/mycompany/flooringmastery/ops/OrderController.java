/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.ops;

import com.mycompany.flooringmastery.dao.TaxDAO;
import com.mycompany.flooringmastery.dao.OrderDAO;
import com.mycompany.flooringmastery.dao.ItemDAO;
import com.mycompany.flooringmastery.dao.ItemDAOMemoryImpl;
import com.mycompany.flooringmastery.dao.OrderDAOMemoryImpl;
import com.mycompany.flooringmastery.dao.TaxDAOMemoryImpl;
import com.mycompany.flooringmastery.dto.ItemDTO;
import com.mycompany.flooringmastery.dto.OrderDTO;
import com.mycompany.flooringmastery.dto.TaxDTO;
import com.mycompany.flooringmastery.ui.ConsoleIO;
import com.mycompany.flooringmastery.ui.FlooringMasteryUI;
import java.io.IOException;
import static java.lang.System.console;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class OrderController {

    private ConsoleIO console = new ConsoleIO();
    private OrderDAO orderDAO;
    private ItemDAO ItemDAO;
    private TaxDAO TaxDAO;

    public OrderController(OrderDAO OrderDAO, ItemDAO ItemDAO, TaxDAO TaxDAO) {
        this.orderDAO = OrderDAO;
        this.ItemDAO = ItemDAO;
        this.TaxDAO = TaxDAO;
    }

    public void run() {

        boolean keepGoing = true;
        do {
            FlooringMasteryUI.printMenu();
        
        int userChoice = console.readInt("Please choose an option");
        switch (userChoice) {
            case 1:
                this.addNewOrder();
                break;
            case 2:
                this.searchOrderId();
                break;

            case 3:
                this.removeOrder();
                break;
            case 4:
                this.updateOrder();
                break;
            case 5:
                orderDAO.save();

                keepGoing = false;
                break;
            default:
                break;
        }
    } while (keepGoing);
    }

    private void addNewOrder() {
        console.print("Please place your order.");
        OrderDTO aOrder = new OrderDTO();
        String CustomerName = console.readString("May I have your name.");

        //Double TaxRate = console.readDouble("What is the state?");
        String State = console.readString("What is the state?");
        String ProductType = console.readString("What is the product?");

        double Area = console.readDouble("What is the area?");
        TaxDTO tax = TaxDAO.getTax(State);
        ItemDTO product = ItemDAO.getItem(ProductType);

        aOrder.setName(CustomerName);

        tax.setTaxRate(tax.getTaxRate());

        tax.setAbbr(State);
        aOrder.setTax(tax);

        product.setProductType(ProductType);

        product.setCostPerSquareFt(product.getCostPerSquareFt());

        product.setLaborCostPerSquareFt(product.getLaborCostPerSquareFt());
        aOrder.setProduct(product);

        aOrder.setArea(Area);

      orderDAO.addOrder(aOrder);

    }

    private void searchOrderId() {
        console.print("Search by Order Id.");
        int orderId = console.readInt("Order Id:");
        String date = console.readString("Enter date");
        OrderDTO foundOrder = orderDAO.getOrder(date, orderId);

        if (foundOrder == null) {
            console.print("There are no Orders with that Id number...");

        } else {
            console.print("Order number:" + foundOrder.getOrder() + "");
            console.print("Name:" + foundOrder.getName());
            console.print("state:" + foundOrder.getTax().getAbbr());
            console.print("Tax:" + foundOrder.getTax().getTaxRate());
            console.print("Total:" + foundOrder.getTotal());
        }
    }

    private void removeOrder() {
        console.print("Delete Order");
        int orderId = console.readInt("Order has been deleted!");
          String date = console.readString("Enter date");
    orderDAO.removeOrder(date, orderId);
     }

    private void updateOrder() {
        console.print("Update Order");
         String date = console.readString("Enter date");
         int orderId = console.readInt("Order ID");
     OrderDTO order= orderDAO.getOrder(date, orderId);
     
     if(order == null){
         console.print("The order does not exist!");
         return;
        
     }else {
         String name = console.readString("Name (" + order.getName() + ")");
         if (!name.isEmpty()) {
             order.setName(name);
         }
         
         String product = console.readString("Product(" + order.getProduct() +")");
         if (!product.isEmpty()){
             HashMap<String, ItemDTO> items = ItemDAO.getAllItems();
             boolean inputCorrect = false;
                  
             for(String key : items.keySet()) {
                 if (product.equalsIgnoreCase(key)) {
                     inputCorrect = true;
                     
                    order.setProductName(product);
                    break;
                 }
                 
                     
             }
             if (inputCorrect == false){
                 console.print("This product does not exsits");
             
             }
                     
             
             
             
             
             
         }
         String state = console.readString("State(" + order.getstate()+")");
         if(!state.isEmpty()){
             order.setstate(state);
         }
         String area = console.readString("Area(" + order.getArea()+")");
        
         if (!area.isEmpty()){
            order.setArea(Double.parseDouble(area)); 
         }
         
         
         
         
     }
    }

      /* 
    private void calculateCost(OrderDTO aOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
}
