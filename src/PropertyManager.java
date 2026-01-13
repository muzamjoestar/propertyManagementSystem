/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class PropertyManager {

    // --- 1. ADD PROPERTY ---
    public static void addProperty(Property newProperty) {
        if (Main.pCount < Main.properties.length) {
            Main.properties[Main.pCount] = newProperty;
            Main.pCount++;
            // Note: We don't save to file here automatically. 
            // We usually save only when the user chooses "Exit" or "Save".
        } else {
            System.out.println("Error: Property storage is full (Max 100)!");
        }
    }

    // --- 2. ADD TENANT ---
    public static void addTenant(Tenant newTenant) {
        if (Main.tCount < Main.tenants.length) {
            Main.tenants[Main.tCount] = newTenant;
            Main.tCount++;
        } else {
            System.out.println("Error: Tenant storage is full (Max 100)!");
        }
    }

    // --- 3. DISPLAY ALL PROPERTIES ---
    public static void displayAllProperties() {
        System.out.println("\n--- LIST OF PROPERTIES ---");
        if (Main.pCount == 0) {
            System.out.println("No properties found.");
        } else {
            for (int i = 0; i < Main.pCount; i++) {
                System.out.print((i + 1) + ". ");
                Main.properties[i].printDetails(); 
            }
        }
    }

    // --- DELETE PROPERTY ---
    public static void deleteProperty(String id) {
        boolean found = false;
        
        for (int i = 0; i < Main.pCount; i++) {
            // Check if ID matches (IgnoreCase handles p001 vs P001)
            if (Main.properties[i].getID().equalsIgnoreCase(id)) {
                
                // Swap the deleted item with the last item in the list
                // This fills the hole so we don't have nulls in the middle
                Main.properties[i] = Main.properties[Main.pCount - 1];
                Main.properties[Main.pCount - 1] = null; // Delete the duplicate at the end
                
                Main.pCount--; // Decrease count
                found = true;
                System.out.println("Success: Property " + id + " has been deleted.");
                break; // Stop looking
            }
        }
        
        if (!found) {
            System.out.println("Error: Property ID '" + id + "' not found.");
        }
    }
    
    public static void displayAllTenants() {
        System.out.println("\n--- LIST OF TENANTS ---");
        if (Main.tCount == 0) {
            System.out.println("No tenants found.");
        } else {
            for (int i = 0; i < Main.tCount; i++) {
                System.out.print((i + 1) + ". ");
                // Calls the printDetails() method inside Tenant.java
                Main.tenants[i].printDetails(); 
            }
        }
    }

    // --- DELETE TENANT ---
    public static void deleteTenant(String id) {
        boolean found = false;
        for (int i = 0; i < Main.tCount; i++) {
            if (Main.tenants[i].getTID().equalsIgnoreCase(id)) {
                // Swap logic
                Main.tenants[i] = Main.tenants[Main.tCount - 1];
                Main.tenants[Main.tCount - 1] = null; 
                Main.tCount--; 
                found = true;
                System.out.println("Success: Tenant " + id + " has been deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Tenant ID '" + id + "' not found.");
        }
    }
}