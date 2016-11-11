/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class TaxDTO {


    String abbr;

    Double taxRate;

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public TaxDTO() {

    }

    public TaxDTO( Double taxRate, String abbr) {
       
        this.taxRate = taxRate;
        this.abbr = abbr;

    }


    public Double gettaxRate() {
        return taxRate;
    }

    
}
