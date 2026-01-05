/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: PropertyManager.java
// Make sure this matches your package name (e.g., package propertymanagementsystem;)
import java.io.*;
import java.util.Scanner;

public class propertyManagerMachine { 

    // 1. DATA (Static = Shared by the whole program)
    // We removed 'private' so you can see them easily if needed, 
    // but kept 'static' so they survive without creating an object.
    static Property[] properties = new Property[100]; 
    static int propertyCount = 0;

    static Tenant[] tenants = new Tenant[100]; 
    static int tenantCount = 0;

    // 2. METHODS (Static = Use directly without 'new')

    public static void addProperty(Property p) {
        if (propertyCount < properties.length) {
            properties[propertyCount] = p;
            propertyCount++;
            System.out.println("[Success] Property Added.");
        } else {
            System.out.println("[Error] Property List Full.");
        }
    }

    public static void addTenant(Tenant t) {
        if (tenantCount < tenants.length) {
            tenants[tenantCount] = t;
            tenantCount++;
            System.out.println("[Success] Tenant Added.");
        } else {
            System.out.println("[Error] Tenant List Full.");
        }
    }

    public static void displayAll() {
        System.out.println("\n--- LIST OF PROPERTIES ---");
        if (propertyCount == 0) {
            System.out.println("No properties found.");
        } else {
            for (int i = 0; i < propertyCount; i++) {
                // We use (i+1) just to show a nice number like "1. Condo..."
                System.out.print((i+1) + ". ");
                properties[i].printDetails();
            }
        }
        
        System.out.println("\n--- LIST OF TENANTS ---");
        if (tenantCount == 0) {
            System.out.println("No tenants found.");
        } else {
            for(int i = 0; i < tenantCount; i++) {
                System.out.print((i+1) + ". ");
                tenants[i].printDetails();
            }
        }
    }

    // --- SIMPLE FILE SAVING ---

    public static void saveData() {
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
            System.out.println("[System] Data saved.");
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }
    
    public static void loadData() {
        try {
            // Load Properties
            File propertyFile = new File("properties.txt");
            if (propertyFile.exists()) {
                Scanner propertyScan = new Scanner(propertyFile);
                while (propertyScan.hasNextLine()) {
                    String line = propertyScan.nextLine();
                    String[] data = line.split(";");
                    
                    if(data.length >= 5) { 
                        Property p = new Property(data[0], data[1], data[2], Double.parseDouble(data[3]), data[4]);
                        properties[propertyCount] = p;
                        propertyCount++;
                    }
                }
                propertyScan.close();
            }
            
            // Load Tenants
            File tenantFile = new File("tenants.txt");
            if (tenantFile.exists()) {
                Scanner tScan = new Scanner(tenantFile);
                while (tScan.hasNextLine()) {
                    String line = tScan.nextLine();
                    String[] data = line.split(";");
                    
                    if(data.length >= 10) {
                        Tenant t = new Tenant(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], 
                                    data[5], data[6], Double.parseDouble(data[7]), data[8], data[9]);
                        tenants[tenantCount] = t;
                        tenantCount++;
                    }
                }
                tScan.close();
            }
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}