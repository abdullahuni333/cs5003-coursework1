package com.mycompany.cs5003cw1.supermarket.models;


import com.mycompany.cs5003cw1.supermarket.models.SupermarketGUI;


/**
 * Write a description of class SupermarketSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SupermarketSystem
{
public static void main (String[] args) {
    SupermarketSystem system = new SupermarketSystem();
    new SupermarketGUI(system);
    Product test = new Product(1,"coo","ble",3);
    activityTracker moretest = new activityTracker(1,"coo","ble",3);
    test.queue.enqueue(moretest);
    test.queue.peek();
    
}
}