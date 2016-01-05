import TI.*;

public final class Drive{

    static Motor motor;
    public int currentSpeedLeft = 1500, currentSpeedRight = 1500;
    static Notification led;

    public Drive(int left, int right){

        motor = new Motor(left, right);
        led = new Notification();

    }

    public void forward(int speed1, int speed2){
        currentSpeedLeft = speed1;
        currentSpeedRight = speed2;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);

    }
    
    public void rotateLeft(int speed1, int speed2){
        currentSpeedLeft = speed1;
        currentSpeedRight = speed2;
        motor.setLeft(currentSpeedLeft);
        motor.setRight(currentSpeedRight);
        
    }

    public void rotateRight(int speed1, int speed2){
        currentSpeedLeft = speed1;
        currentSpeedRight = speed2;
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
        led.backwards();
        
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
        led.forward();
        
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

    public void draaiL45(){
        led.turnLeft();
        
        motor.setLeft (1550);
        motor.setRight (1550);
        BoeBot.wait (370);
        motor.setLeft (1500);
        motor.setRight (1500);

        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        
        led.reset();
    }

    public void draaiL90(){
        led.turnLeft();
        
        motor.setLeft (1550);
        motor.setRight (1550);
        BoeBot.wait (500);
        motor.setLeft (1500);
        motor.setRight (1500);

        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        
        led.reset();
    }

    public void draaiL180(){
        led.turnLeft();

        motor.setLeft (1550);
        motor.setRight (1550);
        BoeBot.wait (1480);
        motor.setLeft (1500);
        motor.setRight (1500);

        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        
        led.reset();
    }

    public void draaiR45(){
        led.turnRight();
        
        motor.setLeft (1450);
        motor.setRight (1450);
        BoeBot.wait (370);
        motor.setLeft (1500);
        motor.setRight (1500);

        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        
        led.reset();
    }

    public void draaiR90(){
        led.turnRight();
        
        motor.setLeft (1450);
        motor.setRight (1450);
        BoeBot.wait (500);
        motor.setLeft (1500);
        motor.setRight (1500);

        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;
        
        led.reset();
    }

    public void draaiR180(){
        led.turnRight();

        motor.setLeft (1450);
        motor.setRight (1450);
        BoeBot.wait (1480);
        motor.setLeft (1500);
        motor.setRight (1500);

        currentSpeedLeft = 1500;
        currentSpeedRight = 1500;

        led.reset();
    }
}
