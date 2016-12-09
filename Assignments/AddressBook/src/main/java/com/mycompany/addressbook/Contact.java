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
class Contact {
    
    String firstName;
    String lastName;
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String zipcode;
    String country;
    
    public String getFirstName()
    {
        return firstName;
        
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String  getlastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
            
    public String getaddressLine1()
    {
        return addressLine1;
    }
    
    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }
   public String getaddressLine2()
   {
       return addressLine2;
   }
   public void setAddressLine2(String addessLine2)
   {
       this.addressLine2 = addressLine2;
   }
   
   public String getcity()
   {
       return city;
   }
   public void setCity(String city)
   {
       this.city = city;
   }
    
   public String getstate()
   {
       return state;
   } 
   public void setState(String state)
   {
       this.state = state;
   }
    public String getzipcode()
    {
        return zipcode;
    }
    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }
    public String getcountry()
    {
        return country;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }
}

    

