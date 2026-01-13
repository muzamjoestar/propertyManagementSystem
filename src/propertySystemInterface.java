/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class propertySystemInterface {

    // --- STATIC STORAGE (Global Variables) ---
    // These belong to the class, not an object.
    static Property[] properties = new Property[100]; 
    static Tenant[] tenants = new Tenant[100];        
    static int pCount = 0; 
    static int tCount = 0; 
    
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        // 1. Load data using a STATIC method
        initializeData(); 

        boolean running = true;

        System.out.println("--------------------------------------------");
        System.out.println(" WELCOME TO THE PROPERTY MANAGEMENT SYSTEM  ");
        System.out.println("--------------------------------------------");

        while(running == true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add New Property");
            System.out.println("2. View Available Properties");
            System.out.println("3. Delete Existing Property");
            System.out.println("4. Search Properties by Location");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine(); // Fix "Enter key" skip bug

                switch(choice) {
                    case 1:
                        addNewPropertyProcess(); // Call static method
                        break;
                    case 2:
                        displayAllProperties(); // Call static method
                        break;
                    case 3:
                        deletePropertyProcess(); // Call static method
                        break;
                    case 4:
                        System.out.print("Enter location to search (e.g. Gombak): ");
                        String userSearch = input.nextLine();

                        // Call the separate class
                        // We pass the 'properties' array and 'pCount' variable
                        searchByLocation.search(properties, pCount, userSearch);
                        break;
                    case 5:
                        System.out.println("Exiting System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try 1-4.");
                }
            } else {
                String badInput = input.next();
                System.out.println("Error: '" + badInput + "' is not a number.");
            }
        }
    }

    // ==========================================
    //       ALL LOGIC IS NOW STATIC BELOW
    // ==========================================

    // 1. Initialize Data (Fetches from Main.java)
    public static void initializeData() {
        System.out.println("[System] Importing data from Main.java...");

        // Loop through the STATIC array in Main.java
        for (int i = 0; i < Main.initialProperties.length; i++) {
            addProperty(Main.initialProperties[i]);
        }

        // Loop through the STATIC tenants in Main.java
        for (int i = 0; i < Main.initialTenants.length; i++) {
            addTenant(Main.initialTenants[i]);
        }
        
        System.out.println("[System] Data import complete.");
    }

    // 2. Add Property (Static Helper)
    public static void addProperty(Property p) {
        if (pCount < properties.length) {
            properties[pCount] = p;
            pCount++;
        } else {
            System.out.println("Error: Property storage is full!");
        }
    }

    // 3. Add Tenant (Static Helper)
    public static void addTenant(Tenant t) {
        if (tCount < tenants.length) {
            tenants[tCount] = t;
            tCount++;
        }
        else {
            System.out.println("Error: Tenant storage is full!");
        }
    }

    // 4. Display Logic
    public static void displayAllProperties() {
        System.out.println("\n--- LIST OF PROPERTIES ---");
        for (int i = 0; i < pCount; i++) {
            System.out.print((i + 1) + ". ");
            // We can call instance methods ON the object, that's fine!
            properties[i].printDetails(); 
        }
    }

    // 5. Delete Logic
    public static void deletePropertyProcess() {
        System.out.print("Enter Property ID to delete: ");
        String id = input.nextLine();
        
        boolean found = false;
        for (int i = 0; i < pCount; i++) {
            if (properties[i].getID().equalsIgnoreCase(id)) {
                // Swap with the last item
                properties[i] = properties[pCount - 1];
                properties[pCount - 1] = null; 
                pCount--;
                found = true;
                System.out.println("Property " + id + " deleted.");
                break;
            }
        }
        if (found == false) {
            System.out.println("Property ID not found.");
        }
    }

    // 6. The User Input Process for Adding (Includes Floor Plan)
    public static void addNewPropertyProcess() {
        System.out.println("\n--- ADD NEW PROPERTY ---");
        System.out.print("Enter Property ID: ");
        String id = input.nextLine();
        
        System.out.print("Enter Type: ");
        String type = input.nextLine();
        
        System.out.print("Enter Location: ");
        String loc = input.nextLine();
        
        // Safe Price Input
        double price = 0;
        while(true) {
            System.out.print("Enter Price (RM): ");
            if (input.hasNextDouble()) {
                price = input.nextDouble();
                input.nextLine(); 
                break;
            } else {
                System.out.println("Error: Enter a valid number.");
                input.next();
            }
        }

        // --- DRAW FLOOR PLAN ---
        System.out.println("\n--- DRAW FLOOR PLAN ---");
        
        // Safe Rows Input
        int rows = 0;
        while(true) {
            System.out.print("Enter ROWS: ");
            if (input.hasNextInt()) { rows = input.nextInt(); break; }
            else { System.out.println("Error: Enter a whole number."); input.next(); }
        }

        // Safe Cols Input
        int cols = 0;
        while(true) {
            System.out.print("Enter COLUMNS: ");
            if (input.hasNextInt()) { 
                cols = input.nextInt(); 
                input.nextLine(); 
                break; 
            }
            else { 
                System.out.println("Error: Enter a whole number."); 
                input.next(); 
            }
        }

        String[][] floorPlan = new String[rows][cols];
        
        // Pre-fill
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                floorPlan[r][c] = " ";
            }
        }

        System.out.println("Draw map (Type 'X' to finish early). Legend: B=Bed, T=Toilet");
        for (int i = 0; i < rows; i++) {
            System.out.print("Row " + (i+1) + ": ");
            String line = input.nextLine();
            
            if (line.equalsIgnoreCase("X")) 
                break;

            for (int j = 0; j < cols; j++) {
                if (j < line.length()) {
                    floorPlan[i][j] = String.valueOf(line.charAt(j));
                }
            }
        }

        // Auto-Count Bed/Bath
        int bed = 0;
        int bath = 0;
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(floorPlan[r][c].equalsIgnoreCase("B")) bed++;
                if(floorPlan[r][c].equalsIgnoreCase("T")) bath++;
            }
        }
        System.out.println("Detected: " + bed + " Bedrooms & " + bath + " Bathrooms.");

        // Create Object & Save
        Property newProperty = new Property(id, type, loc, price, "Available", bed, bath);
        newProperty.setLayout(floorPlan); // Requires updated Property.java
        
        addProperty(newProperty);
        System.out.println("Property Added Successfully!");
    }
}