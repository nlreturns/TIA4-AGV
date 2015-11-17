/**
 * Policecar is code to control the BoeBot in
 * a similar way as a policecar including the
 * sirensound, sirencolor and movement
 * 
 * This code requires the following hardware
 * setup;
 * GPIO 0 - Red LED3
 * GPIO 1 - Green LED3
 * GPIO 2 - Blue LED3
 * 
 * GPIO 3 - Siren
 * 
 * GPIO 14 - Right servo motor
 * GPIO 15 - Left servo motor
 * 
 * @public
 * 
 * @author TIA4 <enter group email here>
 * @version 1.0 by
 *      Jan-Willem Dooms
 *      Rico Boonne
 */

import TI.*;

public class Policecar
{
    public static void main(String[] args){
        
        // create the motor classes
        Servo right_wheel = new Servo(14);
        Servo left_wheel = new Servo(15);
        
        // set speed to max
        right_wheel.update(1000);
        left_wheel.update(2000);
        
        // loop of code
        while(true){   
        
            // set 3LED(red) on
            BoeBot.digitalWrite(0, true);
            // siren sound (also used as delay)
            BoeBot.freqOut(3, 1000, 250);
            // set 3LED(red) off
            BoeBot.digitalWrite(0, false);
            // set 3LED(blue) on
            BoeBot.digitalWrite(2, true);
            // siren sound (also used as delay)
            BoeBot.freqOut(3, 2000, 250);
            // set 3LED(blue) off
            BoeBot.digitalWrite(2, false);
            
            
        }
    }
}
