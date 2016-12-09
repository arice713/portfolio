/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionmvc.DAO;

import com.mycompany.dvdcollectionmvc.model.Dvd;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DvdCollectionDAO {
    
    public Dvd addDvd(Dvd dvd);
    // R - Read - get one object
    public Dvd getDvdById(int dvdId);
    // R - Read - get by name
    public List<Dvd> getAllDvdsByTitle(String titleToSearch);
    // R - Read - get all objects
    public List<Dvd> getAllDvds();
    // U - Update
    public void updateDvd(Dvd dvd);
 
    // D - Delete
    public void removeDvd(int dvdId);
    
    public List<Dvd> searchDvds(Map<SearchTerm,String> criteria);
    
}
