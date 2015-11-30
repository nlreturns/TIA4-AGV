
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
        //int boombox = 4;
        int ultrasoonInput = 6;
        int ultrasoonOutput = 7;
        int rightSensor = 8;
        int leftSensor = 9;
        int infrared = 13;
        int leftMotor = 14;
        int rightMotor = 15;
        
        CollisionDetection collision = new CollisionDetection(ultrasoonInput, ultrasoonOutput, leftSensor, rightSensor);
        Drive drive = new Drive(leftMotor, rightMotor);
        Remote remote = new Remote(infrared);
        
        
        System.out.println("Uitlezen..");
      
        while(true){
            
            int knop = remote.getKnop();
            
            // remote control
            //remote.getKnop();
            
            if(knop != 0){
                
                switch (knop) {
                    // afstandsbediening ch+
                    case 144:  drive.slowForward();
                                break;
                    // afstandsbediening ch-
                    case 2192:  drive.slowBackward();
                                break;
                    // vol+
                    case 1168:  drive.draaiL45();
                                break;
                    // vol-
                    case 3216:  drive.draaiR45();
                                break;
                    // power button
                    case 2704:  drive.stop();
                                break;
                    // 4
                    case 3088:  drive.draaiR90();
                                break;
                    // 6
                    case 2576:  drive.draaiL90();
                                break;
                    // 7
                    case 1552:  drive.draaiR180();
                                break;
                    // 9
                    case 272:   drive.draaiL180();
                                break;
                    
                    default:    System.out.println(knop);
                                break;
                }
            }
            
            
            
            // ALL COLLISION CODE
            //Antenna code
            if(collision.antenna.hitLeft()){   
                drive.fastBrake();
                System.out.println("Left hit");
                
                //BoeBot.freqOut(boombox, 1000, 100);
                //BoeBot.freqOut(boombox, 2000, 100);
                
                drive.draaiR90();
                
            }
            if(collision.antenna.hitRight()){
                drive.fastBrake();
                System.out.println("Right hit");
                
                //BoeBot.freqOut(boombox, 1000, 100);
                //BoeBot.freqOut(boombox, 2000, 100);
                
                drive.draaiL90();
                
            }
            
            //Ultrasone code
            if(collision.ultrasoon.tooClose()){ 
               
                drive.stop();

            }else{
                //drive.forward();
            }
            
            BoeBot.wait(1);
    
        }
    }
}
