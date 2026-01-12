/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Property {
    
    private String propertyID;
    private String type;
    private String location;
    private double price;
    private String status;
    private int bedrooms;
    private int bathrooms;
    
    // --- NEW: Variable to store the floor plan ---
    private String[][] layout; 
    // ---------------------------------------------

    public Property(String propertyID, String type, String location, double price, String status , int bedrooms, int bathrooms) {
        this.propertyID = propertyID;
        this.type = type;
        this.location = location;
        this.price = price;
        this.status = status;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        // Layout is empty by default until they draw it
    }

    // --- NEW: Methods to save and get the map ---
    public void setLayout(String[][] newLayout) {
        this.layout = newLayout;
    }

    public String[][] getLayout() {
        return this.layout;
    }
    // --------------------------------------------

    public void printDetails() {
        System.out.println("Property ID: " + propertyID);
        System.out.println("Type: " + type);
        System.out.println("Location: " + location);
        System.out.println("Price: RM " + price);
        System.out.println("Status: " + status);
        System.out.println("Bedrooms: " + bedrooms);
        System.out.println("Bathrooms: " + bathrooms);
        
        // Optional: Print map if it exists
        if (layout != null) {
            System.out.println("--- Floor Plan ---");
            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[i].length; j++) {
                    System.out.print(layout[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println("---------------------------");
    }

    public String getID() { return propertyID; }
    public String getType() { return type; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
    public int getBedrooms() { return bedrooms; }
    public int getBathrooms() { return bathrooms; }
    
    public String toFileString() {
        return propertyID + ";" + type + ";" + location + ";" + price + ";" + status + ";" + bedrooms + ";" +bathrooms;
    }
}