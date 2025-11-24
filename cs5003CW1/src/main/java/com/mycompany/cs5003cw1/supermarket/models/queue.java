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
    int head = 0;
    int tail = 0;

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

    //data is pushed onto the array 
    public void enqueue(activityTracker log) {

        if (tail <= 4) {

            if (array[tail] == null) {
                this.array[tail] = log;
                

            } else if (array[tail] != null) {
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                    tail = i;
                }
                tail++;


            }

            //this.array[head] = log;
            System.out.println(tail);
        }
    }

    public void dequeue() {

        if (array[head] != null) {
                for (int i = 3; i < array.length - 1; i--) {
                    array[i] = array[i - 1];
                    tail = i;
                }}
            }
            //currently prints the entire array rather than an index of it 
    public void peek() {

        System.out.println(array[0].getProductName());
        System.out.println(array[1].getProductName());

    }

    public static void main(String[] args) {
        queue test = new queue();
        activityTracker thing = new activityTracker(0, "test", "wednesday", 5);
        activityTracker alternate = new activityTracker(0, "tet", "wednesday", 5);
        test.enqueue(thing);
        test.enqueue(alternate);
        test.enqueue(thing);
        //test.dequeue();
        test.peek();

    }
}
