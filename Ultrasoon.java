
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

        return BoeBot.pulseIn(pinOutput, true, 100000);
    }

    public boolean tooClose(){
        int pulse = getPulse();

        if(pulse <= 1000 && pulse >= 0){
            return true;
        }else{
            return false;
        }
    }

}
