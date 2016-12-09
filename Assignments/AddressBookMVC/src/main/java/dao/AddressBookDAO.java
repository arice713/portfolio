/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Map;
import models.Person;

/**
 *
 * @author apprentice
 */
public interface AddressBookDAO {
    
    public Person addPerson(Person person);
    
    public Person getPersonById(int personId);
    
    public List<Person> getAllPersonsByName(String nameToSearch);
    
    public List<Person> getAllPersons();
    
    public void updatePerson(Person person);
    
    public void removePerson(int personId);
    
    public List<Person> searchPersons(Map<SearchTerm,String> criteria);
    
  
}
