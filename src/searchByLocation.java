/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class searchByLocation {
    private Property[] storage;
    private int count;

    public searchByLocation(Property[] properties) {
        this.storage = properties;
        this.count = properties.length;
    }

    public void searchAndShowFloorPlan(String keyword) {
        boolean found = false;
        System.out.println("\n--- Searching for Location: " + keyword + " ---");

        displayFloorPlan floorPlan = new displayFloorPlan();

        for (int i = 0; i < count; i++) {
            if (storage[i].getLocation().equalsIgnoreCase(keyword)) {
                storage[i].printDetails(); // show property info
                floorPlan.showFloorPlan(storage[i].getType()); // show floor plan for property type
                found = true;
            }
        }

        if (!found) {
            System.out.println("Result: No properties found in " + keyword);
        }
    }
}
