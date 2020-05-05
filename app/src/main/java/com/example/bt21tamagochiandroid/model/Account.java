package com.example.bt21tamagochiandroid.model;

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
        } else if (tendency == 1) {
            bt21 = new Rj();
        } else if (tendency == 2) {
            bt21 = new Chimmy();
        } else if (tendency == 3) {
            bt21 = new Mang();
        } else if (tendency == 4) {
            bt21 = new Shooky();
        } else if (tendency == 5) {
            bt21 = new Tata();
        } else if (tendency == 6) {
            bt21 = new Cooky();
        }
    } // else if tendency == 2, then new Mang() etc..

    public String getName() {
        return name;
    }
    public Bt21 getBt21() {return bt21;}
}
