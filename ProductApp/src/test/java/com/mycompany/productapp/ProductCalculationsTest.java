package com.mycompany.productapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductCalculationsTest {

    // Unit Test 1: 15% of 3500 = 525
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(525.0, calc.GetVat(), 0.001);
    }

    // Unit Test 2: 3500 + 525 + 175 = 4200
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(4200.0, calc.GetTotal(), 0.001);
    }
}