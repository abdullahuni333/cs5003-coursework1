package com.mycompany.cs5003cw1.supermarket.models;

import javax.swing.JFrame;
import javax.swing.JButton;


public class SupermarketGUI {
    //Attributes
    private SupermarketSystem system;
    
    private JFrame frame;
    private JButton addProduct; 
    private JButton deleteProduct;
    private JButton listProduct;
    
    //Constructor
    public SupermarketGUI(SupermarketSystem system) {
        this.system = system;
        
    //Basic window settings
    frame = new JFrame("Supermarket System");
    frame.setSize(500,500);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Button creation
    addProduct = new JButton("Add Product");
    deleteProduct = new JButton("Delete Product");
    listProduct = new JButton("List Products");
    
    //Positioning
    addProduct.setBounds(50, 50, 150, 30);
    deleteProduct.setBounds(50, 100, 150, 30);
    listProduct.setBounds(50, 150, 150, 30);
    
    //Adding buttons
    frame.add(addProduct);
    frame.add(deleteProduct);
    frame.add(listProduct);
    
    //Make visible
    frame.setVisible(true);
    
    
    
    
    
    
    
    
    
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

