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
            else{
            dequeue();
            enqueue(log);
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
        System.out.println("tail "+tail + ":" + head+" head oh also the dequeue function is working");
        array[0] = null;

    }

    public String peek() {

        //System.out.println(array[3].getProductName());
        
        System.out.println(Arrays.toString(array));
        queueSort(array);
        return Arrays.toString(array);
    }
    

    public static void queueSort(activityTracker queue[]) {
        boolean sorted = false;
        int increment = 0;
        activityTracker currentQauntity;
        while (sorted == false) {

            for (int i = 0; i < queue.length - 1; i++) {
                //stops any errors from encountering an empty slot 
                if (queue[i] == null) {
                    System.out.println("ignored");

                }

                if (queue[i].quantity > queue[i + 1].quantity) {
                    //the current index is stored for later
                    currentQauntity = queue[i];
                    //the index is swapped out for the one after it 
                    queue[i] = queue[i + 1];
                    //and the one after it contains the stored index
                    queue[i + 1] = currentQauntity;

                    //System.out.println(Arrays.toString(queue));

                }
            }
            increment++;
            if (increment == 2) {
                sorted = true;
            }

        }

    }

    public static void main(String[] args) {
        queue test = new queue();
        activityTracker thing = new activityTracker(0, "1", "wednesday", 2);
        activityTracker alternate = new activityTracker(0, "2", "wednesday", 3);
        activityTracker thing1 = new activityTracker(0, "3", "wednesday", 30);
                activityTracker thing12 = new activityTracker(0, "3", "wedfafdafdaffafdasfasdfdasfdsfdafadfdnesday", 30);
        activityTracker alternate1 = new activityTracker(0, "4", "wednesday", 90);

        test.enqueue(thing);
        test.enqueue(alternate);
        test.enqueue(thing1);
        test.enqueue(alternate1);       
                test.enqueue(thing12);
        test.enqueue(alternate1);   
        test.peek();
        queueSort(test.array);
        
    }
}
