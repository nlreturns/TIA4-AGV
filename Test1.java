import TI.*;
import java.awt.Color;

public class Test1
{

    public static void main (String[] args)
    {
        System.out.println("Uitlezen..");
        Servo s1 = new Servo(14);
        Servo s2 = new Servo(15);
        
      
        while(true){
            
            
            System.out.println(BoeBot.analogRead(0) + " " + BoeBot.analogRead(1) + " " + BoeBot.analogRead(2));
                
            if(BoeBot.analogRead(0) > 700){
                s1.update(1550);
                s2.update(1550);
               
               BoeBot.rgbSet(0, 255, 0, 0);
               BoeBot.rgbSet(5, 255, 0, 0);
               BoeBot.rgbShow();
                
                
            }else{
                 
                if(BoeBot.analogRead(2) > 700){
                    s1.update(1450);
                    s2.update(1450);
                    
                        
                   BoeBot.rgbSet(2, 255, 0, 0);
                   BoeBot.rgbSet(3, 255, 0, 0);
                   BoeBot.rgbShow();
                    
                }else{
                    
                            
                   BoeBot.rgbSet(0, 0,0,0);
                   BoeBot.rgbSet(2, 0,0,0);
                   BoeBot.rgbSet(3, 0,0,0);
                   BoeBot.rgbSet(5, 0,0,0);
                   BoeBot.rgbShow();
                    
                    s1.update(1450);
                    s2.update(1550);
                }
            
            }
        }
    }
} 