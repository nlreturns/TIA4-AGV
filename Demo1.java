
/**
 * Write a description of class Demo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public class Demo1
{
    public static void main (String[] args){
        
        // set all the pins
        int ultrasoonInput = 6;
        int ultrasoonOutput = 7;
        int rightSensor = 8;
        int leftSensor = 9;
        int infrared = 13;
        int leftMotor = 14;
        int rightMotor = 15;
        
        CollisionDetection collision = new CollisionDetection(ultrasoonInput, ultrasoonOutput, leftSensor, rightSensor);
        Drive drive = new Drive(leftMotor, rightMotor);
        
        
        System.out.println("Uitlezen..");
      
        while(true){
            
            
            // ALL COLLISION CODE
            //Antenna code
            if(collision.antenna.hitLeft()){
                System.out.println("Left hit");
            }
            if(collision.antenna.hitRight()){
                System.out.println("Right hit");
            }
            
            //Ultrasone code
            if(collision.ultrasoon.tooClose()){
                System.out.println("Object too close");
            }
            
            
            
            
            BoeBot.wait(500);
    
        }
    }
}
