import TI.*;

public class Politiewagen
{
    public static void main(String[] args){
        
        Servo s1 = new Servo(14);
        Servo s2 = new Servo(15);
        
        s1.update(1000);
        s2.update(2000);
        
        while(true){   
        
            BoeBot.digitalWrite(0, true);
            BoeBot.freqOut(3, 1000, 250);
            BoeBot.digitalWrite(0, false);
            BoeBot.digitalWrite(2, true);
            BoeBot.freqOut(3, 2000, 250);
            BoeBot.digitalWrite(2, false);
            
            
        }
    }
}
