import TI.*;

public class Motor
{
    
    public Servo left;
    public Servo right;

    public Motor(int left, int right){
        this.left = new Servo(left);
        this.right = new Servo(right);
    }
    
    public void setLeft(int speed){
        left.update(speed);
    }
    
    public void setRight(int speed){
        right.update(speed);
    }
    
}
