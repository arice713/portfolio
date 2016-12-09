/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlist.mvc.controller;

import com.sg.contactlist.mvc.dao.ContactListDAO;
import com.sg.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */

@Controller
public class HomeControllerNoAjax {
    
    //Dao need one 
    private ContactListDAO dao;
   
    @Inject
    public HomeControllerNoAjax(ContactListDAO dao){
    this.dao =dao;
    }
    // display new contact form to be used when adding a contact
    @RequestMapping(value="displaynecontactformnoajax", method=RequestMethod.GET)
    public String dsplayNewContactFormNoAjax(){
        return"newcontactformnoajax";
    }
           
    // Add a new contact
    @RequestMapping(value="/addNewContactNoAjax",method=RequestMethod.GET)
    public String addNewContactNoAjax(HttpServletRequest req){
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String company = req.getParameter("company");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        
        Contact contactToAdd = new Contact();
        contactToAdd.setFirstName(firstName);
        contactToAdd.setLastName(lastName);
        contactToAdd.setCompany(company);
        contactToAdd.setPhone(phone);
        contactToAdd.setEmail(email);
        
        dao.addContact(contactToAdd);
                return"redirect:displayContactListNoAjax";
    }
    
    // display edit
    @RequestMapping(value="/diplayEditContactNoAjax", method=RequestMethod.GET)
    public String displayEditContactFormNoAjax(HttpServletRequest req, Model model){
        int contactId = Integer.parseInt(req.getParameter("contactid"));
        Contact contactToEdit = dao.getContactById(contactId);
        model.addAttribute("contact", contactToEdit);
        return "editContactFormNoAjax";
    }
    //edit contact
    @RequestMapping(value="editContactNoAjax", method=RequestMethod.POST)
    public String editContactNoAjax(@ModelAttribute("contact")Contact contact){
        dao.updateContact(contact);
        return"redirect:displayContactListNoAjax";
    }
           
    
    //delete contact
    @RequestMapping(value="/deleteContactNoAjax",method=RequestMethod.GET)
    public String deleteContactNoAjax(HttpServletRequest req){
        int contactId = Integer.parseInt(req.getParameter("ContactId"));
        dao.removeContact(contactId);
        return"redirect:displayContactListNoAjax";
    }
    // display contacts
    @RequestMapping(value="/displayContactListNoAjax", method=RequestMethod.GET)
    public String displayContactListNoAjax(Model model){
        List<Contact>allContacts = dao.getAllContacts();
        model.addAttribute("contactList",allContacts);
        return"displayContactListNoAjax";
    }
    
    
}
