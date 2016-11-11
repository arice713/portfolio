/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dao.ItemDAO;
import com.mycompany.flooringmastery.dto.ItemDTO;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class ItemDAOMemoryImpl implements ItemDAO {

    private HashMap<String, ItemDTO> floorItems;

    public ItemDAOMemoryImpl() {
        floorItems = new HashMap<>();
    }

  

    @Override
    public HashMap<String, ItemDTO> getAllItems() {
        return floorItems;
    }

    @Override
    public ItemDTO getItem(String itemId) {
        return floorItems.get(itemId);
    }

   
}
