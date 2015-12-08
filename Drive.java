import TI.*;

public final class Drive{
    
    static Motor motor;
    public int currentSpeedLeft = 1500, currentSpeedRight = 1500;
    
    public Drive(int left, int right){
        
        motor = new Motor(left, right);
        this.currentSpeedLeft = left;
        this.currentSpeedRight = right;
        
    }
    
    public void forward(){
        
        currentSpeedLeft = 1300;
        currentSpeedRight = 1700;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    public void backward(){
        
        currentSpeedLeft = 1700;
        currentSpeedRight = 1300;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    public void fastBrake(){
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }
    
    public void slowBackward(){
        
        for(int i = 0; i < 50; i++) {
            if(currentSpeedLeft != 1300){
                currentSpeedLeft--;
                currentSpeedRight++;
                motor.setLeft(currentSpeedLeft);
                motor.setRight(currentSpeedRight);
                BoeBot.wait(10);
            }
        }
        
    }
    
    public void slowForward(){
        
        for(int i = 0; i < 50; i++) {
            if(currentSpeedLeft != 1700){
                currentSpeedLeft++;
                currentSpeedRight--;
                motor.setLeft(currentSpeedLeft);
                motor.setRight(currentSpeedRight);
                BoeBot.wait(10);
            }
        }
        
    }
    
    public void stop(){
        
        if((currentSpeedLeft > 1500) && (currentSpeedRight < 1500)){
            for(int i = 0; i < (currentSpeedLeft - 1500); i++){
                currentSpeedLeft--;
                currentSpeedRight++;
                motor.setLeft(currentSpeedLeft);
                motor.setRight(currentSpeedRight);
                BoeBot.wait(5);
            }
        } else {
            for(int i = 0; i < (currentSpeedRight - 1500); i++){
                currentSpeedLeft++;
                currentSpeedRight--;
                motor.setLeft(currentSpeedLeft);
                motor.setRight(currentSpeedRight);
                BoeBot.wait(5);
            }
        }
        
    }
    
    public void rotateLeft(){
        
        currentSpeedLeft = 1200;
        currentSpeedRight = 1200;
        motor.setLeft(1200);
        motor.setRight(1200);
        
    }
    
    public void rotateRight(){
        
        currentSpeedLeft = 1700;
        currentSpeedRight = 1700;
        motor.setLeft(1700);
        motor.setRight(1700);
    }
    
    public void draaiL45(){
        motor.setLeft (1550);
        motor.setRight (1550);
        BoeBot.wait (370);
        motor.setLeft (1500);
        motor.setRight (1500);
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
    }
    
    public void draaiL90(){
        motor.setLeft (1550);
        motor.setRight (1550);
        BoeBot.wait (740);
        motor.setLeft (1500);
        motor.setRight (1500);
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
    }
    
    public void draaiL180(){
        
        BoeBot.rgbSet(2, 0,0,255);
        BoeBot.rgbSet(3, 0,0,255);
        BoeBot.rgbShow();
    
        motor.setLeft (1550);
        motor.setRight (1550);
        BoeBot.wait (1480);
        motor.setLeft (1500);
        motor.setRight (1500);
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        
        BoeBot.rgbSet(2, 0,0,0);
        BoeBot.rgbSet(3, 0,0,0);
        BoeBot.rgbShow();
    }
    
    public void draaiR45(){
        motor.setLeft (1450);
        motor.setRight (1450);
        BoeBot.wait (370);
        motor.setLeft (1500);
        motor.setRight (1500);
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
    }
    
    public void draaiR90(){
        motor.setLeft (1450);
        motor.setRight (1450);
        BoeBot.wait (740);
        motor.setLeft (1500);
        motor.setRight (1500);
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
    }
    
    public void draaiR180(){
        
        BoeBot.rgbSet(0, 0,0,255);
        BoeBot.rgbSet(5, 0,0,255);
        BoeBot.rgbShow();
    
        motor.setLeft (1450);
        motor.setRight (1450);
        BoeBot.wait (1480);
        motor.setLeft (1500);
        motor.setRight (1500);
        
        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        
        BoeBot.rgbSet(0, 0,0,0);
        BoeBot.rgbSet(5, 0,0,0);
        BoeBot.rgbShow();
        
    }
}
