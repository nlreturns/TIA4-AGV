import TI.*;

public class Bluetooth
{
    // set the connection frequency
    public SerialConnection conn = new SerialConnection(115200);

    /**
     * 
     * @method getInput
     * 
     * @return int - returns the action sent to the BoeBot
     * bluetooth device.
     * @default returns 0, no message sent
     */
    public int getInput(){
        if(conn.available() > 0){
            int data = conn.readByte();
            conn.writeByte(data);

            return data;
        }

        return 0;

    }

}