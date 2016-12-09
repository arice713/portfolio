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
public class AddressBookDAODbImpl implements AddressBookDAO{
    
    private static final String SQL_INSERT_PERSON = "insert into persons (first_name, last_name, company, phone, email) values (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PERSON = "delete from persons where person_id = ?";
    private static final String  SQL_SELECT_PERSON = "select * from persons where person_id = ?";
     private static final String SQL_UPDATE_PERSON = "update persons set first_name = ?, last_name = ?, company = ?, phone = ?, email = ? where person_id = ?";
    private static final String SQL_SELECT_ALL_PERSONS = "select * from persons";
    private static final String SQL_SELECT_PERSONS_BY_LAST_NAME = "select * from persons where last_name = ?";
    private static final String SQL_SELECT_PERSONS_BY_COMPANY = "select * from persons where company = ?";
    
    private JbdcTemplate jdbcTemplate;
    
    

     @Override
    public Person addPerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPersonById(int personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getAllPersonsByName(String nameToSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getAllPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePerson(int personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> searchPersons(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
           
}



   
    

    

    
    

