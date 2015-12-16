import TI.*;

public class Demo2
{
    static int ultrasoonInput = 6;
    static int ultrasoonOutput = 7;
    static int rightSensor = 8;
    static int leftSensor = 9;
    static int infrared = 13;
    static int leftMotor = 14;
    static int rightMotor = 15;
    static int state = 1;
    static int stateOld;
    
    static boolean driveLine = false;

    static Linedetection line = new Linedetection();
    static CollisionDetection collision = new CollisionDetection(ultrasoonInput, ultrasoonOutput, leftSensor, rightSensor);
    static Drive drive = new Drive(leftMotor, rightMotor);
    static Remote remote = new Remote(infrared);
    static Bluetooth bluetooth = new Bluetooth();
    static Notification led = new Notification();

    public static void main (String[] args){
        
        while(true){
        
                    remote();        
            
                    //Check your current state and execute code
                    if(state != stateOld) {
                        drive.fastBrake();
                        switch(state) {
                            case 1: led.idleState();
                                break;
            
                            case 2: led.lineState();
                                break;
            
                            case 3: led.remoteState();
                                break;
            
                            case 5: led.raceState();
                                break;
                        }
                    }
                    
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
                    
                    stateOld = state;
                    
                    //If standing still, reset LEDs
                    if((drive.currentSpeedLeft == 1500) && (drive.currentSpeedRight == 1500)){
                        led.reset();
                    }
                    
                    BoeBot.wait(1);
                    
                }
    }


    public static void idleState(){
        led.idleState();
        drive.fastBrake();
        remote();
    }

    public static void lineState(){
        led.lineState();
        remote();
        
        bluetoothCalls(bluetooth.getInput());
        
        if(driveLine)
            line.lineRider();

        //Collision handeling
        if((collision.antenna.hitRight()) || (collision.antenna.hitLeft())){ 
            led.bounce();
            drive.stop();
            state = 1;
        }
        if(collision.ultrasoon.tooClose()){
            led.detect();
            drive.stop();
            state = 1;
        }
        
        //Cross detection
        if(line.detectCross()){
            drive.fastBrake();
            led.crossDetection();
            BoeBot.wait(3000); 
            led.reset();
            drive.forward(1450, 1550);
            BoeBot.wait(200);
            drive.forward(1500, 1500);
        }
    }

    public static void remoteState(){
        led.remoteState();
        remote();
        
        int knop = remote.getKnop();

        //Collision handeling
        if((collision.antenna.hitRight()) || (collision.antenna.hitLeft())){ 
            led.bounce();
            drive.fastBrake();
        }
        if(collision.ultrasoon.tooClose()){
            led.detect();
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

    public static void bluetoothCalls(int data){
        switch(data){
            case 32:    drive.fastBrake();
                        driveLine = false;
                break;

            case 97:    drive.rotateLeft(1450,1450);
                break;

            case 100:   drive.rotateRight(1550,1550);
                break;

            case 115:   drive.slowBackward();
                break;

            case 119:   drive.slowForward();
                break;
                
            case 120: driveLine = true;
                break;

            default: break;
        }

    }

    public static void raceState(){
        boolean racen = false;
        
        led.raceState();
        remote();
        
        if(remote.getKnop() == 144)
            race = true;
            
        if(remote.getKnop() == 2192)
            race = false;
        
        if(racen)
            line.raceLineRider();
    }
    
    public static void remote(){
            int knop = remote.getKnop();
          
            switch(knop) {
            // Rood
            case 824: state = 4;
                break;
            // Geel
            case 1848: state = 3;
                break;
            // Blauw
            //case 3896: state = 5;
              //  break;
            // Grijs
            case 4048: state = 1;
                break;
            // Groen
            case 2872: state = 2;
                break;
        }
        
    }
}
