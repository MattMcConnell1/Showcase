package com.techelevator;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private static List<Product> products;
    private double currentBalance;
    private double discount;

    private int discountCounter;

    public int getDiscountCounter() {
        return discountCounter;
    }

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
            System.out.println("Slot#: " + product.getSlotLocation() + " Name: " + product.getName()+ " Price: " + product.getPrice()+
                    " Type: " + product.getType() + " Remaining Quantity: " + product.getQuantity());
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

    public void selectProduct (Scanner scanner) {
        displayProduct();

        System.out.println("Enter the slot code to select a product: ");
        String slotCode = scanner.next().toUpperCase();

        Product selectedProduct = findProductBySlotCode(slotCode);

        if (selectedProduct != null && selectedProduct.getQuantity() > 0){
            currentBalance -= selectedProduct.getPrice();
            System.out.printf("Dispensed: %s. Remaining Balance: $%.2f%n", selectedProduct.getName(), currentBalance);
            selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);
            System.out.println("Remaining quantity : " + selectedProduct.getQuantity());

        } else if (selectedProduct.getQuantity() == 0) {
            System.out.println("Sorry, this items is SOLD OUT. Please choose another product.");
        } else  if(currentBalance < selectedProduct.getPrice()){
            System.out.println("Insufficient funds. Please feed more money.");
        } else {
            System.out.println("Invalid product selection. Try Again!");
        }
//        double discountPrice = dispenseDiscountProduct(selectedProduct.getPrice());
//        if (currentBalance >= discountPrice){
//            dispenseProduct(selectedProduct,discountPrice);
//        }
//
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
        
        discount += 1.00;
    }

    private double dispenseDiscountProduct(double normalPrice) {
        if (discount > 0) {
            discount = 0;
            return normalPrice - 1.00;
        } else {
            return normalPrice;
        }
    }
}
