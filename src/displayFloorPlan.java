/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
        
/**
 *
 * @author user
 */
public class displayFloorPlan {
public void displayFloorPlan(String propertyType) {

        propertyType = propertyType.trim();

        String filename = "floorplans/floorplans.txt";
        String searchTag = "[" + propertyType.toUpperCase() + "]";

        boolean print = false;
        boolean found = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {

                if (line.equalsIgnoreCase(searchTag)) {
                    print = true;
                    found = true;
                    continue;
                }

                if (line.startsWith("[") && print) {
                    break;
                }

                if (print) {
                    System.out.println(line);
                }
            }

            reader.close();

            if (!found) {
                System.out.println("Floor plan for \"" + propertyType + "\" not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading floor plan file.");
        }
}
}