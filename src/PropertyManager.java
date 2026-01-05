/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author Ahmad
 */
public class PropertyManager {
    Property[] storage = new Property[100];
    int count = 0;
    Scanner input = new Scanner(System.in);
    
    public void addProperty(Property newProperty){
        if(count < 100)
        {
            storage[count] = newProperty;
            count++;
        }
        
        else
        {
            System.out.println("An Error has occured!");
        }
}
    
    public void deleteProperty() {
        System.out.print("Enter your property id: ");
        String id = input.nextLine(); //the property that the user wants to delete
        
        
        for(int i = 0; i < count ; i++) //the loop depends on count, so that it will loop only based
                                        //on how many properties were filled
        {
            String findID = storage[i].getID(); //
            
            if(findID.equals(id))
            {
                storage[i] = storage[count - 1];
                storage[count - 1] = null;
                count--;
                
                System.out.println("Property " + id + " has been deleted.");
                return;
                
            }
        }
        System.out.println("Property ID not found.");
}
    
}
