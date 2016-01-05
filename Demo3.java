import TI.*;
import java.util.*;

public class Demo3 extends Config
{
    static int ultrasoonInput = ULTRASOONINPUT;
    static int ultrasoonOutput = ULTRASOONOUTPUT;
    static int rightSensor = RIGHTSENSOR;
    static int leftSensor = LEFTSENSOR;
    static int infrared = INFRARED;
    static int leftMotor = LEFTMOTOR;
    static int rightMotor = RIGHTMOTOR;
    static int state = STARTINGSTATE;
    static int stateOld;

    static boolean driveLine = false;

    static Linedetection line = new Linedetection();
    static CollisionDetection collision = new CollisionDetection(ultrasoonInput, ultrasoonOutput, leftSensor, rightSensor);
    static Drive drive = new Drive(leftMotor, rightMotor);
    static Remote remote = new Remote(infrared);
    static Bluetooth bluetooth = new Bluetooth();
    static Notification led = new Notification();

    static ArrayList<Integer> route = new ArrayList<Integer>();

    public static void main (String[] args){

        while(true){

            remote();        

            //Check your current state and execute code
            if(state != stateOld) {
                drive.fastBrake();
                switch(state) {
                    case IDLESTATE: led.idleState();
                    break;

                    case LINESTATE: led.lineState();
                    break;

                    case REMOTESTATE: led.remoteState();
                    break;

                    case RACESTATE: led.raceState();
                    break;
                }
            }

            switch(state) {
                case IDLESTATE: idleState();
                break;

                case LINESTATE: lineState();
                break;

                case REMOTESTATE: remoteState();
                break;

                case RACESTATE: raceState();
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
            state = IDLESTATE;
        }
        if(collision.ultrasoon.tooClose()){
            led.detect();
            drive.stop();
            state = IDLESTATE;
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
                case CHPLUS:  drive.slowForward();
                break;
                // afstandsbediening ch-
                case CHMIN:  drive.slowBackward();
                break;
                // vol+
                case VOLPLUS:  drive.draaiL45();
                break;
                // vol-
                case VOLMIN:  drive.draaiR45();
                break;
                // power button
                case POWER:  drive.stop();
                break;
                // 4
                case FOUR:  drive.draaiR90();
                break;
                // 6
                case SIX:  drive.draaiL90();
                break;
                // 7
                case SEVEN:  drive.draaiR180();
                break;
                // 9
                case NINE:   drive.draaiL180();
                break;

                default:    System.out.println(knop);
                break;
            }
        }
    }

    public static void bluetoothCalls(int data){

        switch(data){
            // space
            case SPACE:    drive.fastBrake();
            driveLine = false;
            break;

            // a
            case ROTATELEFT:    drive.rotateLeft(1450,1450);
            break;

            // d
            case ROTATERIGHT:   drive.rotateRight(1550,1550);
            break;

            // s
            case SLOWBACKWARD:   drive.slowBackward();
            break;

            // w
            case SLOWFORWARD:   drive.slowForward();
            break;

            // x
            case ACTIVATELINERIDER: driveLine = true;
            break;

            // y vooruit
            case RECHTDOOR: route.add(RECHTDOOR);
            break;

            // z rechts
            case RECHTS: route.add(RECHTS);
            break;

            // { links
            case LINKS: route.add(LINKS);
            break;

            // | stop
            case STOP: 
            for(int i = 0; i < route.size(); i++){
                route.set(i, 0);
            }
            break;

            // } start
            case START: 
            if(route.get(0) != 0){
                for(int x = 0; x < route.size(); x++){
                    while(!line.detectCross()){
                        line.lineRider();
                        if(collision.ultrasoon.tooClose()){
                            drive.draaiL180();
                            break;
                        }
                    }
                    if(route.get(x) == LINKS)
                        drive.draaiL90();
                    if(route.get(x) == RECHTS)
                        drive.draaiR90();   
                    if(route.get(x) == RECHTDOOR){
                        line.lineRider();
                    }
                }   
            }
            break;

            default: break;
        }

    }

    public static void raceState(){
        led.raceState();
        remote();
    }

    public static void remote(){
        int knop = remote.getKnop();

        switch(knop) {
            // Rood
            case RED: state = RACESTATE;
            break;
            // Geel
            case YELLOW: state = REMOTESTATE;
            break;
            // Blauw
            //case 3896: state = 5;
            //  break;
            // Grijs
            case GRAY: state = IDLESTATE;
            break;
            // Groen
            case GREEN: state = LINESTATE;
            break;
        }

    }
}
