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
     public void draaiR45()
  {
            motor.setLeft (1550);
            motor.setRight (1550);
            BoeBot.wait (370);
            motor.setLeft (1500);
            motor.setRight (1500);
            BoeBot.wait (370);
  }
  public void draaiR90()
  {
            motor.setLeft (1550);
            motor.setRight (1550);
            BoeBot.wait (740);
            motor.setLeft (1500);
            motor.setRight (1500);
            BoeBot.wait (740);
    }
  public void draaiR180()
  {
            motor.setLeft (1550);
            motor.setRight (1550);
            BoeBot.wait (1480);
            motor.setLeft (1500);
            motor.setRight (1500);
            BoeBot.wait (1480);
    }
     public void draaiL45()
  {
            motor.setLeft (1550);
            motor.setRight (1550);
            BoeBot.wait (370);
            motor.setLeft (1500);
            motor.setRight (1500);
            BoeBot.wait (370);
  }
  public void draaiL90()
  {
            motor.setLeft (1550);
            motor.setRight (1550);
            BoeBot.wait (740);
            motor.setLeft (1500);
            motor.setRight (1500);
            BoeBot.wait (740);
    }
  public void draaiL180()
  {
            motor.setLeft (1550);
            motor.setRight (1550);
            BoeBot.wait (1480);
            motor.setLeft (1500);
            motor.setRight (1500);
            BoeBot.wait (1480);
    }

}
