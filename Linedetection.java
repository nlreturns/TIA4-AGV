
import TI.*;

public class Linedetection
{
    
    private int speedLeft;
    private int speedRight;
    static Drive drive;

    public Linedetection()
    {
        drive = new Drive(14, 15);
    }

    public static void lineRider()
    {       
        
        
        if(BoeBot.analogRead(0) > 700){
           drive.rotateLeft(1500,1700);
          
            //naar rechts
        }
        else{
            if (BoeBot.analogRead(2) > 700){
                drive.rotateRight(1300,1500);
            }
            else{
                if (BoeBot.analogRead(1)  > 700){
                 drive.rotateLeft(1400, 1600);
                    //halve snelheid vooruit
                }
                else  {
                  drive.rotateLeft(1400, 1600);
                }
            }
        }
        
    }
    
    public static boolean detectCross()
    {
        if((BoeBot.analogRead(0) > 700) && (BoeBot.analogRead(1) > 700) && (BoeBot.analogRead(2) > 700)) {
            return true;
        } else {
            return false;
        }
    }
}