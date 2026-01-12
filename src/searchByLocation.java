/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public void searchByLocation(String keyword) {
        boolean found = false;
        System.out.println("\n--- Searching for Location: " + keyword + " ---");

        // The loop runs from 0 up to 'count' (Ipan's variable)
        for (int i = 0; i < count; i++) { 
            
            // Comparison: 'location' is the variable Aqil defined
            // 'keyword' is the value Muzam gets from the user
            if (storage[i].location.equalsIgnoreCase(keyword)) { 
                
                // If matched, you call 'printDetails' (Aqil's method)
                storage[i].printDetails(); 
                found = true;
            }
        }

        if (!found) {
            System.out.println("Result: No properties found in " + keyword);
        }
    }
