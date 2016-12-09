/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.ItemDTO;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface ItemDAO {

    HashMap<String, ItemDTO> getAllItems();

    ItemDTO getItem(String itemId);
    
}
