/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class searchByLocation {
    
    public static void search(Property[] properties, int count, String searchInput) {
        
        System.out.println("\n--- SEARCH RESULTS FOR: \"" + searchInput + "\" ---");
        
        boolean found = false;
        int matchCount = 0;

        // Loop through the existing properties
        for (int i = 0; i < count; i++) {
            
            // 1. Get the location from the current property
            String propertyLocation = properties[i].getLocation();
            
            // 2. Check match (Using toLowerCase so 'gombak' finds 'Gombak')
            // We use .contains() so "Kuala" will find "Kuala Lumpur"
            if (propertyLocation.toLowerCase().contains(searchInput.toLowerCase())) {
                
                // Print the match
                System.out.print((matchCount + 1) + ". ");
                properties[i].printDetails();
                
                found = true;
                matchCount++;
            }
        }
        
        if (found == false) {
            System.out.println("No properties found in that location.");
        } else {
            System.out.println("Total matches found: " + matchCount);
        }
    }
}
