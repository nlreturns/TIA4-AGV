import TI.*;
public class Remote
{
    public int pin;

    public Remote(int pin){
        this.pin = pin;
    }

    public int getKnop(){

        int pulse = BoeBot.pulseIn(this.pin, false, 6000);
        int signal = 0;

        if(pulse > 2000){
            int lengtes[] = new int[12];

            for(int i = 0; i < 12; i++)
                lengtes[i] = BoeBot.pulseIn(this.pin, false, 2000);

            for(int i = 0; i < 12; i++){
                int j = 11 - i;
                // loop if higher than 1000
                // 1 << i
                if(lengtes[j] > 1000)
                    signal = signal | 1<<i;

            }

            return signal;
        }

        return signal;
    }
}