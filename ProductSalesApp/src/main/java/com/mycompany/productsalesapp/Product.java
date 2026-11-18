/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapp;

/**
 *
 * @author LESEDI
 */
// Q1.2: Product does the calculations for the report
public class Product implements IProduct {

    // Single array: the product names
    private final String[] productNames;
    // 2D array: rows = products, columns = months
    private final int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    // Helper: adds up one product's sales across all months (stops duplicated loops)
    private int getProductTotal(int productIndex) {
        int total = 0;
        for (int month = 0; month < sales[productIndex].length; month++) {
            total += sales[productIndex][month];
        }
        return total;
    }

    // Total of every product in every month
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int product = 0; product < sales.length; product++) {
            total += getProductTotal(product);
        }
        return total;
    }

    // Average = total sales / number of entries (3 products x 3 months = 9)
    @Override
    public double GetAverageProductSold() {
        int entries = sales.length * sales[0].length;
        // Cast to double so we don't lose the decimal part
        return (double) GetTotalProductsSold() / entries;
    }

    // Finds the product with the highest total sales
    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        int bestTotal = getProductTotal(0);

        for (int product = 1; product < sales.length; product++) {
            int total = getProductTotal(product);
            if (total > bestTotal) {
                bestTotal = total;
                bestIndex = product;
            }
        }
        return productNames[bestIndex] + " (" + bestTotal + ")";
    }
}