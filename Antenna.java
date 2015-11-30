
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
    
    /**
     * Function hitLeft()
     * 
     * returns true if an object has been hit
     * with the left antenna
     */
    public boolean hitLeft(){
        if(BoeBot.digitalRead(leftAntenna) == false){
            BoeBot.rgbSet(0, 255,0,0);
            BoeBot.rgbSet(5, 255,0,0);
            BoeBot.rgbShow();
            return true;
        }
        
        BoeBot.rgbSet(0, 0,0,0);
        BoeBot.rgbSet(5, 0,0,0);
        BoeBot.rgbShow();
        return false;
    }
    
    /**
     * Function hitRight()
     * 
     * returns true if an object has been hit
     * with the right antenna
     */
    public boolean hitRight(){
        if(BoeBot.digitalRead(rightAntenna) == false){
            BoeBot.rgbSet(2, 255,0,0);
            BoeBot.rgbSet(3, 255,0,0);
            BoeBot.rgbShow();
            return true;
        }
        
        BoeBot.rgbSet(2, 0,0,0);
        BoeBot.rgbSet(3, 0,0,0);
        BoeBot.rgbShow();
        return false;
    }
    
}
