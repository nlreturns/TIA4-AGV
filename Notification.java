import java.awt.*;
import TI.*;
public class Notification
{
    private LED led;

    public Notification()
    {
        led = new LED();
    }

    public void forward()
    {
        led.ledLF(Color.blue);
        led.ledMF(Color.blue);
        led.ledRF(Color.blue);
    }

    public void backwards()
    {
        led.ledLF(Color.blue);
        led.ledMF(Color.blue);
        led.ledRF(Color.blue);
    }

    public void TurnLeft()
    {
        led.ledLF(Color.blue);
        led.ledLB(Color.blue);
    }

    public void TurnRight()
    {
        led.ledRB(Color.blue);
        led.ledRF(Color.blue);
    }

    public void bounce()
    {
        led.ledLF(Color.red);
        led.ledMF(Color.red);
        led.ledRF(Color.red);
    }

    public void detect()
    {
        led.ledLF(Color.red);
        led.ledMF(Color.red);
        led.ledRF(Color.red);
    }

    public void reset()
    {
        led.ledLF(Color.black);
        led.ledMF(Color.black);
        led.ledRF(Color.black);
    }
}