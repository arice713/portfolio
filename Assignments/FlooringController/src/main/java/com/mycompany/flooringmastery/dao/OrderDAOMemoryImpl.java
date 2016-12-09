/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.OrderDTO;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class OrderDAOMemoryImpl implements OrderDAO {

    private String FILE_NAME;
    private  HashMap<String, Map<Integer, OrderDTO>> floorItems;
    private final String DELIMITER = "::";

    public OrderDAOMemoryImpl() {
        FILE_NAME = "floorItems.txt";
        floorItems = new HashMap<String, Map<Integer, OrderDTO>>();
    }

    @Override
    public OrderDTO addOrder(OrderDTO aOrder) {
        //determine if order date was loaded

        //if so we need to add this order to the hashmap inside the value
        //if not i need to load the hashmap from the file and then added to hashmap
        int id = 0;

        id = getMaxId(aOrder.getDate(), id);
        aOrder.setOrder(id);
        if(!floorItems.keySet().contains(aOrder.getDate())){
            floorItems.put(aOrder.getDate(), new HashMap<Integer, OrderDTO>());
        }
        floorItems.get(aOrder.getDate()).put(aOrder.getOrder(), aOrder);
        return aOrder;
    
    }
    private int getMaxId(String date, int id) {
        if (floorItems.get(date) != null) {
            Set<Integer> ids = floorItems.get(date).keySet();
            for (Integer i : ids) {
                if (i > id) {
                    id = i;
                }
            }
            id++;
        }
        return id;
    }
   
    @Override
    public void updateOrder(OrderDTO orderToUpdate){
        if (floorItems.containsKey(orderToUpdate.getDate())){
                   floorItems.get(orderToUpdate.getDate()).put(orderToUpdate.getOrder(), orderToUpdate);
  
        }
                 }

    @Override
    public Collection<OrderDTO> getAllOrders(String date) {
if (floorItems.containsKey(date)){
    return floorItems.get(date).values();
}return null;
        
    }

    @Override
    public OrderDTO getOrder(String date, int Order) {

        return (OrderDTO) floorItems.get(date).get(Order);
    }

    @Override
    public void removeOrder(String date, int order) {

        floorItems.get(date).remove(order);
    }

    @Override
    public void save() {
    }

}
