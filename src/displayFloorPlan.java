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

public class FloorPlanReader {

    private static final String FILE_NAME = "floorplan.txt";

   
    public static void displayFloorPlan(String type) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean print = false;

            while ((line = br.readLine()) != null) {

                // Start printing when find type
                if (line.equalsIgnoreCase("[" + type + "]")) {
                    print = true;
                    continue;
                }

                
                if (print) {
                    if (line.startsWith("[")) break;
                    System.out.println(line);
                }
            }

            if (!print) {
                System.out.println("Floor plan for \"" + type + "\" not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading floorplans.txt");
        }
    }
}

}