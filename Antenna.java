
/**
 * Write a description of class Antenna here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public class Antenna{
    
    public int leftAntenna, rightAntenna;
    
    public Antenna(int left, int right){
        this.leftAntenna = left;
        this.rightAntenna = right;
    }
    
    public boolean hitLeft(){
        if(BoeBot.digitalRead(leftAntenna) == false)
            return true;
        
        return false;
    }
    
    public boolean hitRight(){
        if(BoeBot.digitalRead(rightAntenna) == false)
            return true;
        
        return false;
    }
    
}
