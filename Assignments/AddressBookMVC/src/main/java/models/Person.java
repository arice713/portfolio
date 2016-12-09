/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Person {
   
    public int personId;
    public String firstName;
    public String lastName;
    public String company;
    public String phone;
    public String email;

    /**
     * @return the personId
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 37 * hash + this.personId;
        hash = 37 * Objects.hashCode(this.firstName);
        hash = 37 * Objects.hashCode(this.lastName);
        hash = 37 * Objects.hashCode(this.company);
        hash = 37 * Objects.hashCode(this.phone);
        hash = 37 * Objects.hashCode(this.email);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Person other = (Person) obj;
        if (this.personId != other.personId){
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)){
            return false;
           
        }
        if (!Objects.equals(this.lastName, other.lastName)){
            return false;
        }
        if (!Objects.equals(this.company, other.company)){
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)){
            return false;
        }
        if (!Objects.equals(this.email, other.email)){
            return false;
        }
        return true;
    }
    
    
}
 