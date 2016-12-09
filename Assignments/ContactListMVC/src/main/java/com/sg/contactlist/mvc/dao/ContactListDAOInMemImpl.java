/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlist.mvc.dao;

import com.sg.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ContactListDAOInMemImpl implements ContactListDAO{
    
    private Map<Integer, Contact> contactMap = new HashMap<>();
     
    private static int contactIdCounter = 0;

    @Override
    public Contact addContact(Contact contact) {
        // We need to keep track of the ID manually right now
        // In our DB implementation, the database will assign the ID
        // add our contact to the map
        contact.setContactId(contactIdCounter);
        //Once we assign the Id, we need to increment the counter for the next contact
        contactMap.put(contact.getContactId(),contact);
        return contact; 
    }

    @Override
    public Contact getContactById(int contactId) {
      //Get the contact from the hashmap which uses the ID as its key
      return contactMap.get(contactId);
    }

    @Override
    public List<Contact> getAllContactsByName(String nameToSearch) {
      // We want all of our contact, but do we reallt need the hashmap?
      // Not really,  we just need a list of contacts 
      //the Id is still on the contact object, so values() would have what we need
      Collection<Contact> allContacts = contactMap.values();
      return new ArrayList(allContacts);
    }

    @Override
    public void updateContact(Contact contact) {
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public void removeContact(int contactId) {
       // remove the contact from the hashmap
      contactMap.remove(contactId);
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
       String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
       String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
       String companyCriteria = criteria.get(SearchTerm.COMPANY);
       String phoneCriteria = criteria.get(SearchTerm.PHONE);
       String emailCriteria = criteria.get(SearchTerm.EMAIL);
       
       Predicate<Contact> firstNameMatches;
       Predicate<Contact> lastNameMatches;
       Predicate<Contact> companyMatches;
       Predicate<Contact> phoneMatches;
       Predicate<Contact> emailMatches;
       
       // Default predicate 
       Predicate<Contact> truePredicate = (c) -> {return true;};
       
       firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())?
               truePredicate 
               :(c) -> c.getFirstName().equals(firstNameCriteria);
       
       lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())?
               truePredicate
               :(c) -> c.getLastName().equals(lastNameCriteria);
       companyMatches = (companyCriteria == null || companyCriteria.isEmpty())?
               truePredicate
               :(c) -> c.getCompany().equals(companyCriteria);
       phoneMatches = (phoneCriteria == null || phoneCriteria.isEmpty())?
               truePredicate
               :(c) -> c.getPhone().equals(phoneCriteria);
       emailMatches = (emailCriteria == null || emailCriteria.isEmpty())?
               truePredicate
               :(c) -> c.getEmail().equals(emailCriteria);
       
       return contactMap.values().stream()
               .filter(firstNameMatches
               .and(lastNameMatches)
               .and(companyMatches)
               .and(companyMatches)
               .and(phoneMatches)
               .and(emailMatches))
               .collect(Collectors.toList());
       
    }

    @Override
    public List<Contact> getAllContacts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
