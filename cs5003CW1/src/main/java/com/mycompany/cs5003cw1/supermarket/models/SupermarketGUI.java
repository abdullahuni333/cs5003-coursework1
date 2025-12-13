package com.mycompany.cs5003cw1.supermarket.models;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;



public class SupermarketGUI { 
    
    // Link to main system to call add/delete/list methods
    private SupermarketSystem system;
    
   
    
    //Container for window + menu buttons
    private JFrame frame;
    private JButton addProduct; 
    private JButton deleteProduct;
    private JButton listProduct;
    
    //Components for pop-up window
    private JPanel panel;
    private JLabel label;
    private JTextField textfield;
    private JButton button;
    
    //List to display products
    private DefaultListModel<Product> myList = new DefaultListModel<>();
    private JList<Product> list = new JList<>(myList);

    
    public SupermarketGUI(SupermarketSystem system) {
        this.system = system;
        
    //Main window
    frame = new JFrame("Supermarket System");
    frame.setSize(500,500);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    //Button creation
    addProduct = new JButton("Add Product");
    deleteProduct = new JButton("Delete Product");
    listProduct = new JButton("List Products");
    
    //Add existing products 
    for (Product p : system.getProducts()) {
        myList.addElement(p);
    }
    
    //Positioning
    addProduct.setBounds(50, 50, 150, 30);
    deleteProduct.setBounds(50, 100, 150, 30);
    listProduct.setBounds(50, 150, 150, 30);
    
    //Product list
    list.setBounds(50,220,300,150);
    frame.add(list);
    
    //Add to window
    frame.add(addProduct);
    frame.add(deleteProduct);
    frame.add(listProduct);
    
    setUpButtonListeners();
    
    frame.setVisible(true);
}
    
    // connect buttons to actions
    public void setUpButtonListeners() {
        //When 'Add Product' is clicked
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddProductWindow();
            }
        });
    
        //Delete product when clicked
        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedProduct();
            } 
        });
        
        //List Products
        listProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshProductList();
            }
        });
    }


    
//When user clicks "Add Product"

//New window for adding product
private void openAddProductWindow() {
    
JFrame addFrame = new JFrame("New Product");
addFrame.setSize(300, 200);
addFrame.setLayout(null);
    

JLabel nameLabel = new JLabel("Product Name");
JLabel qtyLabel = new JLabel("Quantity");
        
JTextField nameField = new JTextField();
JTextField qtyField = new JTextField();
        
JButton saveButton = new JButton("Save");
        
        
//Positioning
nameLabel.setBounds(30, 30, 100, 25);
qtyLabel.setBounds(30, 60, 100, 25);
        
nameField.setBounds(120, 30, 120, 25);
qtyField.setBounds(120, 70, 120, 25);
        
saveButton.setBounds(100, 110, 80, 30);
        
//Add components 
addFrame.add(nameLabel);
addFrame.add(qtyLabel);
addFrame.add(nameField);
addFrame.add(qtyField);
addFrame.add(saveButton);
        
addFrame.setVisible(true);
        
//Save button action
saveButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
            
        String name = nameField.getText();
        String qtyText = qtyField.getText();
        
        if (name.isEmpty() || qtyText.isEmpty()) {
            JOptionPane.showMessageDialog(addFrame, "Please fill all fields");
            return;
        }
       
        int qty = Integer.parseInt(qtyText);
        
        //Add to system
        Product newP = system.addProduct(name,qty);
        
        //Add to GUI list
        myList.addElement(newP);
        
        JOptionPane.showMessageDialog(addFrame, "Product added!");
        addFrame.dispose(); // close window 
      }
     });
   }

   //delete button action
   private void deleteSelectedProduct() {
      
       //Ask for productID
       String input = JOptionPane.showInputDialog(
       frame,
               "Enter Product ID to delete:"
       );
       
       if (input == null) {
           return;
       }
       
       int id;
       
       try {
           id = Integer.parseInt(input);
       } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(frame, "Invalid ID");
           return;
       }
       
       //Ask system to search/delete product
       boolean deleted = system.deleteProduct(id);
       
       if (deleted) {
           JOptionPane.showMessageDialog(frame, "Product successfully deleted.");
           refreshProductList();
       } else {
           JOptionPane.showMessageDialog(frame, "Product not found.");
       }
    }
   
    //Refresh list 
    private void refreshProductList() {
        myList.clear();
        for (Product p : system.getProducts()) {
            myList.addElement(p);
        }
    }
   
}
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

