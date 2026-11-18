/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.productapp;

/**
 *
 * @author LESEDI
 */
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

// Q2.1 - Q2.4: the GUI. The class IS the window (extends JFrame)
public class ProductApp extends JFrame {

    // Components are fields so every method can use them
    private final JTextField nameField = new JTextField();
    private final JComboBox<String> productCombo = new JComboBox<>(new String[]{
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});  // Q2.2
    private final JTextField priceField = new JTextField();
    private final JButton processButton = new JButton("PROCESS");

    public ProductApp() {
        setTitle("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 280);
        setLocationRelativeTo(null);   // centre on screen

        createMenu();
        createForm();
    }

    // Q2.4: File -> Exit, Tools -> Process / Clear
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));   // closes the app
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processSale());  // SAME logic as the button
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    // Q2.2: labels, text boxes, combo box and button in a simple grid
    private void createForm() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Customer Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Select Product:"));
        panel.add(productCombo);
        panel.add(new JLabel("Enter Price:"));
        panel.add(priceField);
        panel.add(new JLabel());   // empty cell so the button sits under the text boxes
        panel.add(processButton);

        processButton.addActionListener(e -> processSale());   // SAME logic as the menu

        add(panel);
    }

    // Q2.3: the ONE place the process logic lives (button and menu both call it)
    private void processSale() {
        String customer = nameField.getText().trim();
        String product = (String) productCombo.getSelectedItem();

        // Validation: name must not be empty
        if (customer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.",
                    "Input error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validation: price must be a positive number
        double price;
        try {
            price = Double.parseDouble(priceField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the price.",
                    "Input error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (price <= 0) {
            JOptionPane.showMessageDialog(this, "The price must be greater than 0.",
                    "Input error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Use the calculations class (no maths in the GUI)
        ProductCalculations calc = new ProductCalculations(price);

        // Build the text once and use it for both the dialog and the file
        String details = "Customer Name: " + customer + "\n"
                + "Product: " + product + "\n"
                + "VAT: R " + calc.GetVat() + "\n"
                + "COMMISSION: R " + calc.GetCommission() + "\n"
                + "TOTAL: R " + calc.GetTotal();

        JOptionPane.showMessageDialog(this, details, "Message",
                JOptionPane.INFORMATION_MESSAGE);

        saveToFile(details);
    }

    // Q2.3: saves the sale to data.txt in the DATA LOG format
    private void saveToFile(String details) {
        // try-with-resources closes the file automatically; true = append, so old sales are kept
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("*".repeat(40));
            writer.println(details);
            writer.println("*".repeat(40));
            writer.println();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save to data.txt.",
                    "File error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Q2.4: Clear menu item
    private void clearForm() {
        nameField.setText("");
        priceField.setText("");
        productCombo.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        // Swing windows should be created on the Swing thread
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}