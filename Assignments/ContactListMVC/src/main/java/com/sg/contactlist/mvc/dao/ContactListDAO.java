/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlist.mvc.dao;

import com.sg.contactlistmvc.model.Contact;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface ContactListDAO {
    //c - create
    public Contact addContact(Contact contact);
    //r - read - get one object
    public Contact getContactById(int contactId);
    // - get all objects
    public List<Contact>getAllContactsByName(String nameToSearch);
    //u - update
    public void updateContact(Contact contact);
    // d - delete
    public void removeContact(int contactId);
    //search
    public List<Contact> searchContacts(Map<SearchTerm,String> criterial);

    public List<Contact> getAllContacts();
}
