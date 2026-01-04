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

    
    public Property(String propertyID, String type, String location, double price, String status) {
        this.propertyID = propertyID;
        this.type = type;
        this.location = location;
        this.price = price;
        this.status = status;
    }

    public void printDetails() {
        System.out.println("Property ID: " + propertyID);
        System.out.println("Type: " + type);
        System.out.println("Location: " + location);
        System.out.println("Price: RM " + price);
        System.out.println("Status: " + status);
        System.out.println("---------------------------");
    }
    public String getID() { return propertyID; }
    public String getType() { return type; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
    public String toFileString() {
        return propertyID + ";" + type + ";" + location + ";" + price + ";" + status;
    }
}

