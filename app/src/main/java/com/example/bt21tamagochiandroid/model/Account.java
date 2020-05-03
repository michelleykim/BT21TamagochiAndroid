package com.example.bt21tamagochiandroid.model;

public class Account {
    String name;
    int tendency;
    Koya koya;

    public Account(String name) {
        this.name = name;
        tendency = 0;
    }

    public void determineTendency() {
        if (tendency == 1) {
            koya = new Koya();
        } // else if tendency == 2, then new Mang() etc..
    }

    public String getName() {
        return name;
    }
    public Koya getKoya() {return koya;}
}
