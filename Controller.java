import TI.*;
public class Controller
{
  
    static int signal;
   
    public static void main (String[] args)
    {
        System.out.println("luisteren");
        while(true)
        {
            int pulseLen = BoeBot.pulseIn(13, false, 6000);
    
            
            if(pulseLen > 2000)
            {
                int lengtes[] = new int[12];
                for(int i = 0; i < 12; i++){
                    lengtes[i] = BoeBot.pulseIn(13, false, 2000);
                }
                
                for(int i = 0; i < 12; i++){
                    
                    int j = 11 - i;
                    
                    // loop if higher than 1000
                    // 1 << i
                    if(lengtes[j] > 1000){
                        signal = signal | 1<<i;
                    }
                }
                
                System.out.println("Signal = " + signal);
                
                getKnop();
                signal = 0;
            }
            BoeBot.wait(1);
        }
    }     
    
    public static int getKnop()
    {
        return signal;
    }
}