/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class propertyManagerMachine {
        public class propertyList {
        private int[] property = new int[100]; 
        private int count = 0;
        public void addProperties(int[] Properties) {
            System.out.println("[System] Adding property...");
            if(count < Properties.length) {
                Properties[count] = count + 1; 
                count++;
                System.out.println("[System] Property added successfully. Total properties: " + count);
            } else {
                System.out.println("[System] Property list is full. Cannot add more properties.");
            }
        }
    }

}
