/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.ItemDTO;
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
public class TaxDAOFileImpl implements TaxDAO {

    private final String FILE_NAME;
    private HashMap<String, TaxDTO> floorTaxs;
    private final String DELIMITER = "::";

    public TaxDAOFileImpl() {
        FILE_NAME = "floorTaxs.txt";
        floorTaxs = new HashMap<>();
        load();
    }

  
   
    @Override
    public Collection<TaxDTO> getAllTaxs() {
        return floorTaxs.values();
    }

  
    
    @Override
    public TaxDTO getTax(String itemId) {
        return floorTaxs.get(itemId);
    }

 


    private void load() {

        try {
            loadFromFile();
        } catch (IOException ex) {
            Logger.getLogger(TaxDAOFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    private void loadFromFile() throws IOException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));
            while (sc.hasNextLine()) {
                String itemLine = sc.nextLine();
                String[] itemProperties = itemLine.split(DELIMITER);

                if (itemProperties.length != 2) {
                    continue;

                }
                TaxDTO aTax = null;
                try {
                    aTax = new TaxDTO();
                    aTax.setAbbr(itemProperties[0]);
                    aTax.setTaxRate(Double.parseDouble(itemProperties[1]));

                    floorTaxs.put(aTax.getAbbr(), aTax);
                } catch (NumberFormatException numberFormatException) {
                    continue;
                }
            }
//parse into decimal
            sc.close();

        } catch (FileNotFoundException ex) {
            new FileWriter(FILE_NAME);
        }

    }

}
