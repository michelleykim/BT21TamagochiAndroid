package com.example.bt21tamagochiandroid.model;

import java.util.ArrayList;

public class Koya {
    private Satisfaction satisfaction;
    private ArrayList<String> states;

    public enum State {
        HAPPY, HUNGRY, DIRTY, SLEEPY
    }

    public Koya() {
        satisfaction = new Satisfaction();
        states = new ArrayList<>();
        updateStates();
    }

    public void updateStates() {
        if (satisfaction.getHunger() > 70
                || satisfaction.getDirtiness() > 70
                || satisfaction.getSleepiness() > 70) {
            if (satisfaction.getHunger() > 70) {
                states.add("Hungry");
            }
            if (satisfaction.getDirtiness() > 70) {
                states.add("Dirty");
            }
            if (satisfaction.getSleepiness() > 70) {
                states.add("Dirty");
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
}
