/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.productsalesapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Q1.4: Unit tests for the Product class
 */
public class ProductTest {

    // Same data as the sample screenshot
    private final String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private final int[][] sales = {
        {25, 18, 20},   // Cozy Nights Monarch
        {15, 10, 12},   // Restonic Barbados
        {18, 15, 20}    // Sealy Phuket
    };

    // Unit Test 1: total of all sales (25+18+20+15+10+12+18+15+20 = 153)
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        assertEquals(153, product.GetTotalProductsSold());
    }

    // Unit Test 2: average of all entries (153 / 9 = 17)
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        // The third value (0.001) is the allowed difference for decimal numbers
        assertEquals(17.0, product.GetAverageProductSold(), 0.001);
    }
}