import TI.*;

public class Linedetection
{

    static Motor motor;

    public Linedetection()
    {
        motor = new Motor(14, 15);
    }

    public static void lineRider()
    {
        if(BoeBot.analogRead(0) > 700){
            motor.setLeft(1550);
            motor.setRight(1550);
        } else {    
            if(BoeBot.analogRead(2) > 700){
                motor.setLeft(1450);
                motor.setRight(1450);
            } else {
                motor.setLeft(1450);
                motor.setRight(1550);
            }
        }
    }

    public static boolean detectCross()
    {
        if((BoeBot.analogRead(0) > 700) && (BoeBot.analogRead(0) > 700) && (BoeBot.analogRead(0) > 700)) {
            return true;
        } else {
            return false;
        }
    }
}
