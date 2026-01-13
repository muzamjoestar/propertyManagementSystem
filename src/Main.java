/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 *
 * @author Acer
 */
public class Main {
    
    public static Property[] properties = new Property[100];
    public static Tenant[] tenants = new Tenant[100];
    public static int pCount = 0;
    public static int tCount = 0;
    
    private static Property[] initialProperties = {
        new Property("P001", "Bungalow", "Setapak", 2500000.00, "Available", 4, 3),
        new Property("P002", "Terrace House", "Gombak", 600000.00, "Sold", 3, 3),
        new Property("P003", "Apartment", "Ampang", 450000.00, "Available", 1, 1),
        new Property("P004", "Condominium", "Cheras", 750000.00, "Rented", 3, 2),
        new Property("P005", "Studio", "Mont Kiara", 500000.00, "Available", 1, 1),
        new Property("P006", "Cluster House", "Shah Alam", 1200000.00, "Available", 3, 3),
        new Property("P007", "Bungalow", "Damansara", 2800000.00, "Sold", 4, 3),
        new Property("P008", "Terrace House", "Kajang", 550000.00, "Available", 4, 4),
        new Property("P009", "Apartment", "Bangi", 400000.00, "Available", 1, 1),
        new Property("P010", "Condominium", "Subang Jaya", 80000.00, "Rented", 3, 2),
        new Property("P011", "Studio", "Petaling Jaya", 480000.00, "Available", 1, 1),
        new Property("P012", "Cluster House", "Cyberjaya", 1240000.00, "Available", 3, 3),
        new Property("P013", "Studio", "Bukit Bintang", 800000.00, "Sold", 1, 1),
        new Property("P014", "Terrace House", "Seremban", 500000.00, "Available", 3, 3),
        new Property("P015", "Apartment", "Kepong", 420000.00, "Available", 1, 1)
    };

    private static Tenant[] initialTenants = {
        new Tenant("T001", "Ali Abu", "Male", 30, "012-3456789", "ali@gmail.com", "Engineer", 5000, "Single", "Malaysian"),
        new Tenant("T002", "Siti Zubaidah", "Female", 28, "013-9876543", "siti@gmail.com", "Teacher", 4000, "Married", "Malaysian"),
        new Tenant("T003", "Ahmad Aqil", "Male", 35, "014-2233445", "ahmad@gmail.com", "Doctor", 8000, "Married", "Malaysian"),
        new Tenant("T004", "Farah Ann", "Female", 26, "015-5566778", "farah@gmail.com", "Designer", 3500, "Single", "Malaysian"),
        new Tenant("T005", "JohnCena", "Male", 40, "016-1122334", "john@gmail.com", "Manager", 9000, "Married", "American"),
        new Tenant("T006", "Mei Ling", "Female", 32, "017-4455667", "meiling@gmail.com", "Accountant", 6000, "Single", "Chinese"),
        new Tenant("T007", "Raj Singh", "Male", 29, "018-7788990", "raj@gmail.com", "IT Specialist", 5500, "Single", "Indian"),
        new Tenant("T008", "Aisyah Mahmud", "Female", 27, "019-9988776", "aisyah@gmail.com", "Nurse", 3800, "Married", "Malaysian"),
        new Tenant("T009", "Daniel Mc. Dodo", "Male", 33, "011-3344556", "daniel@gmail.com", "Pilot", 12000, "Married", "British"),
        new Tenant("T010", "Nora Danish", "Female", 31, "012-6677889", "nora@gmail.com", "Lawyer", 7000, "Single", "Malaysian"),
        new Tenant("T011", "Hafiz Fauzi", "Male", 36, "013-2233556", "hafiz@gmail.com", "Lecturer", 6500, "Married", "Malaysian"),
        new Tenant("T012", "Lina Pompom", "Female", 25, "014-8899001", "lina@gmail.com", "Student", 1500, "Single", "Indonesian"),
        new Tenant("T013", "Syafiq Kyle", "Male", 34, "015-5566442", "syafiqkyle@gmail.com", "Architect", 7200, "Married", "Malaysian"),
        new Tenant("T014", "Maria Lee", "Female", 29, "016-7788223", "maria@gmail.com", "Chef", 4000, "Single", "Spanish"),
        new Tenant("T015", "Zul Fahmi", "Male", 37, "017-9900112", "zul@gmail.com", "Businessman", 10000, "Married", "Malaysian")
    };
    
    public static void loadData() {
        System.out.println("[Main] Loading data...");

        File pFile = new File("properties.txt");
        File tFile = new File("tenants.txt");
        
        // Scenario A: File Exists -> Read from File
        if (pFile.exists()) {
            try {
                Scanner sc = new Scanner(pFile);
                while (sc.hasNextLine()) {
                    String[] data = sc.nextLine().split(";");
                    if (data.length >= 7) {
                        properties[pCount] = new Property(data[0], data[1], data[2], 
                                Double.parseDouble(data[3]), data[4], 
                                Integer.parseInt(data[5]), Integer.parseInt(data[6]));
                        pCount++;
                    }
                }
                sc.close();
                System.out.println("-> Loaded " + pCount + " properties from file.");
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } 
        // Scenario B: No File -> Load Hardcoded Backup
        else {
            System.out.println("-> File not found.");
        }
        
        if (tFile.exists()) {
            try {
                Scanner sc = new Scanner(tFile);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.trim().isEmpty()) continue;

                    String[] data = line.split(";");
                    if (data.length >= 10) {
                        tenants[tCount] = new Tenant(
                            data[0], data[1], data[2], Integer.parseInt(data[3]), 
                            data[4], data[5], data[6], Double.parseDouble(data[7]), 
                            data[8], data[9]
                        );
                        tCount++;
                    }
                }
                sc.close();
                System.out.println("-> Loaded " + tCount + " tenants from file.");
            } catch (Exception e) {
                System.out.println("Error reading tenants.txt: " + e.getMessage());
            }
        
        }
        else{
            System.out.println("-> File not found. Loading backup data...");
            }
        }


        // --- METHOD 2: SAVE DATA ---
        public static void saveData() {
            System.out.println("[Main] Saving data to 'properties.txt'...");
            try {
                FileWriter writer = new FileWriter("properties.txt");
                for (int i = 0; i < pCount; i++) {
                    writer.write(properties[i].toFileString() + "\n");
                }
                writer.close();
                System.out.println("-> Save successful!");
            } catch (IOException e) {
                System.out.println("Error saving: " + e.getMessage());
            }
        }
    }
