// Groen = 2872
//  Record = 2960

import TI.*;

public class Demo2
{
    
    private int raceState = 4;
    private int lineState = 3;
    private int remoteState = 2;
    private int idleState = 1;
    private int state = 1;
    
    public static void main (String[] args){
        
        // set all the pins
        //int boombox = 4;
        int ultrasoonInput = 6;
        int ultrasoonOutput = 7;
        int rightSensor = 8;
        int leftSensor = 9;
        int infrared = 13;
        int leftMotor = 14;
        int rightMotor = 15;
        
        CollisionDetection collision = new CollisionDetection(ultrasoonInput, ultrasoonOutput, leftSensor, rightSensor);
        Drive drive = new Drive(leftMotor, rightMotor);
        Remote remote = new Remote(infrared);
        Linedetection line = new Linedetection();
      
        while(true){
            
            //Case handeling
            switch(state) {
                case 1: idleState();
                    break;
                    
                case 2: lineState();
                    break;
                
                case 3: remoteState();
                    break;
                    
                case 4: raceState();
                    break;
            }
            
            int knop = remote.getKnop();
         
            switch(knop) {
                // Rood
                case 824: state = idleState;
                    break;
                // Geel
                case 848: state = remoteState;
                    break;
                // Blauw
                case 3896: state = lineState;
                    break;
                // Grijs
                case 4048: state = raceState;
                    break;
            }
            
            BoeBot.wait(1);
    
        }
    }
    
    public static void idleState()
    {
        
    }
    
    public static void lineState()
    {
        line.lineRider();
        
        //Collision handeling
        if((collision.ultrasoon.tooClose()) || (collision.antenna.hitRight()) || (collision.antenna.hitLeft())){ 
            drive.draaiL180();
        }
        
        if(line.detectCross){
            drive.stop();
            
            threat.sleep(2000); 
        }
    }
    
    public static void remoteState()
    {
        int knop = remote.getKnop();
        
        //Collision handeling
        if((collision.ultrasoon.tooClose()) || (collision.antenna.hitRight()) || (collision.antenna.hitLeft())){ 
            drive.stop();
        }
        
        if(knop != 0){
            switch (knop) {
                // afstandsbediening ch+
                case 144:  drive.slowForward();
                            break;
                // afstandsbediening ch-
                case 2192:  drive.slowBackward();
                            break;
                // vol+
                case 1168:  drive.draaiL45();
                            break;
                // vol-
                case 3216:  drive.draaiR45();
                            break;
                // power button
                case 2704:  drive.stop();
                            break;
                // 4
                case 3088:  drive.draaiR90();
                            break;
                // 6
                case 2576:  drive.draaiL90();
                            break;
                // 7
                case 1552:  drive.draaiR180();
                            break;
                // 9
                case 272:   drive.draaiL180();
                            break;
                
                default:    System.out.println(knop);
                            break;
            }
        }
    }
}
