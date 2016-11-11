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
public class ItemDTO {

    private String productType;
    private double costPerSquareFt;
private double laborCostPerSquareFt;

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setCostPerSquareFt(double costPerSquareFt) {
        this.costPerSquareFt = costPerSquareFt;
    }

    public void setLaborCostPerSquareFt(double laborCostPerSquareFt) {
        this.laborCostPerSquareFt = laborCostPerSquareFt;
    }

    public String getProductType() {
        return productType;
    }

    public double getCostPerSquareFt() {
        return costPerSquareFt;
    }

    public double getLaborCostPerSquareFt() {
        return laborCostPerSquareFt;
    }

    public ItemDTO() {

    }

    public ItemDTO(String productType, double costPerSquareFt, double laborCostPerSquareFt) {
        this.productType = productType;
        this.costPerSquareFt = costPerSquareFt;
        this.laborCostPerSquareFt = laborCostPerSquareFt;
    }

 

}