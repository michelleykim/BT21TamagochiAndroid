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
        if (hunger > 5) {
            hunger = hunger - 5;
        } else {
            hunger = 0;
        }
    }

    public void takeBath() {
        // take bt21 a bath, dirtiness decreases by 5 points
        if (dirtiness > 5) {
            dirtiness = dirtiness - 5;
        } else {
            dirtiness = 0;
        }
    }

    public void goSleep() {
        // bt21 goes sleep, sleepiness decreases by 5 points
        if (sleepiness > 5) {
            sleepiness = sleepiness - 5;
        } else {
            sleepiness = 0;
        }
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
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public void setSleepiness(int sleepiness) {
        this.sleepiness = sleepiness;
    }
    public void setDirtiness(int dirtiness) {
        this.dirtiness = dirtiness;
    }
    public void setLove(int love) {
        this.love = love;
    }
    public void addHunger(int amount) {
        if (hunger < amount && amount < 0) {
            hunger = 0;
        } else {
            hunger = hunger + amount;
        }
    }
    public void addDirtiness(int amount) {
        if (dirtiness < amount && amount < 0) {
            dirtiness = 0;
        } else {
            dirtiness = dirtiness + amount;
        }
    }
    public void addSleepiness(int amount) {
        if (sleepiness < amount && amount < 0) {
            sleepiness = 0;
        } else {
            sleepiness = sleepiness + amount;
        }
    }
    public void addLove(int amount) {
        if (love < amount && amount < 0) {
            love = 0;
        } else {
            love = love + amount;
        }
    }
}
