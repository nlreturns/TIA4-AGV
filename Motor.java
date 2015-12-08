
/**
 * Write a description of class Motor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public class Motor
{
    
    public Servo left;
    public Servo right;
    
    /**
     * Constructor for objects of class Motor
     */
    public Motor(int left, int right){
        this.left = new Servo(left);
        this.right = new Servo(right);
    }
    
    public void setLeft(int speed){
        left.update(speed);
    }
    
    public void setRight(int speed){
        right.update(speed);
    }
    
}
