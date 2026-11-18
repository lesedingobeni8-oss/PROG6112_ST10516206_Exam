/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapp;
import java.text.DecimalFormat;

/**
 *
 * @author LESEDI
 */


// Q1.3: only responsible for PRINTING the report
public class PrintProduct {

    private final IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    public void printHeader() {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("*".repeat(50));
    }

    public void printTotalSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageSales() {
        // "#.##" shows 17 instead of 17.0, but keeps decimals like 17.33
        DecimalFormat format = new DecimalFormat("#.##");
        System.out.println("AVERAGE PRODUCT SALES: " + format.format(product.GetAverageProductSold()));
    }

    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}