/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs5003cw1.supermarket.models;

/**
 *
 * @author aba2059
 */
public class activityTracker extends Product {

    static boolean getQuantity;


    
    public activityTracker(int productID, String productName, String entryDate, int quantity){
        // inherits all the attributes of the product class to use it 
        super(productID,productName,entryDate,quantity);

    
    }

}
