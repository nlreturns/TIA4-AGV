
/**
 * Write a description of class CollisionDetector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionDetection{
    
    
    //public Ultrasone ultrasone;
    
    public CollisionDetection(int antennaPin){
        //antenna = new Antenna(antennaPin);
    }
    
    public static void main(String[] args){
        Antenna antenna = new Antenna(7);
        
        while(true){
            
            if(antenna.tooClose(antenna.getPulse())){
                Drive.stop();
            }
            
        }
        
    }
    
}
