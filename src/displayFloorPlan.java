/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codinghadif;

/**
 *
 * @author user
 */
public void displayPlan(String propertyType) {
    // Hadif's Task B: Topic 8 - Multidimensional Arrays
    char[][] grid;

    // Logic: Select the grid based on the "type" provided by Aqil
    switch (propertyType.toLowerCase()) {
        case "bungalow":
            grid = new char[][]{
                {'-','-','-','-','-','-','-','-','-','-','-'},
                {'|',' ','B',' ','|',' ','G','a','r','d','|'}, // B=Bedroom
                {'|','-','-','-',' ','-','-','-','-','-','|'},
                {'|',' ',' ','L','i','v','i','n','g',' ','|'}, // Large Living
                {'-','-','-','-','-','-','-','-','-','-','-'}
            };
            break;
            
        case "terrace house":
            grid = new char[][]{
                {'-','-','-','-','-','-','-'},
                {'|',' ','B',' ','|',' ','|'},
                {'|','-','-',' ','-','-','|'},
                {'|',' ','K','i','t',' ','|'}, // Long narrow layout
                {'-','-','-','-','-','-','-'}
            };
            break;
            
        case "apartment":
            grid = new char[][]{
                {'-','-','-','-','-','-','-'},
                {'|',' ','B',' ','|',' ','|'},
                {'|',' ','-','-','-',' ','|'},
                {'|',' ','L',' ','K',' ','|'}, // Standard Apartment
                {'-','-','-','-','-','-','-'}
            };
            break;
            
        case "condominium":
            grid = new char[][]{
                {'-','-','-','-','-','-','-','-','-'},
                {'|',' ','B',' ','|',' ','B','a','l','|'}, // Balcony included
                {'|','-','-','-',' ','-','-','-','|'},
                {'|',' ',' ','L','i','v',' ',' ','|'},
                {'-','-','-','-','-','-','-','-','-'}
            };
            break;
            
        case "studio":
            grid = new char[][]{
                {'-','-','-','-','-'},
                {'|',' ',' ',' ','|'},
                {'|',' ','S',' ','|'}, // S = Studio/Single space
                {'|',' ',' ',' ','|'},
                {'-','-','-','-','-'}
            };
            break;
            
        case "cluster house":
            grid = new char[][]{
                {'-','-','-','|','-','-','-'},
                {'|',' ','B','|','B',' ','|'}, // Shared wall style
                {'|','-','-','|','-','-','|'},
                {'|',' ','L','|','L',' ','|'},
                {'-','-','-','|','-','-','-'}
            };
            break;
            
        default:
            // Fallback for any other type
            grid = new char[][]{
                {'-','-','-'},
                {'|','?','|'},
                {'-','-','-'}
            };
            break;
    }

    // Task B Logic: The Nested Loop to display the grid
    System.out.println("\n--- Floor Plan for " + propertyType + " ---");
    for (int i = 0; i < grid.length; i++) {       // Outer loop for Rows
        for (int j = 0; j < grid[i].length; j++) { // Inner loop for Columns
            System.out.print(grid[i][j]);          // Print without newline
        }
        System.out.println();                      // Newline after each row
    }
}