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
        boolean running = true;
        System.out.println("--------------------------------------------");
        System.out.println(" WELCOME TO THE PROPERTY MANAGEMENT SYSTEM  ");
        System.out.println("--------------------------------------------");

        while(running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add New Property");
            System.out.println("2. View Available Properties");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    // addProperty();
                    break;
                case 2:
                    System.out.println("[System] View Available Properties:");
                    // viewProperties();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
