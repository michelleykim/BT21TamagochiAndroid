package com.example.bt21tamagochiandroid.model.bt21;

import com.example.bt21tamagochiandroid.model.Satisfaction;

import java.util.ArrayList;

public class Bt21 {
    private Satisfaction satisfaction;
    private ArrayList<String> states;
    private String name;

    public Bt21() {
        satisfaction = new Satisfaction();
        states = new ArrayList<>();
        states.add("Happy");
        updateStates();
        name = "BT21";
    }

    public void updateStates() {
        states.clear();
        if (satisfaction.getHunger() >= 70
                || satisfaction.getDirtiness() >= 70
                || satisfaction.getSleepiness() >= 70) {
            if (satisfaction.getHunger() >= 70) {
                states.add("Hungry");
            }
            if (satisfaction.getDirtiness() >= 70) {
                states.add("Dirty");
            }
            if (satisfaction.getSleepiness() >= 70) {
                states.add("Sleepy");
            }
        } else {
            states.add("Happy");
        }
    }

    public Satisfaction getSatisfaction() {
        return satisfaction;
    }
    public ArrayList<String> getStates() {
        return states;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
