/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.TaxDTO;
import java.util.Collection;

/**
 *
 * @author apprentice
 */
public interface TaxDAO {

    Collection<TaxDTO> getAllTaxs();

    TaxDTO getTax(String itemId);
    
}
