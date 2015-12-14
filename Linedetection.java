import TI.*;

public class Linedetection
{

    static Drive drive;

    public Linedetection()
    {
        drive = new Drive(14, 15);
    }

    public static void lineRider()
    {
        if(BoeBot.analogRead(0) > 700){
            drive.rotateLeft(1550, 1550);
        } else {    
            if(BoeBot.analogRead(2) > 700){
                drive.rotateRight(1450, 1450);
            } else {
                drive.forward(1450, 1550);
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
