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
    private JButton removeFromStock;
    private JButton addToStock;
    private JButton viewActivities;
    
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
    removeFromStock = new JButton("Remove From Stock");
    addToStock = new JButton("Add To Stock");
    viewActivities = new JButton("View Activities");
    
    setUpStockButtons();
    
    //Add existing products 
    for (Product p : system.getProducts()) {
        myList.addElement(p);
    }

    
    //Positioning
    addProduct.setBounds(30, 30, 180, 30);
    deleteProduct.setBounds(30, 70, 180, 30);
    listProduct.setBounds(30, 110, 180, 30);
    removeFromStock.setBounds(30, 150, 180, 30);
    addToStock.setBounds(30, 190, 180, 30);
    viewActivities.setBounds(30, 230, 180, 30);
    
    //Product list
    list.setBounds(50,320,300,180);
    frame.add(list);
    
    //Add to window
    frame.add(addProduct);
    frame.add(deleteProduct);
    frame.add(listProduct);
    frame.add(removeFromStock);
    frame.add(addToStock);
    frame.add(viewActivities);
    
    setUpButtonListeners();
    
    frame.setVisible(true);
}
    // actions for Stock buttons
    private void setUpStockButtons() {
        
        addToStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStockWindow("AddToStock");
            }
        });
        
        removeFromStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStockWindow("RemoveFromStock");
            }
        });
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
                openDeleteProductWindow();
            } 
        });
        
        //List Products
        listProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshProductList();
            }
        });
        
        addToStock.addActionListener(e -> openStockWindow("Add"));
        removeFromStock.addActionListener(e -> openStockWindow("Remove"));
        
    }
    
    //Open window for deleting product by ID
    private void openDeleteProductWindow() {
        JFrame deleteFrame = new JFrame("Delete Product");
        deleteFrame.setSize(300, 200);
        deleteFrame.setLayout(null);
        
        JLabel idLabel = new JLabel("Product ID");
        JTextField idField = new JTextField();
        JButton confirmButton = new JButton("Delete");
        
        idLabel.setBounds(30, 40, 100, 25);
        idField.setBounds(120, 40, 100, 25);
        confirmButton.setBounds(90, 90, 100, 30);
        
        deleteFrame.add(idLabel);
        deleteFrame.add(idField);
        deleteFrame.add(confirmButton);
        
        deleteFrame.setVisible(true);
        
        //Button logic
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                   int id = Integer.parseInt(idField.getText());
                
                    
                    boolean deleted = system.deleteProductById(id);
                    
                    if (deleted) {
                        JOptionPane.showMessageDialog(deleteFrame, "Product deleted.");
                        deleteFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(deleteFrame, "Product not found");
                        JOptionPane.showMessageDialog(deleteFrame, "Please enter a valid ID.");
                    }
                        
                    
                }
            });
        }
     
//Opens window to add stock for product
    private void openStockWindow(String type) {
        JFrame stockFrame = new JFrame(type);
        stockFrame.setSize(300, 200);
        stockFrame.setLayout(null);
        
        JLabel idLabel = new JLabel("Product ID");
        JLabel qtyLabel = new JLabel("Quantity");
        
        JTextField idField = new JTextField();
        JTextField qtyField = new JTextField();
        
        JButton confirmButton = new JButton(type);
        
        idField.setBounds(140, 30, 100, 25);
        idLabel.setBounds(30, 30, 100, 25);
        
        qtyField.setBounds(140, 70, 100, 25);
        qtyLabel.setBounds(30, 70, 100, 25);
        
        confirmButton.setBounds(90, 120, 120, 30);
        
        stockFrame.add(idField);
        stockFrame.add(idLabel);
        stockFrame.add(qtyField);
        stockFrame.add(qtyLabel);
        stockFrame.add(confirmButton);
        
        stockFrame.setVisible(true);
        
        confirmButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                int qty = Integer.parseInt(qtyField.getText());
                
                boolean success;
                
                if (type.equals("Add")) {
                    success = system.addToStock(id, qty);
                } else {
                    success = system.removeFromStock(id, qty);         
                }
                if (success) {
                    JOptionPane.showMessageDialog(stockFrame, "Stock updated");
                    stockFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(stockFrame, "Operation failed");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(stockFrame, "Enter valid numbers");
            }
        }
        
        );
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
   
    //Refresh list 
    private void refreshProductList() {
        myList.clear();
        for (Product p : system.getProducts()) {
            myList.addElement(p);
        }
    }
}
        
                
        
               
   

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

