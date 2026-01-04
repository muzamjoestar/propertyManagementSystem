/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: PropertyManager.java
// Make sure this matches your package name (e.g., package propertymanagementsystem;)
import java.io.*;
import java.util.Scanner;

public class propertyManagerMachine {
    
    // --- PROPERTY STORAGE ---
    private Property[] properties = new Property[100]; 
    private int propertyCount = 0;

    // --- TENANT STORAGE (NEW) ---
    private Tenant[] tenants = new Tenant[100]; // <--- NEW ARRAY
    private int tenantCount = 0;                // <--- NEW COUNTER

    // --- METHODS ---

    public void addProperty(Property p) {
        if (propertyCount < properties.length) {
            properties[propertyCount] = p;
            propertyCount++;
            System.out.println("[Success] Property Added.");
        } else {
            System.out.println("[Error] Property List Full.");
        }
    }

    // NEW: Method to Add Tenant
    public void addTenant(Tenant t) {
        if (tenantCount < tenants.length) {
            tenants[tenantCount] = t;
            tenantCount++;
            System.out.println("[Success] Tenant Added.");
        } else {
            System.out.println("[Error] Tenant List Full.");
        }
    }

    public void displayAll() {
        // 1. Display Properties
        System.out.println("\n--- LIST OF PROPERTIES ---");
        if (propertyCount == 0) {
            System.out.println("No properties found.");
        } else {
            for (int i = 0; i < propertyCount; i++) {
                properties[i].printDetails();
            }
        }
        
        // 2. Display Tenants
        System.out.println("\n--- LIST OF TENANTS ---");
        if (tenantCount == 0) {
            System.out.println("No tenants found.");
        } else {
            for(int i = 0; i < tenantCount; i++) {
                tenants[i].printDetails();
            }
        }
    }
    public void saveData() {
        try {
            // Save Properties
            FileWriter propertyWriter = new FileWriter("properties.txt");
            for (int i = 0; i < propertyCount; i++) {
                propertyWriter.write(properties[i].toFileString() + "\n");
            }
            propertyWriter.close();

            // Save Tenants
            FileWriter tenantWriter = new FileWriter("tenants.txt");
            for (int i = 0; i < tenantCount; i++) {
                tenantWriter.write(tenants[i].toFileString() + "\n");
            }
            tenantWriter.close();
            
            System.out.println("[System] Data saved successfully.");
            
        } catch (IOException e) {
            System.out.println("[Error] Could not save data: " + e.getMessage());
        }
    }
    
    public void loadData() {
        try {
            File pFile = new File("properties.txt");
            if (pFile.exists()) {
                Scanner fileScan = new Scanner(pFile);
                while (fileScan.hasNextLine()) {
                    String line = fileScan.nextLine();
                    String[] data = line.split(";"); // Split by semicolon
                    
                    // Reconstruct the object
                    // Format: id;type;location;price;status
                    if(data.length >= 4) {
                        String id = data[0];
                        String type = data[1];
                        String loc = data[2];
                        double price = Double.parseDouble(data[3]);
                        String status = data[4];
                        
                        // Add to array manually to avoid "Success" messages
                        Property p = new Property(id, type, loc, price, status);
                        properties[propertyCount] = p;
                        propertyCount++;
                    }
                }
                fileScan.close();
                System.out.println("[System] Property data loaded.");
            }
            
            // Repeat for Tenants (Simplified for now)
            File tFile = new File("tenants.txt");
            if (tFile.exists()) {
                // ... Logic is same as above, just with Tenant objects...
                Scanner fileScan = new Scanner(tFile);
                while (fileScan.hasNextLine()) {
                    String line = fileScan.nextLine();
                    String[] data = line.split(";"); // Split by semicolon
                    
                    // Reconstruct the object
                    // Format: id;type;location;price;status
                    if(data.length >= 4) {
                        String id = data[0];
                        String type = data[1];
                        String loc = data[2];
                        double price = Double.parseDouble(data[3]);
                        String status = data[4];
                        
                        // Add to array manually to avoid "Success" messages
                        Property p = new Property(id, type, loc, price, status);
                        properties[propertyCount] = p;
                        propertyCount++;
                    }
                }
                fileScan.close();
                System.out.println("[System] Tenant data loaded.");
            }
            
        } catch (Exception e) {
            System.out.println("[Error] Could not load data: " + e.getMessage());
        }
    }
}