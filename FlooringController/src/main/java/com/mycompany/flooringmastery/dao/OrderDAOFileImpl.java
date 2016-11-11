/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.ItemDTO;
import com.mycompany.flooringmastery.dto.OrderDTO;
import com.mycompany.flooringmastery.dto.TaxDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.annotation.Order;

/**
 *
 * @author apprentice
 */
public class OrderDAOFileImpl implements OrderDAO {

    private String FILE_NAME;
    private final HashMap<String, Map<Integer, OrderDTO>> floorItems;
    private final String DELIMITER = "::";

    public OrderDAOFileImpl() {
        FILE_NAME = "floorItems.txt";
        floorItems = new HashMap<>();
    }

    @Override
    public OrderDTO addOrder(OrderDTO aOrder) {
        //determine if order date was loaded

        //if so we need to add this order to the hashmap inside the value
        //if not i need to load the hashmap from the file and then added to hashmap
        int id = 0;
        loadFromFile(aOrder.getDate());
        id = getMaxId(aOrder.getDate(), id);
        aOrder.setOrder(id);
        floorItems.get(aOrder.getDate()).put(aOrder.getOrder(), aOrder);

        return aOrder;
    }

    private void loadFromFile(String date) {
        if (!floorItems.containsKey(date)) {

            floorItems.put(date, load(date));

        }
    }
        
    @Override
    public void updateOrder(OrderDTO orderToUpdate){
        // TODO:
        // Put orderToUpdate.getDate() in a variable
        // Put orderToUpdate.getOrder() in a variable
        // Are either of these two coming back NULL?  (Use the debugger and debug the focused test
         floorItems.get(orderToUpdate.getDate()).put(orderToUpdate.getOrder(), orderToUpdate);
                  }

    private int getMaxId(String date, int id) {
        Set<Integer> ids = floorItems.get(date).keySet();
        for (Integer i : ids) {
            if (i > id) {
                id = i;
            }
        }
        id++;
        return id;
    }

    @Override
    public Collection<OrderDTO> getAllOrders(String date) {
        loadFromFile(date);
        return floorItems.get(date).values();
    }

    @Override
    public OrderDTO getOrder(String date, int Order) {
        loadFromFile(date);
        return (OrderDTO) floorItems.get(date).get(Order);
    }

    @Override
    public void removeOrder(String date, int order) {
        loadFromFile(date);
        floorItems.get(date).remove(order);
    }

    private HashMap<Integer, OrderDTO> load(String date) {
        HashMap<Integer, OrderDTO> result = new HashMap<>();
        // loadFromFile();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));
            while (sc.hasNextLine()) {
                String itemLine = sc.nextLine();
                String[] itemProperties = itemLine.split(DELIMITER);

                if (itemProperties.length != 11) {
                    continue;

                }
                OrderDTO aOrder = null;
                try {
                    int OrderNumber = Integer.parseInt(itemProperties[0]);
                    String CustomerName = itemProperties[1];
                    String State = itemProperties[2];

                    Double TaxRate = Double.parseDouble(itemProperties[3]);
                    String ProductType = itemProperties[4];

                    Double Area = Double.parseDouble(itemProperties[5]);
                    Double CostPerSquareFoot = Double.parseDouble(itemProperties[6]);
                    Double LaborCostPerSquareFoot = Double.parseDouble(itemProperties[7]);
                    Double MaterialCost = Double.parseDouble(itemProperties[8]);
                    Double LaborCost = Double.parseDouble(itemProperties[9]);
                    Double Tax = Double.parseDouble(itemProperties[10]);
                    Double Total = Double.parseDouble(itemProperties[11]);
                    aOrder.setOrder(OrderNumber);
                    aOrder.setName(CustomerName);
                    TaxDTO tax = new TaxDTO();
                    tax.setTaxRate(TaxRate);
                    tax.setAbbr(State);
                    aOrder.setTax(tax);
                    ItemDTO product = new ItemDTO();
                    product.setProductType(ProductType);
                    product.setCostPerSquareFt(CostPerSquareFoot);
                    product.setLaborCostPerSquareFt(LaborCostPerSquareFoot);
                    aOrder.setProduct(product);
                    aOrder.setArea(Area);
                    aOrder.setMaterialCost(MaterialCost);
                    aOrder.setLaborCost(LaborCost);
                    aOrder.setTotalTax(Tax);
                    aOrder.setTotal(Total);
                    result.put(OrderNumber, aOrder);

                } catch (NumberFormatException numberFormatException) {
                    continue;
                }
            }
//parse into decimal
            sc.close();

        } catch (FileNotFoundException ex) {
            //new FileWriter(FILE_NAME);
        }
        return result;

    }

    @Override
    public void save() {

        for (String date : floorItems.keySet()) {
            String fileName = date;
            Collection<OrderDTO> orders = floorItems.get(date).values();
            PrintWriter Writer;
            try {
                Writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

                for (OrderDTO aOrder : orders) {
                    String record
                            = aOrder.getOrder() + DELIMITER
                            + aOrder.getName() + DELIMITER
                            + aOrder.getTax().getTaxRate() + DELIMITER
                            + aOrder.getTax().getAbbr()+ DELIMITER
                            + aOrder.getProduct().getProductType() + DELIMITER
                            + aOrder.getProduct().getCostPerSquareFt() + DELIMITER
                            + aOrder.getProduct().getLaborCostPerSquareFt() + DELIMITER
                            + aOrder.getArea() + DELIMITER
                            + aOrder.getMaterialCost() + DELIMITER
                            + aOrder.getLaborCost();
                    Writer.print(record);
                    Writer.flush();

                }

                Writer.close();
            } catch (IOException ex) {
                Logger.getLogger(OrderDAOFileImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
//parse into decimal

}
