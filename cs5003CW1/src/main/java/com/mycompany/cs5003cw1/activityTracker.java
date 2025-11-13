/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs5003cw1;

/**
 *
 * @author aba2059
 */
public class activityTracker {

    int activityID;
    String activityName;
    int activityQauntity;
    String activityDate;

    void set_ID(int ID) {
        activityID = ID;
    }

    int get_ID() {
        return activityID;
    }

    void set_name(String name) {
        activityName = name;
    }

    String get_name() {
        return activityName;
    }

    void set_Qauntity(int Qauntity) {
        activityQauntity = Qauntity;
    }

    int get_Qauntity() {
        return activityQauntity;
    }

    void set_date(String date) {
        activityDate = date;
    }

    String get_date() {
        return activityDate;
    }
}
