package com.example.bt21tamagochiandroid.model;

public class Koya {
    private Satisfaction satisfaction;
    private State state;

    public enum State {
        HAPPY, HUNGRY, DIRTY, SLEEPY
    }

    public Koya() {
        satisfaction = new Satisfaction();
        state = State.HAPPY;
    }

    public Satisfaction getSatisfaction() {
        return satisfaction;
    }

    public State getState() {
        return state;
    }
}
