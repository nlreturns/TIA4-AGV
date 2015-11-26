
/**
 * Write a description of class CollisionDetector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionDetection{
    
    public Antenna antenna;
    public Ultrasoon ultrasoon;
    
    public CollisionDetection(int ultrasoonInput, int ultrasoonOutput, int leftAntenna, int rightAntenna){
        ultrasoon = new Ultrasoon(ultrasoonInput, ultrasoonOutput);
        antenna = new Antenna(leftAntenna, rightAntenna);
    }
}
