
/**
 * Write a description of class Drive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public final class Drive{
    
    static Motor motor;
    
    public Drive(int left, int right){
        
        motor = new Motor(left, right);
        
    }
    
    static void forward(){
        
        motor.setLeft(1700);
        motor.setRight(1200);
        
    }
    
    static void backward(){
        
        motor.setLeft(1200);
        motor.setRight(1700);
        
    }
    
    static void stop(){
        
        motor.setLeft(1500);
        motor.setRight(1500);
        
    }
    
    static void rotateRight(){
        
        motor.setLeft(1200);
        motor.setRight(1200);
        
    }
    
    static void rotateLeft(){
        
        motor.setLeft(1700);
        motor.setRight(1700);
        
    }
}
