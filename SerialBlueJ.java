
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gnu.io.*;
import java.io.*;

public class SerialBlueJ
{
    public SerialBlueJ(){
        
        try
        {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM4");
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            SerialPort serialPort = (SerialPort) commPort;
            serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
            
            InputStream in = serialPort.getInputStream();
            OutputStream out = serialPort.getOutputStream();
                      
            while(true)
            {
                out.write('J');
                
                while(in.available() > 0)
                    System.out.println((char)in.read());
                Thread.sleep(1000);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
            
    }
    
    public void write(char a){
            
            try{
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
}
