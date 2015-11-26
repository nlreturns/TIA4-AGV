
/**
 * Write a description of class Drive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public final class Drive{
    
    static Motor motor;
    private int currentSpeedLeft = 0, currentSpeedRight = 0;
    
    public Drive(int left, int right){
        
        motor = new Motor(left, right);
        
    }
    
    static void forward(){
        
        currentSpeedLeft = 1700;
        currentSpeedRight = 1300;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    static void backward(){
        
        currentSpeedLeft = 1300;
        currentSpeedRight = 1700;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    static void fastBrake(){
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    static void slowForward(){
        
        for(int i = 0; i < 200; i++) {
            currentSpeedLeft++;
            currentSpeedRight--;
            motor.setLeft(currentSpeedLeft);
            motor.setRight(currentSpeedRight);
            BoeBot.wait(10);
        }
        
    }
    
    static void slowBackward(){
        
        for(int i = 0; i < 200; i++) {
            currentSpeedLeft--;
            currentSpeedRight++;
            motor.setLeft(currentSpeedLeft);
            motor.setRight(currentSpeedRight);
            BoeBot.wait(10);
        }
        
    }
    
    static void slowBreak(){
        
        if((currentSpeedLeft > 1500) && (currentSpeedRight < 1500)){
            for(int i = 0; i < 200; i++){
                currentSpeedLeft--;
                currentSpeedRight++;
                motor.setLeft(currentSpeedLeft);
                motor.setRight(currentSpeedRight);
                BoeBot.wait(10);
            }
        } else {
            for(int i = 0; i < 200; i++){
                currentSpeedLeft++;
                currentSpeedRight--;
                motor.setLeft(currentSpeedLeft);
                motor.setRight(currentSpeedRight);
                BoeBot.wait(10);
            }
        }
        
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
