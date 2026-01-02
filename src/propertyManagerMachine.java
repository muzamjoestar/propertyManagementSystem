/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: PropertyManager.java
// Make sure this matches your package name (e.g., package propertymanagementsystem;)

public class PropertyManagerMachine {
    // 1. Storage: We store 'Property' objects, not 'int'
    // NOTE: This will show an ERROR until you create the Property.java file below.
    private Property[] properties = new Property[100]; 
    private int count = 0;

    // 2. Add Method
    public void addProperty(Property p) {
        if (count < properties.length) {
            properties[count] = p; // Store the object
            count++; // Increment counter
            System.out.println("[System] Property added successfully.");
        } else {
            System.out.println("[Error] Storage is full.");
        }
    }

    // 3. Display Method
    public void viewProperties() {
        if (count == 0) {
            System.out.println("No properties found.");
            return;
        }
        System.out.println("\n--- Property List ---");
        for (int i = 0; i < count; i++) {
            // We call the print method inside the Property object
            properties[i].printDetails(); 
        }
    }
    
    // 4. Helper for Hadif
    public Property[] getAllProperties() {
        return properties;
    }
    
    public int getCount() {
        return count;
    }
}