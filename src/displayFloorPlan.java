/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codinghadif;

/**
 *
 * @author user
 */
public static void displayFloorPlan(String propertyType) { // This 'type' comes from Aqil's class
    char[][] grid;

    // Logic: Decide which drawing to use based on Aqil's data
    if (propertyType.equalsIgnoreCase("Bungalow")) {
        grid = new char[][]{
            {'-', '-', '-', '-', '-', '-', '-'},
            {'|', ' ', 'B', ' ', '|', ' ', 'B', '|'}, // Larger layout for Bungalow
            {'|', '-', '-', ' ', '-', '-', '|'},
            {'|', ' ', ' ', 'L', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-'}
        };
    } else if (propertyType.equalsIgnoreCase("Apartment")) {
        grid = new char[][]{
            {'-', '-', '-', '-', '-'},
            {'|', 'B', '|', 'K', '|'}, // Compact layout for Apartment
            {'-', '-', '-', '-', '-'}
        };
    } else {
        // A simple generic box if the type is unknown
        grid = new char[][]{
            {'-', '-', '-'},
            {'|', ' ', '|'},
            {'-', '-', '-'}
        };
    }

    // Your Nested Loop (Task B) to print whatever grid was chosen
    for (int i = 0; i < grid.length; i++) {       // Outer loop for rows
        for (int j = 0; j < grid[i].length; j++) { // Inner loop for columns
            System.out.print(grid[i][j]);          // Print characters side-by-side
        }
        System.out.println();                      // Move to next line after each row
    }
}