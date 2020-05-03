package com.example.bt21tamagochiandroid.model;

public class Satisfaction {
    int hunger;
    int sleepiness;
    int dirtiness;
    int love;

    public Satisfaction() {
        hunger = 60;
        sleepiness = 60;
        dirtiness = 60;
        love = 0;
    }

    public void feed() {
        // feed bt21, hunger decreases by 5 points
        hunger = hunger - 5;
    }

    public void takeBath() {
        // take bt21 a bath, dirtiness decreases by 5 points
        dirtiness = dirtiness - 5;
    }

    public void goSleep() {
        // bt21 goes sleep, sleepiness decreases by 5 points
        sleepiness = sleepiness - 5;
    }

    public int getHunger() {
        return hunger;
    }
    public int getSleepiness() {
        return sleepiness;
    }
    public int getDirtiness() {
        return dirtiness;
    }
    public int getLove() {
        return love;
    }
}
