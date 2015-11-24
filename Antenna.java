
/**
 * Write a description of class Antenna here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public class Antenna{
    
    public int pin;
    
    public Antenna(int pin){
        this.pin = pin;
    }
    
    public int getPulse(){
        return BoeBot.pulseIn(pin, true, 10000);
    }
    
    public boolean tooClose(int pulse){
        if(pulse <= 700){
            return true;
        }else{
            return false;
        }
    }
    
}
