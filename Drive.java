
/**
 * Write a description of class Drive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public final class Drive{
    
    static Motor motor;
    public int currentSpeedLeft = 0, currentSpeedRight = 0;
    
    public Drive(int left, int right){
        
        motor = new Motor(left, right);
        
    }
    
    public void forward(){
        
        currentSpeedLeft = 1700;
        currentSpeedRight = 1300;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    public void backward(){
        
        currentSpeedLeft = 1300;
        currentSpeedRight = 1700;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    public void fastBrake(){
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    public void slowForward(){
        
        for(int i = 0; i < 100; i++) {
            currentSpeedLeft++;
            currentSpeedRight--;
            motor.setLeft(currentSpeedLeft);
            motor.setRight(currentSpeedRight);
            BoeBot.wait(10);
        }
        
    }
    
    public void slowBackward(){
        
        for(int i = 0; i < 100; i++) {
            currentSpeedLeft--;
            currentSpeedRight++;
            motor.setLeft(currentSpeedLeft);
            motor.setRight(currentSpeedRight);
            BoeBot.wait(10);
        }
        
    }
    
    public void slowBreak(){
        
        if((currentSpeedLeft > 1500) && (currentSpeedRight < 1500)){
            for(int i = 0; i < (currentSpeedLeft - 1500); i++){
                currentSpeedLeft--;
                currentSpeedRight++;
                motor.setLeft(currentSpeedLeft);
                motor.setRight(currentSpeedRight);
                BoeBot.wait(10);
            }
        } else {
            for(int i = 0; i < (currentSpeedRight - 1500); i++){
                currentSpeedLeft++;
                currentSpeedRight--;
                motor.setLeft(currentSpeedLeft);
                motor.setRight(currentSpeedRight);
                BoeBot.wait(10);
            }
        }
        
    }
    
    public void rotateRight(){
        
        motor.setLeft(1200);
        motor.setRight(1200);
        
    }
    
    public void rotateLeft(){
        
        motor.setLeft(1700);
        motor.setRight(1700);
        
    }
}
