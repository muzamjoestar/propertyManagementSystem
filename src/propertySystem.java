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
    
    // 1. Create the Manager Engine (Must be outside main to survive)
    // MAKE SURE 'PropertyManager' matches your actual file name (e.g. PropertyManagerMachine?) 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("[System] Checking for saved data...");
        propertyManagerMachine.loadData();

        System.out.println("--------------------------------------------");
        System.out.println(" WELCOME TO THE PROPERTY MANAGEMENT SYSTEM  ");
        System.out.println("--------------------------------------------");

        while(running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add New Property");
            System.out.println("2. View Available Properties");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            // Check if user actually typed a number to prevent crashing
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine(); // <--- CRITICAL FIX: Consumes the "Enter" key

                switch(choice) {
                    case 1:
                        System.out.println("\n--- ADD NEW PROPERTY ---");
                        // Step A: Ask for details
                        System.out.print("Enter Property ID (e.g. P101): ");
                        String id = input.nextLine();
                        
                        System.out.print("Enter Type (e.g. Apartment): ");
                        String type = input.nextLine();
                        
                        System.out.print("Enter Location: ");
                        String loc = input.nextLine();
                        
                        System.out.print("Enter Price (RM): ");
                        double price = input.nextDouble();
                        input.nextLine(); // Consume enter key again
                        
                        // Step B: Create the object
                        // Note: We use "Available" as default status
                        Property newProp = new Property(id, type, loc, price, "Available");
                        
                        // Step C: Send it to the Manager
                        propertyManagerMachine.addProperty(newProp);
                        break;
                        
                    case 2:
                        // Step D: Call the view method
                        propertyManagerMachine.displayAll();
                        break;
                        
                    case 3:
                        System.out.println("Saving data...");
                        propertyManagerMachine.saveData();
                        System.out.println("Exiting System. Goodbye!");
                        running = false;
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please try 1-3.");
                }
            } else {
                // If they typed "abc" instead of 1
                String badInput = input.next();
                System.out.println("Error: '" + badInput + "' is not a number.");
            }
        }
    }
}