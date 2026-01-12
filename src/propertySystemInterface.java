/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.Scanner;

// THE NAME HERE MUST MATCH YOUR FILE NAME EXACTLY
public class propertySystemInterface {

    // --- GLOBAL STORAGE ---
    static Property[] properties = new Property[100]; 
    static Tenant[] tenants = new Tenant[100];        
    static int pCount = 0; 
    static int tCount = 0; 
    
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        // Load initial data so the list isn't empty
        initializeData(); 

        boolean running = true;

        System.out.println("--------------------------------------------");
        System.out.println(" WELCOME TO THE PROPERTY MANAGEMENT SYSTEM  ");
        System.out.println("--------------------------------------------");

        while(running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add New Property");
            System.out.println("2. View Available Properties");
            System.out.println("3. Delete Existing Property");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine(); // Fix skip bug

                switch(choice) {
                    case 1:
                        addNewPropertyProcess(); 
                        break;
                    case 2:
                        displayAllProperties();
                        break;
                    case 3:
                        deletePropertyProcess();
                        break;
                    case 4:
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

    // --- METHODS ---

    public static void initializeData() {
        // Add hardcoded properties
        addProperty(new Property("P001", "Bungalow", "Setapak", 2500000.00, "Available", 4, 3));
        addProperty(new Property("P002", "Terrace House", "Gombak", 600000.00, "Sold", 3, 3));
        addProperty(new Property("P003", "Apartment", "Ampang", 450000.00, "Available", 1, 1));
        // ... (You can add the rest of your list here) ...

        // Add hardcoded tenants
        addTenant(new Tenant("T001", "Ali Abu", "Male", 30, "012-3456789", "ali@gmail.com", "Engineer", 5000, "Single", "Malaysian"));
        addTenant(new Tenant("T002", "Siti Zubaidah", "Female", 28, "013-9876543", "siti@gmail.com", "Teacher", 4000, "Married", "Malaysian"));
        
        System.out.println("[System] Initial data loaded.");
    }

    public static void addProperty(Property p) {
        if (pCount < properties.length) {
            properties[pCount] = p;
            pCount++;
        } else {
            System.out.println("Error: Storage full!");
        }
    }

    public static void addTenant(Tenant t) {
        if (tCount < tenants.length) {
            tenants[tCount] = t;
            tCount++;
        }
    }

    public static void displayAllProperties() {
        System.out.println("\n--- LIST OF PROPERTIES ---");
        for (int i = 0; i < pCount; i++) {
            // Using the printDetails method you wrote in Property.java
            System.out.println("#" + (i+1));
            properties[i].printDetails(); 
        }
    }

    public static void deletePropertyProcess() {
        System.out.print("Enter Property ID to delete: ");
        String id = input.nextLine();
        
        boolean found = false;
        for (int i = 0; i < pCount; i++) {
            if (properties[i].getID().equalsIgnoreCase(id)) {
                // Swap logic
                properties[i] = properties[pCount - 1];
                properties[pCount - 1] = null; 
                pCount--;
                found = true;
                System.out.println("Property " + id + " deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("Property ID not found.");
        }
    }

    public static void addNewPropertyProcess() {
        System.out.println("\n--- ADD NEW PROPERTY ---");
        System.out.print("Enter Property ID: ");
        String id = input.nextLine();
        
        System.out.print("Enter Type: ");
        String type = input.nextLine();
        
        System.out.print("Enter Location: ");
        String loc = input.nextLine();
        
        System.out.print("Enter Price (RM): ");
        double price = input.nextDouble();
        input.nextLine(); 

        // --- DRAW FLOOR PLAN ---
        System.out.println("\n--- DRAW FLOOR PLAN ---");
        System.out.print("Enter ROWS: ");
        int rows = input.nextInt();
        System.out.print("Enter COLS: ");
        int cols = input.nextInt();
        input.nextLine(); 

        String[][] floorPlan = new String[rows][cols];
        
        // Pre-fill
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) floorPlan[r][c] = " ";
        }

        System.out.println("Draw map (X to finish early). Legend: B=Bed, T=Toilet");
        for (int i = 0; i < rows; i++) {
            System.out.print("Row " + (i+1) + ": ");
            String line = input.nextLine();
            if (line.equalsIgnoreCase("X")) break;

            for (int j = 0; j < cols; j++) {
                if (j < line.length()) {
                    floorPlan[i][j] = String.valueOf(line.charAt(j));
                }
            }
        }

        // Auto-Count Bed/Bath
        int bed = 0, bath = 0;
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(floorPlan[r][c].equalsIgnoreCase("B")) bed++;
                if(floorPlan[r][c].equalsIgnoreCase("T")) bath++;
            }
        }
        System.out.println("Detected: " + bed + " Beds, " + bath + " Baths.");

        // Create Object
        Property newP = new Property(id, type, loc, price, "Available", bed, bath);
        
        // Save the map inside the object (This works now because you updated Property.java)
        newP.setLayout(floorPlan); 
        
        addProperty(newP);
        System.out.println("Property Added Successfully!");
    }
}