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
public class OrderDTO {

    private int order;
    private String name;
    private double area;
    private String state;
    private String productName;

    public TaxDTO getTax() {
        return tax;
    }

    public void setTax(TaxDTO tax) {
        this.tax = tax;
    }

    public ItemDTO getProduct() {
        return product;
    }
    
    public void setProduct(ItemDTO product) {
        this.product = product;
    }

    public void setProductName(String product) {
        this.productName = product;
    }
    private TaxDTO tax;
    private ItemDTO product;
    private double materialCost;
    private double laborCost;
    private double totalTax;
    private double calculateCost;

    public void setOrder(int order) {
        this.order = order;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getArea() {
        return area;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public double getTotalTax() {
        return totalTax;
    }
    private double total;
    private String date;

    public OrderDTO() {

    }

    public OrderDTO( double calculateCost, int order, double area, double materialCost, double laborCost,String name, String state,double totalTax, double total, String date) {
        this.order = order;
        this.name = name;
        this.totalTax = totalTax;
        this.total = total;
        this.date = date;
        this.area = area;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.calculateCost = calculateCost; 
        this.state = state;
        
   }

    
    public String getstate(){
        return state;
        
    }
    
    public void setstate(String state){
        this.state = state;
    }
    public double getcalculateCost(){
        return calculateCost;
    }
    public void setcalculateCost(double calculateCost){
        this.calculateCost = calculateCost;
    }
          
    
    public int getOrder() {
        return order;
    }

    public void setId(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
}
