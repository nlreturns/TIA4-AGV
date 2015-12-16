import java.awt.*;
import TI.*;
public class LED
{
    public LED(){

    }
    public static void ledLF(Color c){
        BoeBot.rgbSet(0, c);
        BoeBot.rgbShow();

    }

    public void ledMF(Color c){
        BoeBot.rgbSet(1, c);
        BoeBot.rgbShow();

    }

    public void ledRF(Color c){
        BoeBot.rgbSet(2, c);
        BoeBot.rgbShow();

    }

    public void ledLB(Color c){
        BoeBot.rgbSet(3, c);
        BoeBot.rgbShow();

    }

    public void ledMB(Color c){
        BoeBot.rgbSet(4, c);
        BoeBot.rgbShow();

    }

    public void ledRB(Color c){
        BoeBot.rgbSet(5, c);
        BoeBot.rgbShow();

    }

    
}