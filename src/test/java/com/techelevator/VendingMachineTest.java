package com.techelevator;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    public VendingMachine vendingMachine;
    public Product product;
    @Before
    public void setup(){

        vendingMachine = new VendingMachine();
        product = new Product();
    }


    @Test
    public void itemReturnsCorrect(){

        Product chippos = new Product("A4", "Chippos", 3.85, "Munchy", 5);
        Product moonpie = new Product("C3","Moonpie",2.95,"Candy", 5);
        Product wonkaBar = new Product("B4","Wonka Bar",2.35,"Candy", 5);

        String expected = "Chippos";
        String actual = chippos.getName();
        assertEquals(expected,actual);

        String expected1 = "Moonpie";
        String actual1 = moonpie.getName();
        assertEquals(expected1, actual1);

        String expected2 = "Wonka Bar";
        String actual2 = wonkaBar.getName();
        assertEquals(expected2, actual2);


    }

    @Test
    public void slotRerturnsCorrect(){

        Product chippos = new Product("A4", "Chippos", 3.85, "Munchy", 5);
        Product moonpie = new Product("C3","Moonpie",2.95,"Candy", 5);
        Product wonkaBar = new Product("B4","Wonka Bar",2.35,"Candy", 5);

        String expected = "A4";
        String actual = chippos.getSlotLocation();
        assertEquals(expected, actual);

        String expected1 = "C3";
        String actual1 = moonpie.getSlotLocation();
        assertEquals(expected1, actual1);

        String expected2 = "B4";
        String actual2 = wonkaBar.getSlotLocation();
        assertEquals(expected2, actual2);

    }


    @Test
    public void priceReturnsCorrect(){

        Product chippos = new Product("A4", "Chippos", 3.85, "Munchy", 5);
        Product moonpie = new Product("C3","Moonpie",2.95,"Candy", 5);
        Product wonkaBar = new Product("B4","Wonka Bar",2.35,"Candy", 5);

        double expected = 3.85;
        double actual = chippos.getPrice();
        assertEquals(expected, actual, 0.000001);

        double expected1 = 2.95;
        double actual1 = moonpie.getPrice();
        assertEquals(expected1, actual1, 0.00001);

        double expected2 = 2.35;
        double actual2 = wonkaBar.getPrice();
        assertEquals(expected2, actual2, 0.000001);
    }


    @Test
    public void typeReturnsCorrect(){

        Product chippos = new Product("A4", "Chippos", 3.85, "Munchy", 5);
        Product moonpie = new Product("C3","Moonpie",2.95,"Candy", 5);
        Product wonkaBar = new Product("B4","Wonka Bar",2.35,"Candy", 5);

        String expected = "Munchy";
        String actual = chippos.getType();
        assertEquals(expected, actual);

        String expected1 = "Candy";
        String actual1 = moonpie.getType();
        assertEquals(expected1, actual1);

        String expected2 = "Candy";
        String actual2 = wonkaBar.getType();
        assertEquals(expected2, actual2);

    }

    @Test
    public void quantityReturnsCorrect(){

        Product chippos = new Product("A4", "Chippos", 3.85, "Munchy", 5);
        Product moonpie = new Product("C3","Moonpie",2.95,"Candy", 5);
        Product wonkaBar = new Product("B4","Wonka Bar",2.35,"Candy", 5);

        int expected = 5;
        int actual = chippos.getQuantity();
        assertEquals(expected, actual);

        int expected1 = 5;
        int actual1 = moonpie.getQuantity();
        assertEquals(expected1, actual1);

        int expected2 = 5;
        int actual2 = wonkaBar.getQuantity();
        assertEquals(expected2, actual2);

    }
}
