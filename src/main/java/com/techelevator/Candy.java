package com.techelevator;

public class Candy extends Product{
    public Candy(String slotLocation, String name, double price, String type, int quantity) {
        super(slotLocation, name, price, type, quantity);
    }

    @Override
    public String dispenseMessage() {
        return "Yummy Yummy, So Sweet!";
    }
}
