/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.Scanner;

public class propertySystemInterface {

    
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        // 1. Load data using a STATIC method
        Main.loadData(); 

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
                        PropertyManager.displayAllProperties(); // Call static method
                        break;
                    case 3:
                        deletePropertyProcess(); // Call static method
                        break;
                    case 4:
                        System.out.print("Enter location to search (e.g. Gombak): ");
                        String userSearch = input.nextLine();

                        // Call the separate class
                        // We pass the 'properties' array and 'pCount' variable
                        searchByLocation.search(Main.properties, Main.pCount, userSearch);
                        break;
                    case 5:
                        System.out.println("Exiting System. Goodbye!");
                        Main.saveData();
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


    // 5. The User Input Process for Adding (Includes Floor Plan)
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
        // Create the object
        Property newP = new Property(id, type, loc, price, "Available", bed, bath);
        newP.setLayout(floorPlan);
        
        // CALL THE MANAGER
        PropertyManager.addProperty(newP); 
        System.out.println("Property Added Successfully!");
    }
    public static void deletePropertyProcess() {
        System.out.print("Enter Property ID to delete: ");
        String id = input.nextLine();
        
        // CALL THE MANAGER
        PropertyManager.deleteProperty(id);
    }
}