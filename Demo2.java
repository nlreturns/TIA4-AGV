// Groen = 2872
// Record = 2960

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

    static Linedetection line = new Linedetection();
    static CollisionDetection collision = new CollisionDetection(ultrasoonInput, ultrasoonOutput, leftSensor, rightSensor);
    static Drive drive = new Drive(leftMotor, rightMotor);
    static Remote remote = new Remote(infrared);
    static Bluetooth bluetooth = new Bluetooth();

    public static void main (String[] args){

        int state = 1;

        while(true){

            //Check your current state and execute code
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
                case 824: state = 1;
                break;
                // Geel
                case 848: state = 3;
                break;
                // Blauw
                case 3896: state = 2;
                break;
                // Grijs
                case 4048: state = 4;
                break;
            }

            BoeBot.wait(1);

        }
    }

    public static void idleState(){

    }

    public static void lineState(){
        line.lineRider();

        //Collision handeling
        if((collision.ultrasoon.tooClose()) || (collision.antenna.hitRight()) || (collision.antenna.hitLeft())){ 
            drive.draaiL180();
        }

        if(line.detectCross()){
            try{
                drive.stop();

                Thread.sleep(2000); 
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }

    public static void remoteState(){
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

    public void bluetoothState(){

        bluetoothCalls(bluetooth.getInput());

    }

    public void bluetoothCalls(int data){

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

    public static void raceState(){

    }
}
