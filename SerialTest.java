/**
import TI.*;

public class SerialTest
{
    
    static Drive drive = new Drive(14,15);
    
    public static void main(String[] args)
    {
        SerialConnection conn = new SerialConnection(115200);
        
        while(true)
        {
            if(conn.available() > 0)
            {
                int data = conn.readByte();
                conn.writeByte(data);
                System.out.println(data);
                calls(data);
            }
            
            BoeBot.wait(10);
        }
    }
    
    public static void calls(int data){
        
        switch(data){
            case 32:    drive.stop();
                        break;
            
            case 97:    drive.rotateLeft();
                        break;
            
            case 100:   drive.rotateRight();
                        break;
            
            case 115:   drive.slowBackward();
                        break;
            
            case 119:   drive.slowForward();
                        break;
                    

            default: break;
            
        }
        
        
    }
   
        
}
*/