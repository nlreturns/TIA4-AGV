/**
 * 
 * BoeBot Set-up DEMO1
 * ~~Driving~~
 * 
 * -HARDWARE SETUP-
 * GPIO 0
 * GPIO 1
 * GPIO 2
 * GPIO 3
 * GPIO 4
 * GPIO 5
 * GPIO 6 - Write Supersone
 * GPIO 7 - Read Supersone
 * GPIO 8 - Right sensor
 * GPIO 9 - Left sensor
 * GPIO 13 - Infrared sensor
 * GPIO 14- Servo motor 1
 * GPIO 15- Servo motor 2
 * 
 */
import TI.*;

public class Test
{

    public static void main (String[] args)
    {
        System.out.println("Uitlezen..");
        Servo s1 = new Servo(14);
        Servo s2 = new Servo(15);
        
      
        while(true){
           
           int codes = 0;
           int pulseL = BoeBot.pulseIn(13,false,6000);
           if(pulseL > 2000){
               int lengtes[] = new int[12];
               int h[] = new int[12];
               for(int i = 0; i < 12; i++)
                   lengtes [i] = BoeBot.pulseIn(13,false,20000);
               
               for(int i = 0; i < 12; i++){
                   if(lengtes [i] >= 1000){
                       h[i] = +1;
                   }else{
                       h[i] = +0;
                   }
                   System.out.println(h[i]);
                  
               }
           
               for(int i = 0; i < 7; i++ ){
                   codes += h[i]<<7-i;
               }
               
               System.out.println(codes);
           }
           
           System.out.println("start");
          
           BoeBot.digitalWrite(6,true);
           BoeBot.wait(1);
           BoeBot.digitalWrite(6,false);
           
           int pulse = BoeBot.pulseIn(7,true, 10000);
           System.out.println("pulse:" + pulse);
           BoeBot.wait(50);
           
           if(codes == 8){
               s1.update(1700);
               s2.update(1200);
           }
           
           if(codes == 136){
               s1.update(1200);
               s2.update(1700);
           }
           
           if(codes == 168){
               s1.update(1500);
               s2.update(1500);
           }
           
           if(codes == 72){
               s1.update(1200);
               s2.update(1200);
           }
            
           if(codes == 200){
               s1.update(1700);
               s2.update(1700);
           }
           
           if(pulse < 700){
               s1.update(1500);
               s2.update(1500);
           }
           
           BoeBot.wait(1);
           
           //left
           if (BoeBot.digitalRead(8)== false){
               s1.update(1700);
               s2.update(1200);
               BoeBot.wait(500);
               System.out.println("HOMOO");
               s1.update(1200);
               s2.update(1700);
           }
           
           // right
           if (BoeBot.digitalRead(9)== false){
               s1.update(1700);
               s2.update(1700);
               BoeBot.wait(500);
               System.out.println("PIEMOL");
               s1.update(1200);
               s2.update(1200);
           }
    
        }
    }
}