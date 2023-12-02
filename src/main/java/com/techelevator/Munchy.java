package com.techelevator;

public class Munchy extends Product{
    public Munchy(String slotLocation, String name, double price, String type, int quantity) {
        super(slotLocation, name, price, type, quantity);
    }

    @Override
    public String dispenseMessage() {
        return "Crunch Crunch, Yum!";
    }
}
