package com.mycompany.cs5003cw1.supermarket.models;

import com.mycompany.cs5003cw1.supermarket.models.SupermarketGUI;
/**
 * Write a description of class SupermarketSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class SupermarketSystem {

    //System stores all products in an ArrayList
    private ArrayList<Product> products;

    //Constructor - when system starts, creates an empty ArrayList
    public SupermarketSystem() {
        products = new ArrayList<>();

        //test products
        products.add(new Product(1, "Bread", "2025-11-27", 20));
        products.add(new Product(2, "Eggs", "2025-11-27", 30));
        products.add(new Product(3, "Milk", "2025-11-27", 15));
        products.add(new Product(4, "Beans", "2025-11-27", 40));
        products.add(new Product(5, "Chicken", "2025-11-27", 10));
    }

//Getter Method so GUI can access product list
    public ArrayList<Product> getProducts() {
        return products;
    }

//Method used by GUI to create new product
    public Product addProduct(String name, int qty) {
        //Assign id based on list size
        int newId;

        if (products.isEmpty()) {
            newId = 1;

        } else {
            int lastId = products.get(products.size() - 1).getProductID();
            newId = lastId + 1;
        }

        String today = java.time.LocalDate.now().toString();
        //auto entrydate

        //Creates new product object and stores in list
        Product p = new Product(newId, name, today, qty);

        //Add to list
        products.add(p);

        System.out.println("Product added: " + p.getProductName());
        return p;

    }

//Binary Search Method to delete by id
    public boolean deleteProductById(int id) {
        Product p = binarySearchProduct(id);
        
        if (p != null) {
            products.remove(p);
            return true;
        }
        
        return false;
    }

//Binary search - searches for product with productID
    public  Product binarySearchProduct(int id) {

        int left = 0;

        int right = products.size() - 1;

        while (left <= right) {

            int middle = (left + right) / 2;
            int middleID = products.get(middle).getProductID();

            if (middleID == id) {
                return products.get(middle); //product found

            } else if (middleID < id) {
                left = middle + 1; //searches right half
            } else {
                right = middle - 1; //searches left half
            }
        }

        return null; // product hasnt been found
    }
    
    //Add stock using binary search
    public boolean addToStock(int productId, int amount) {
        
        Product p = binarySearchProduct(productId);
        if (p == null) return false;
        
        p.setQuantity(p.getQuantity() + amount);
        
        //Create activity
        activityTracker a = new activityTracker(
        productId,
                "Add to stock",
                java.time.LocalDate.now().toString(),
                amount
        );
        
        p.queue.enqueue(a);
        return true;
    }
    
    //Remove stock using binary search
    public boolean removeFromStock(int productId, int amount) {
        
        Product p = binarySearchProduct(productId);
        if (p == null) return false;
        
        if (p.getQuantity() < amount) {
            return false;
        }
        
        p.setQuantity(p.getQuantity() - amount);
        
        activityTracker a = new activityTracker(
        productId, 
        "Remove from stock",
        java.time.LocalDate.now().toString(),
        amount
      );
        
        p.queue.enqueue(a);
        return true;
    }
    
    //written by aba2059
    public String findActivity(int productId){
    Product p = binarySearchProduct(productId);

        return activityView(p);
    }
    //retrieves activities
    public static String activityView(Product p){
    
        String result = p.queue.peek();
        System.out.println(result);
        return result;
    }
    
//Main method
    public static void main(String[] args) {
        SupermarketSystem system = new SupermarketSystem();
        new SupermarketGUI(system);
        
        // this the product 
        Product fake = new Product(1, "Bread", "2025-11-27", 20);
        //this is an activity 
        activityTracker temporary = new activityTracker(1, "remove from stock", "2025-11-27", 20);
        activityTracker temporary2 = new activityTracker(1, "remove from stock", "2025-11-27", 21);
        //this stores the activity in the queue of only the "fake" object
        fake.queue.enqueue(temporary);
        fake.queue.enqueue(temporary);
        fake.queue.enqueue(temporary);
        fake.queue.enqueue(temporary2);
        //shows the current head of the queue 
        //findActivity(1);
        
    }

}
