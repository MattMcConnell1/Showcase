package com.techelevator;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private static List<Product> products;
    private double currentBalance;
    private double discount;

    public VendingMachine(List<Product> products) {
        this.products = products;
        this.currentBalance = 0.00;
        this.discount = 0.00;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getDiscount() {
        return discount;
    }

    public static void  displayMain(){
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
    }

    public void displayOption(){
        System.out.println("Current Money Provide:" + getCurrentBalance());
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select product");
        System.out.println("(3) Finish Transaction");
    }

    public void displayProduct(){
        System.out.println("Items list: ");
        for(Product product: products){
            System.out.println("Slot#: " + product.getSlotLocation() + " " + product.getName()+" " + product.getPrice()+
                    " " + product.getType() + " " + product.getQuantity());
        }
    }

    public void feedMoney(Scanner scanner){
        System.out.println("Enter amount to feed (Whole dollar only): ");
        int amount  = scanner.nextInt();
        currentBalance += amount;
//        System.out.println("Current Money Provided: " + currentBalance);
    }
    public void completeTransaction(){
        returnChange();
        currentBalance = 0.00;
        System.out.println("Transaction finished. Returning to main menu.");
    }
    private void returnChange(){
        int remainingBalance = (int) (currentBalance * 100);
        int quarters = remainingBalance / 25;
        remainingBalance %= 25;
        int dimes = remainingBalance / 10;
        remainingBalance %= 10;
        int nickels = remainingBalance /5;

        System.out.println("Returning change : " + quarters + " quarter " + dimes+ " dimes " + nickels + " nickels");

    }

    public void selectedProduct (Scanner scanner) {
        displayProduct();

        System.out.println("Enter the slot code to select a product: ");
        String slotCode = scanner.next().toUpperCase();

        Product selectedProduct = findProductBySlotCode(slotCode);

        if (selectedProduct == null){
            System.out.println("Invalid product code. Please try again.");
        } else if (selectedProduct.getQuantity() == 0){
            System.out.println("Sorry, this items is SOLD OUT. Please choose another product.");
        } else if (currentBalance < selectedProduct.getPrice()){
            System.out.println("Insufficient funds. Please feed more money.");
        } else {
            dispenseProduct(selectedProduct);
            currentBalance -= selectedProduct.getPrice();
            System.out.printf("Dispensed: %s. Remaining Balance: $%.2f%n", selectedProduct.getName(), currentBalance);
        }
    }

    private Product findProductBySlotCode(String slotCode){
        for (Product product : products){
            if (product.getSlotLocation().equalsIgnoreCase(slotCode)){
                return product;
            }
        }
        return null;
    }

    private void dispenseProduct(Product product){
        System.out.println("Dispensing: " + product.getName());
        product.decreaseQuantity();
    }
}
