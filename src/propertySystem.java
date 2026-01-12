/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.Scanner;

public class propertySystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 1. CRITICAL FIX: Create the Manager Object
        PropertyManager propertyManagerMachine = new PropertyManager();
        
        boolean running = true;

        System.out.println("--------------------------------------------");
        System.out.println(" WELCOME TO THE PROPERTY MANAGEMENT SYSTEM  ");
        System.out.println("--------------------------------------------");

        // Try to load data (Only if you have implemented this method)
        // propertyManagerMachine.loadData(); 

        while(running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add New Property");
            System.out.println("2. View Available Properties");
            System.out.println("3. Delete Existing Property");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            // Check if user actually typed a number
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine(); // Consumes the "Enter" key (Fixes skip bug)

                switch(choice) {
                    case 1:
                    System.out.println("\n--- ADD NEW PROPERTY ---");
                    System.out.print("Enter Property ID (e.g. P101): ");
                    String id = input.nextLine();

                    System.out.print("Enter Type (e.g. Apartment): ");
                    String type = input.nextLine();

                    System.out.print("Enter Location: ");
                    String loc = input.nextLine();

                    System.out.print("Enter Price (RM): ");
                    double price = input.nextDouble();
                    input.nextLine(); // Consume enter key

                    // --- DRAWING THE FLOOR PLAN ---
                    System.out.println("\n--- DRAW FLOOR PLAN ---");
                    System.out.print("Enter total ROWS (Length): ");
                    int rows = input.nextInt();
                    System.out.print("Enter total COLUMNS (Width): ");
                    int cols = input.nextInt();
                    input.nextLine(); // Consume enter key

                    // 1. Create and Pre-fill Map
                    String[][] floorPlan = new String[rows][cols];
                    for(int r=0; r<rows; r++) {
                        for(int c=0; c<cols; c++) {
                            floorPlan[r][c] = " "; // Fill with empty space first
                        }
                    }

                    System.out.println("Draw row by row (Type 'X' to finish early).");
                    System.out.println("Legend: | = Wall, B = Bedroom, T = Toilet");

                    // 2. User Draws the Map
                    for (int i = 0; i < rows; i++) {
                        System.out.print("Row " + (i+1) + ": ");
                        String line = input.nextLine();

                        if (line.equalsIgnoreCase("X")) {
                            System.out.println("...Finishing drawing early.");
                            break; 
                        }

                        for (int j = 0; j < cols; j++) {
                            if (j < line.length()) {
                                floorPlan[i][j] = String.valueOf(line.charAt(j));
                            }
                        }
                    }

                    // --- SMART COUNTING LOGIC (New Feature) ---
                    System.out.println("[System] Analyzing floor plan...");
                    int bedroomCount = 0;
                    int bathroomCount = 0;

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            // Check for B (Bedroom) - ignores Case (b or B)
                            if (floorPlan[i][j].equalsIgnoreCase("B")) {
                                bedroomCount++;
                            }
                            // Check for T (Toilet) - ignores Case (t or T)
                            else if (floorPlan[i][j].equalsIgnoreCase("T")) {
                                bathroomCount++;
                            }
                        }
                    }

                    System.out.println("Detected: " + bedroomCount + " Bedrooms and " + bathroomCount + " Bathrooms.");

                    // 3. Create Object using the COUNTED numbers
                    Property newProp = new Property(id, type, loc, price, "Available", bedroomCount, bathroomCount);

                    // Save the map (assuming you added the setLayout method to Property.java)
                    // newProp.setLayout(floorPlan); 

                    propertyManagerMachine.addProperty(newProp);
                    System.out.println("Property Added Successfully!");
                    break;
                        
                    case 2:
                        System.out.println("\n--- LIST OF PROPERTIES ---");
                        // You need to create this method in PropertyManager.java!
                        // propertyManagerMachine.displayAllProperties(); 
                        break;
                        
                    case 3:
                        // Call the delete method you already wrote
                        propertyManagerMachine.deleteProperty();
                        break;
                        
                    case 4:
                        System.out.println("Saving data...");
                        // propertyManagerMachine.saveData(); // Uncomment when ready
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
}