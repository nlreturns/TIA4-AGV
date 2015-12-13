
/**
 * Write a description of class Antenna here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import TI.*;

public class Ultrasoon{

    public int pinInput, pinOutput;

    public Ultrasoon(int input, int output){
        this.pinInput = input;
        this.pinOutput = output;
    }

    public int getPulse(){

        BoeBot.digitalWrite(pinInput,true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(pinInput,false);

        return BoeBot.pulseIn(pinOutput, true, 10000);
    }

    public boolean tooClose(){
        int pulse = getPulse();

        if(pulse <= 2100 && pulse >= 0){
            BoeBot.rgbSet(0, 255,0,0);
            BoeBot.rgbSet(1, 255,0,0);
            BoeBot.rgbSet(2, 255,0,0);
            BoeBot.rgbShow();
            return true;
        }else{
            BoeBot.rgbSet(0, 0,0,0);
            BoeBot.rgbSet(1, 0,0,0);
            BoeBot.rgbSet(2, 0,0,0);
            BoeBot.rgbShow();
            return false;
        }
    }

}
