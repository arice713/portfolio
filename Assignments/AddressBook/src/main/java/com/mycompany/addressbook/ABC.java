/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook;

/**
 *
 * @author apprentice
 */
public class ABC {
  //  public void add()
  //  public void delete()
  //  public void search()
  //  public void listCount()      
   // public void displayMenu()
 //   public void edit()
    //public void listAll()
private ConsoleIO con = new consoleIO();

public void run(){
    boolean keepGoing = true;
    int displayMenu = 0;
    try{
        list.listAll();
        while(keepGoing){
            printMenu();
            displayMenu = con.readInt("What would you like to do?");
            
            switch (displayMenu){
                case 1:
                    con.print("List all contacts");
                    listAll();
                    break;
                case 2:
                    con.print("Add contact");
                    add();
                    break;
                case 3:
                    con.print("Search for contacts");
                            search();
                            break;
                case 4:
                    con.print("Remove contact");
                    delete();
                    break;
                case 5:
                    con.print("List number of contacts");
                    listCount();
                    break;
                case 6:
                    con.print("Edit contact");
                    edit();
                    break;
                case 7:
                    con.print("Chiao");
                    keepGoing = false;
                    break;
                default:
                    con.print("Opps, I didn't understand what you meant!");
                    
            }
        }
        con.print("Now exiting");
        
    }
}
    private void printMenu(){
        con.print("Menu");
        con.print("1 to create contact");
        con.print("2 to delete contact");
        con.print("3 to edit contact");
        con.print("4 list all contacts");
        con.print("5 List number of contacts");
        con.print("6 Edit contact");
        con.print("7 to exit");
        
    }
    private void listAllContacts(){
        String[] contacts = contact.getAllcontacts();
        for (int i = 0; i < contacts.length; i==){
           Contact currentContact = contact.getContact(contact[i]);
           con.print(contact[i] + ":" + currentContact.getFirstName() + ""+ currentContact.getlastName());
        }
    }
    private void searchContact(){
        String contact = con.readString("Please enter the name of the contact");
        Contact currentContact = contact.getContact(contact);
        if (currentContact !=null){
            con.print(currentContact.getFirstName());
            con.print(currentContact.getlastName());
            con.print("");
        }else{
            con.print("No Contact by that name"+ Contact);
        }
    }
    private void addContact(){
        String firstName = con.readString("Please enter the first name.");
        String lastName = con.readString("Please eneter the last name");
        String addressLine1 = con.readString("Please enter the street number and name.");
        String addressLine2 = con.readString("Please enter unit number");
        String city = con.readString("Please enter the City");
        String state = con.readString("Please enter the State");
        String zipcode = con.readString("Please enter the zipcode");
        String country = con.readString("Please enter the country");
        Contact currentContact = new Contact(contact);
        currentContact.setFirstName(firstName);
        currentContact.setLastName(lastName);
        currentContact.setAddressLine1(addressLine1);
        currentContact.setAddressLine2(addressLine2);
        currentContact.setCity(city);
        currentContact.setState(state);
        currentContact.setZipcode(zipcode);
        currentContact.setCountry(country);
        contact.addContact(contact, currentContact);
        con.readString("Contact has been added!");
    
    }
    private void deleteContact(){
        String contact = con.readString("Please enter in contact.");
        contact.deleteContact(contact);
        con.readString("Contact has been deleted!");
    }
    
}
       
    







