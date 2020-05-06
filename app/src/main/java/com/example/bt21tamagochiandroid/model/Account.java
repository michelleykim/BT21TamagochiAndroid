package com.example.bt21tamagochiandroid.model;

import com.example.bt21tamagochiandroid.model.bt21.Bt21;
import com.example.bt21tamagochiandroid.model.bt21.Chimmy;
import com.example.bt21tamagochiandroid.model.bt21.Cooky;
import com.example.bt21tamagochiandroid.model.bt21.Koya;
import com.example.bt21tamagochiandroid.model.bt21.Mang;
import com.example.bt21tamagochiandroid.model.bt21.Rj;
import com.example.bt21tamagochiandroid.model.bt21.Shooky;
import com.example.bt21tamagochiandroid.model.bt21.Tata;

public class Account {
    String name;
    int tendency;
    Bt21 bt21;

    public Account(String name) {
        this.name = name;
        tendency = 0;
    }

    public void determineTendency() {
        if (tendency == 5) {
            bt21 = new Koya();
        } else if (tendency == 8) {
            bt21 = new Tata();
        } else if (tendency == 6) {
            bt21 = new Mang();
        } else if (tendency == 7) {
            bt21 = new Chimmy();
        } else if (tendency == 10) {
            bt21 = new Cooky();
        } else if (tendency == 9) {
            bt21 = new Rj();
        } else if (tendency == 11) {
            bt21 = new Shooky();
        }
    }

    public void addTendency(int amount) {
        tendency = tendency + amount;
    }

    public String getName() {
        return name;
    }
    public Bt21 getBt21() {return bt21;}
    public int getTendency() {return tendency;}

    public void setTendency(int tendency) {
        this.tendency = tendency;
    }
}
