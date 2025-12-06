/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs5003cw1.supermarket.models;

/**
 *
 * @author aba2059
 */
import java.util.Arrays;

public class queue {

    activityTracker[] array = new activityTracker[4];
    public int productID;
    int head = 3;
    int tail = 3;

    public void queue() {
        this.array = new activityTracker[4];
        this.head = head;
        this.tail = tail;
    }

    public void set_element(activityTracker item) {
        this.array[0] = item;

    }

    public activityTracker get_element() {
        return this.array[0];
    }

    public void enqueue(activityTracker log) {

        System.out.println("tail "+tail + ":" + head+" head");
            //replace 0 with null when using with objects
            if (array[tail] == null) {
                this.array[tail] = log;
                //this stops the tail index
                if (tail == 0) {
                    System.out.println("tail is 0");
                } 
                //increment the tail downwards 
                else {
                    tail--;
                }
            }
        }

    
    public void dequeue() {
 
        //goes down the list and assigns the current index with the index before it 
        for (int index = array.length - 1; index >= 0; index--) {
            if (index == 0) {
                break;
            }
            array[index] = array[index - 1];

        }
        //increments the tail up and makes sure the tail isnt higher than the head 
        tail++;
        if (tail == 4) {
            tail = 3;
        }
        System.out.println("tail "+tail + ":" + head+" head");
        array[0] = null;

    }

    public void peek() {

        System.out.println(array[3].getProductName());

    }

    public static void main(String[] args) {
        queue test = new queue();
        activityTracker thing = new activityTracker(0, "1", "wednesday", 5);
        activityTracker alternate = new activityTracker(0, "2", "wednesday", 5);
        activityTracker thing1 = new activityTracker(0, "3", "wednesday", 5);
        activityTracker alternate1 = new activityTracker(0, "4", "wednesday", 5);

        test.enqueue(thing);
        test.enqueue(alternate);
        test.enqueue(thing1);
        test.enqueue(alternate1);        
        test.dequeue();
               test.dequeue();
        test.peek();

    }
}
