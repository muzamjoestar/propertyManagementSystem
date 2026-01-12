/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.Scanner;

public class propertySystemInterface{

    // --- GLOBAL STORAGE (STATIC) ---
    // These replace the PropertyManager object
    static Property[] properties = new Property[100]; // Can hold 100 properties
    static Tenant[] tenants = new Tenant[100];        // Can hold 100 tenants
    static int pCount = 0; // Tracks how many properties we have
    static int tCount = 0; // Tracks how many tenants we have
    
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        // 1. Load the hardcoded data immediately
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
                        // Call the static add function defined below
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

    // --- LOGIC METHODS ---

    // 1. Method to Load your Hardcoded Data
    public static void initializeData() {
        // Add Properties
        addProperty(new Property("P001", "Bungalow", "Setapak", 2500000.00, "Available", 4, 3));
        addProperty(new Property("P002", "Terrace House", "Gombak", 600000.00, "Sold", 3, 3));
        addProperty(new Property("P003", "Apartment", "Ampang", 450000.00, "Available", 1, 1));
        addProperty(new Property("P004", "Condominium", "Cheras", 750000.00, "Rented", 3, 2));
        addProperty(new Property("P005", "Studio", "Mont Kiara", 500000.00, "Available", 1, 1));
        // ... You can add the rest of your list here ...

        // Add Tenants
        addTenant(new Tenant("T001", "Ali Abu", "Male", 30, "012-3456789", "ali@gmail.com", "Engineer", 5000, "Single", "Malaysian"));
        addTenant(new Tenant("T002", "Siti Zubaidah", "Female", 28, "013-9876543", "siti@gmail.com", "Teacher", 4000, "Married", "Malaysian"));
        // ... You can add the rest here ...
        
        System.out.println("[System] Data loaded successfully.");
    }

    // 2. Helper to add to array safely
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

    // 3. The Display Logic
    public static void displayAllProperties() {
        System.out.println("\n--- LIST OF PROPERTIES ---");
        System.out.printf("%-10s %-15s %-15s %-10s\n", "ID", "Type", "Location", "Status");
        for (int i = 0; i < pCount; i++) {
            System.out.printf("%-10s %-15s %-15s %-10s\n", 
                properties[i].getID(), properties[i].getType(), 
                properties[i].getLocation(), properties[i].getStatus()); // Assuming getters exist
        }
    }

    // 4. The Delete Logic
    public static void deletePropertyProcess() {
        System.out.print("Enter Property ID to delete: ");
        String id = input.nextLine();
        
        boolean found = false;
        for (int i = 0; i < pCount; i++) {
            if (properties[i].getID().equalsIgnoreCase(id)) {
                // Swap with the last item to fill the gap
                properties[i] = properties[pCount - 1];
                properties[pCount - 1] = null; // Clear the duplicate
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

    // 5. The Add New Property Logic (With Floor Plan)
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

        // Create and Save
        Property newP = new Property(id, type, loc, price, "Available", bed, bath);
        // newP.setLayout(floorPlan); // Enable this if you added the setLayout method
        addProperty(newP);
        System.out.println("Property Added!");
    }
}