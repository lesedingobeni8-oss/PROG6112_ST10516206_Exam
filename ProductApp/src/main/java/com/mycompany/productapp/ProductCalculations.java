/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productapp;

/**
 *
 * @author LESEDI
 */

// Q2.5: does all the calculations, separate from the GUI
public class ProductCalculations implements IProductCalculations {

    // Constants stop "magic numbers" and make the rates easy to change
    private static final double VAT_RATE = 0.15;         // 15%
    private static final double COMMISSION_RATE = 0.05;  // 5%

    private final double price;

    // The interface methods take no parameters, so the price comes in here
    public ProductCalculations(double price) {
        this.price = price;
    }

    // VAT = 15% of the product price
    @Override
    public double GetVat() {
        return price * VAT_RATE;
    }

    // Commission = 5% of the product price
    @Override
    public double GetCommission() {
        return price * COMMISSION_RATE;
    }

    // Total = price + VAT + commission
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}