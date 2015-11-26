/**
 * Write a description of class CollisionDetector here.
 * 
 * @author TI.A4a
 * @version 1.0
 */

public class CollisionDetection{
    
    /*
     * Antenna, detects if you collide
     * with an object in front of you
     */
    public Antenna antenna;
    /*
     * Ultrasoon transmits a sound and
     * reads back the reach
     */
    public Ultrasoon ultrasoon;
    
    /*
     * Constructor sets the pins on antenna and ultrasoon
     */
    public CollisionDetection(int ultrasoonInput, int ultrasoonOutput, int leftAntenna, int rightAntenna){
        ultrasoon = new Ultrasoon(ultrasoonInput, ultrasoonOutput);
        antenna = new Antenna(leftAntenna, rightAntenna);
    }
}
