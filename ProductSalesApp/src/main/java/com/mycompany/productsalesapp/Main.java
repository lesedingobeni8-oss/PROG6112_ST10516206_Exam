/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapp;

/**
 *
 * @author LESEDI
 */

import java.util.Scanner;

// Q1.1: reads the sales, then builds and prints the report
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Single array for the names
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        final int MONTHS = 3;

        // 2D array: [product][month]
        int[][] sales = new int[productNames.length][MONTHS];

        // Outer loop = product, inner loop = month
        for (int product = 0; product < productNames.length; product++) {
            for (int month = 0; month < MONTHS; month++) {
                System.out.print("Enter number of sales for month " + (month + 1)
                        + " for " + productNames[product] + " mattress: ");
                sales[product][month] = input.nextInt();
            }
            System.out.println(); // blank line between products
        }

        Product products = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct(products);

        printer.printHeader();
        printer.printTotalSales();
        printer.printAverageSales();
        printer.printMostPopularProduct();
    }
}