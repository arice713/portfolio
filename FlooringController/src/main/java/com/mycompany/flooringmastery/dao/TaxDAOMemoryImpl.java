/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.TaxDTO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class TaxDAOMemoryImpl implements TaxDAO {
 
    private HashMap<String, TaxDTO> floorTaxs;
    

    public TaxDAOMemoryImpl() {
     
        floorTaxs = new HashMap<>();
       
    }

  
   
    @Override
    public Collection<TaxDTO> getAllTaxs() {
        return floorTaxs.values();
    }

  
    
    @Override
    public TaxDTO getTax(String itemId) {
        return floorTaxs.get(itemId);
    }

 




}
