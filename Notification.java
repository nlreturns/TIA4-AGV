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
        led.ledRF(Color.blue);
    }

    public void backwards()
    {
        led.ledLB(Color.blue);
        led.ledRB(Color.blue);
    }

    public void turnLeft()
    {
        led.ledRB(Color.blue);
        led.ledLF(Color.blue);
    }

    public void turnRight()
    {
        led.ledRF(Color.blue);
        led.ledLB(Color.blue);
    }

    public void bounce()
    {
        led.ledLB(Color.red);
        led.ledRB(Color.red);
    }

    public void detect()
    {
        led.ledLF(Color.red);
        led.ledRF(Color.red);
    }

    public void reset()
    {
        led.ledLF(Color.black);
        led.ledRF(Color.black);
        led.ledLB(Color.black);
        led.ledRB(Color.black);
    }
    
    public void crossDetection()
    {
        led.ledLF(Color.yellow);
        led.ledRF(Color.yellow);
        led.ledLB(Color.yellow);
        led.ledRB(Color.yellow);
    }
    
    public void idleState()
    {
        led.ledMF(Color.white);
        led.ledMB(Color.white);
    }
    
    public void lineState()
    {
        led.ledMF(Color.green);
        led.ledMB(Color.green);
    }
    
    public void remoteState()
    {
        led.ledMF(Color.yellow);
        led.ledMB(Color.yellow);
    }
    
    public void bluetoothState()
    {
        led.ledMF(Color.blue);
        led.ledMB(Color.blue);
    }
    
    public void raceState()
    {
        led.ledMF(Color.red);
        led.ledMB(Color.red);
    }
}