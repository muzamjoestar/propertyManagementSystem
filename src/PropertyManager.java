/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

public class PropertyManager {
    
    // 1. Internal Storage
    private Property[] properties;
    private Tenant[] tenants;
    private int pCount;
    private int tCount;
    
    public PropertyManager() {
        properties = new Property[100]; 
        tenants = new Tenant[100];      
        pCount = 0;
        tCount = 0;
    }
    
    // 2. THIS IS THE KEY CHANGE
    public void initializeData() {
        System.out.println("[System] Importing data from Main.java...");

        // Loop through the array in Main.java and add them to our storage
        for (int i = 0; i < Main.initialProperties.length; i++) {
            addProperty(Main.initialProperties[i]);
        }

        // Loop through the tenants in Main.java
        for (int i = 0; i < Main.initialTenants.length; i++) {
            addTenant(Main.initialTenants[i]);
        }
        
        System.out.println("[System] Data import complete.");
    }

    // 3. Add Methods (Unchanged)
    public void addProperty(Property p) {
        if (pCount < properties.length) {
            properties[pCount] = p;
            pCount++;
        } else {
            System.out.println("Error: Property storage is full!");
        }
    }

    public void addTenant(Tenant t) {
        if (tCount < tenants.length) {
            tenants[tCount] = t;
            tCount++;
        }
    }

    // 4. Display Method
    public void displayAllProperties() {
        System.out.println("\n--- LIST OF PROPERTIES ---");
        if (pCount == 0) {
            System.out.println("No properties found.");
        } else {
            for (int i = 0; i < pCount; i++) {
                System.out.print((i + 1) + ". ");
                properties[i].printDetails(); 
            }
        }
    }

    // 5. Delete Method
    public void deleteProperty(String id) {
        boolean found = false;
        for (int i = 0; i < pCount; i++) {
            if (properties[i].getID().equalsIgnoreCase(id)) {
                properties[i] = properties[pCount - 1];
                properties[pCount - 1] = null; 
                pCount--; 
                found = true;
                System.out.println("Success: Property " + id + " has been deleted.");
                break; 
            }
        }
        if (!found) {
            System.out.println("Error: Property ID '" + id + "' not found.");
        }
    }
}