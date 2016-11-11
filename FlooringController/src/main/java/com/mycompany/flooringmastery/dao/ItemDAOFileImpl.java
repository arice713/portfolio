/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dao.ItemDAO;
import com.mycompany.flooringmastery.dto.ItemDTO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class ItemDAOFileImpl implements ItemDAO {

    private final String FILE_NAME;
    private HashMap<String, ItemDTO> floorItems;
    private final String DELIMITER = "::";

    public ItemDAOFileImpl() {
        FILE_NAME = "floorItems.txt";
        floorItems = new HashMap<>();
        load();
    }

  
    @Override
    public HashMap<String, ItemDTO> getAllItems() {
        return floorItems;
    }

  
    @Override
    public ItemDTO getItem(String itemId) {
        return floorItems.get(itemId);
    }

 


    private void load() {

        try {
            loadFromFile();
        } catch (IOException ex) {
            Logger.getLogger(ItemDAOFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    private void loadFromFile() throws IOException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));
            while (sc.hasNextLine()) {
                String itemLine = sc.nextLine();
                String[] itemProperties = itemLine.split(DELIMITER);

                if (itemProperties.length != 3) {
                    continue;

                }
                ItemDTO aItem = null;
                try {
                    double laborPrice = Double.parseDouble(itemProperties[1]);
                    aItem = new ItemDTO();
                    aItem.setProductType(itemProperties[0]);
                    aItem.setLaborCostPerSquareFt(laborPrice); //parse into double
                    aItem.setCostPerSquareFt(Double.parseDouble(itemProperties[2]));

                    floorItems.put(aItem.getProductType(), aItem);
                } catch (NumberFormatException numberFormatException) {
                    continue;
                }
            }

            sc.close();

        } catch (FileNotFoundException ex) {
            new FileWriter(FILE_NAME);
        }

    }

}
