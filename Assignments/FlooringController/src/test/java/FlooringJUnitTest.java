/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.flooringmastery.dao.OrderDAO;
import com.mycompany.flooringmastery.dao.OrderDAOMemoryImpl;
import com.mycompany.flooringmastery.dto.OrderDTO;
import static java.lang.System.console;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author apprentice
 */
public class FlooringJUnitTest {

    OrderDAO testDAO;
    OrderDTO[] ordersForTesting = {
        
        new OrderDTO(375.0, 2, 52.0, 62.0, 67.0, "Jared", "OH", 13.2, 472.0, "10/22/16"),
        new OrderDTO(376.0, 1, 53.0, 63.0, 68.0, "Alyssa", "PA", 14.2, 474.0, "10/22/16"),
        new OrderDTO(377.0, 2, 54.0, 64.0, 69.0, "Steve", "OH", 15.2, 473.0, "10/21/16"),
        new OrderDTO(378.0, 1, 55.0, 65.0, 70.0, "Mark", "PA", 16.2, 475.0, "10/21/16")
    };

    public FlooringJUnitTest() {

    }

    @Before
    public void setUp() {
        testDAO = new OrderDAOMemoryImpl();

    }

    @Test
    public void addorder() {
        OrderDTO orderToAdd = ordersForTesting[0];
        testDAO.addOrder(orderToAdd);
        Assert.assertEquals(1, testDAO.getAllOrders("10/22/16").size());
        OrderDTO orderToAdd2 = ordersForTesting[3];
        testDAO.addOrder(orderToAdd2);
        Assert.assertEquals(1, testDAO.getAllOrders("10/21/16").size());
//       Assert.assertEquals("Returned Order does not match expected"OrderToAdd, testDAO.getOrder(orderToAdd.getId()));
//       Assert.assertNotNull("List of orders the should not be null", testDAO.getAllOrders());
//       Assert.asseretEquals("Expected order count of all orfders does not match after adding one order",1, testDAO.getAllOrders().size());
//       Assert.assertTrue("Returned order in getAllOrders does not match expected", testDAO.getAllOrders().contains(orderToAdd));             
    }

     @Test
     public void updateOrder(){
       
         OrderDTO orderToUpdate = ordersForTesting[1];
         OrderDTO actual = null;
         
         testDAO.addOrder(orderToUpdate);
         orderToUpdate.setName("test");
               
         testDAO.updateOrder(orderToUpdate);
         actual = testDAO.getOrder("10/22/16", orderToUpdate.getOrder());
         Assert.assertEquals("test",actual.getName());
    
      
  }   
      @Test
    public void removeOrder(){
        OrderDTO orderToAdd = ordersForTesting[1];
        testDAO.addOrder(orderToAdd);
     OrderDTO orderToRemove = ordersForTesting[1];
     String date = orderToRemove.getDate();
     int order = orderToRemove.getOrder();
     System.out.println(testDAO.getAllOrders("10/22/16").size());
     testDAO.removeOrder(date,order);
     Assert.assertEquals(0, testDAO.getAllOrders("10/22/16").size());
             
 }
      
  }

