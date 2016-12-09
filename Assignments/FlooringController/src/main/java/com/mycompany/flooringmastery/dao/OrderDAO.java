/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.OrderDTO;
import java.util.Collection;

/**
 *
 * @author apprentice
 */
public interface OrderDAO {

    OrderDTO addOrder(OrderDTO aOrder);

    Collection<OrderDTO> getAllOrders(String date);

    OrderDTO getOrder(String date, int Order);
      
    public void updateOrder(OrderDTO orderToUpdate);

    void removeOrder(String date, int order);

    void save();
    //parse into decimal

  

    

  
    
}
