/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs5003cw1.supermarket.models;

/**
 *
 * @author nadiaabdullahi  
 */
public class Product {
    public int productID;
    public String productName;
    public String entryDate;
    public int quantity;
    public queue queue;
    
    public Product(int ID, String aName, String aDate, int aQuantity){
        productID = ID;
        productName = aName;
        entryDate = aDate;
        quantity = aQuantity;    
        queue = new queue();
    }
    
    public int getProductID() {
        return productID;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public String getEntryDate() {
        return entryDate;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setProductName (String aName) {
        productName = aName;
    }
    
    public void setQuantity (int aQuantity) {
        quantity = aQuantity;
    }
    
    public void setProductID (int ID) {
        productID = ID;
    }
    
    public void setEntryDate (String aDate) {
        entryDate = aDate;
    }
    
    
            @Override
    public String toString() {
        return "ID: " + productID +
                " | Name: " + productName +
                " | Qty: " + quantity +
                " | Date: " + entryDate;
    }
    
    
    
    
    public void setqueue (String alist) {
        entryDate = alist;
    }
    
}




    

