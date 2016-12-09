/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.reflect.Array.set;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
class AddressBook {
     
     
     public static final String CONTACT_FILE = "contact.txt";
     
     public static final String DELIMITER = "::";
     
     public void loadContact() throws FileNotFoundException{
        
         Scanner sc = new Scanner (new BufferedReader(new FileReader(CONTACT_FILE)));
         
         String currentLine;
         String[] currentTokens;
         
         while(sc.hasNextLine()){
         currentLine = sc.nextLine();
         currentTokens = currentLine.split(DELIMITER);
     private final HashMap<String,Contact>contacts= new HashMap<>();
         Contact currentContact = new Contact(currentContact[0]);
         
         currentContact.setFirstName(currentTokens[1]);
         currentContact.setLastName(currentTokens[2]);
         currentContact.setAddressLine1(currentTokens[3]);
         currentContact.setAddressLine2(currentTokens[4]);
         currentContact.setCity(currentTokens[5]);
         currentContact.setState(currentTokens[6]);
         currentContact.setZipcode(currentTokens[7]);
         currentContact.setCountry(currentTokens[8]);
         
         
         contact.put(currentContact. getContactAddress(), currentContact);
        }
         sc.close();
     }
     public void writeContact() throws IOException{
        
         PrintWriter out = new Printwriter(new FileWriter(CONTACT_FILE));
         
         String[] keys = this.getALLContactAddress();
         
         for (int i=0; i <keys.length; i++){
             Contact currentContact = this.getContact(keys[i]);
             System.out.println(currentContact.getFirstName() + DELMITER + 
                     currentContact.getLastName() + DELMITER + 
                     currentContact.getAddressLine1() + DELMITER + 
                     currentContact.getAddressLine2() + DELMITER + 
                     currentContact.getCity() + DELMITER + 
                     currentContact.getState() + DELMITER + 
                     currentContact.getZipcode() + DELIMITER +
                     currentContact.getCountry();
             out.flush();
             
         }
         out.close();
         
         
     }
     
     public Contact getContact(String contactAddress){
         return contacts.get(contactAddress);
     }
     
     public Contact addContact(String contactAddress, Contact contact){
         return contact.put(contactAddress, contact);
     }
     
     public Contact deleteContact(String contactAddress){
         return.contact.delete(contactAddress);
     
}
     public String [] getallContacts(){
         set<String> keySet = contacts.keySet();
        
         String[] keyArray = new String[KeySet.size()];
         keyArray = keyset.toArray(keyArry);
         return keyArray;
     }
}
