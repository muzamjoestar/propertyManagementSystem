/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Tenant {
    
    private String tenantID;
    private String name;
    private String gender;
    private int age;
    private String contactNumber;
    private String email;
    private String occupation;
    private double monthlyIncome;
    private String maritalStatus;
    private String nationality;
    private String propertyID;


    public Tenant(String tenantID, String name, String gender, int age, String contactNumber,
                  String email, String occupation, double monthlyIncome,
                  String maritalStatus, String nationality, String propertyID) {
        this.tenantID = tenantID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.contactNumber = contactNumber;
        this.email = email;
        this.occupation = occupation;
        this.monthlyIncome = monthlyIncome;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.propertyID = propertyID;
    }


    public void printDetails() {
        System.out.println("Tenant ID: " + tenantID);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Email: " + email);
        System.out.println("Occupation: " + occupation);
        System.out.println("Monthly Income: " + monthlyIncome);
        System.out.println("Marital Status: " + maritalStatus);
        System.out.println("Nationality: " + nationality);
        System.out.println("---------------------------");
    }
    public String getTID() { return tenantID; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public String getContact() { return contactNumber; }
    public String getEmail() { return email; }
    public String getOccupation() { return occupation; }
    public double getIncome() { return monthlyIncome; }
    public String getMarital() { return maritalStatus; }
    public String getNationality() { return nationality; }
    public String getPropertyID() { return propertyID; }
    
    public void setPropertyID(String pid){
        this.propertyID = pid; 
    
    }
    public String toFileString() {
        return tenantID + ";" + name + ";" + gender + ";" + age + ";" + contactNumber + ";" + 
               email + ";" + occupation + ";" + monthlyIncome + ";" + maritalStatus + ";" + 
               nationality + ";" + propertyID;
    }
}
