/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs5003cw1.supermarket.models;

/**
 *
 * @author agant
 */
import java.util.Arrays;
public class queue {
    activityTracker[] array ={null,null,null,null}; 
    int head =-1;
    int tail =-1;
    
    public void queue(){
        this.array = new activityTracker[4];
        this.head = head;
        this.tail = tail;
    }
    public void set_element(activityTracker item){
        this.array[0] = item;
    
    }
    public activityTracker get_element(){
        return this.array[0];
    }
    
    public void enqueue(activityTracker log){
        if(array == null){
        System.out.println("raaaaaaaa");
        }
        this.array[++head] = log;
    
    }
    public void peek(){
    
        System.out.println(Arrays.deepToString(array));
    
    }
   // yrdy dydlkyjsldfkjgklfsdjlgksjdklgjsadasfafdasadsfafasf
    public static void main(String[] args) {
     queue test = new queue();
     activityTracker thing = new activityTracker(0,"test","wednesday",5);
     test.enqueue(thing);
     test.enqueue(thing);
     test.peek();
    
    
    }
}
