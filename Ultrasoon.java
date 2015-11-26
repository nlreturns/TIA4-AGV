
/**
 * Write a description of class Antenna here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public class Ultrasoon{
    
    public int pinInput, pinOutput;
    
    public Ultrasoon(int input, int output){
        this.pinInput = input;
        this.pinOutput = output;
    }
    
    public int getPulse(){
        return BoeBot.pulseIn(pinOutput, true, 10000);
    }
    
    public boolean tooClose(int pulse){
        if(pulse <= 700){
            return true;
        }else{
            return false;
        }
    }
    
}
