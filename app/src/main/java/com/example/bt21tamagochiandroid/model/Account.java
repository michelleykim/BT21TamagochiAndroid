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
        if (tendency == 0) {
            bt21 = new Koya();
        } else if (tendency == 7) {
            bt21 = new Rj();
        } else if (tendency == 14) {
            bt21 = new Chimmy();
        } else if (tendency == 21) {
            bt21 = new Mang();
        } else if (tendency == 28) {
            bt21 = new Shooky();
        } else if (tendency == 35) {
            bt21 = new Tata();
        } else if (tendency == 42) {
            bt21 = new Cooky();
        }
    } // else if tendency == 2, then new Mang() etc..

    public String getName() {
        return name;
    }
    public Bt21 getBt21() {return bt21;}
    public int getTendency() {return tendency;}

    public void setTendency(int tendency) {
        this.tendency = tendency;
    }
}
