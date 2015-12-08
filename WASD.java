
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gnu.io.*;
import java.io.*;

public class WASD extends JFrame
{
    
    private JFrame frame;
    
    public WASD(){
        
        super("WASD");
        
        try
        {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM4");
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            SerialPort serialPort = (SerialPort) commPort;
            serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
            
            InputStream in = serialPort.getInputStream();
            OutputStream out = serialPort.getOutputStream();
            
                
            /* -- Menu -- */
            JMenuBar menu = new JMenuBar();
                setJMenuBar(menu);
            JMenuItem close = new JMenuItem("Close");
                close.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { System.exit(0); }
                });
                menu.add(close);
                
            /* -- Pane -- */
            Container contentPane = getContentPane();
            
            /* -- Buttons -- */
            JButton w = new JButton("W");
                w.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write('w'); };
                });
            JButton a = new JButton("A");
                a.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write('a'); };
                });
            JButton s = new JButton("S");
                s.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write('s'); };
                });
            JButton d = new JButton("D");
                d.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write('d'); };
                });
            JButton stop = new JButton("Stop");
                stop.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write(' '); };
                });
            
            contentPane.add(w);
            contentPane.add(a);
            contentPane.add(s);
            contentPane.add(d);
            contentPane.add(stop);
            
            /* -- Set Bounds -- */
            w.setBounds(70, 10, 60, 60);
            a.setBounds(10,70, 60, 60);
            stop.setBounds(70,70, 60, 60);
            s.setBounds(70,130, 60, 60);
            d.setBounds(130,70, 60, 60);
            
            JLabel label = new JLabel("Test");
            
            contentPane.add(label);
            
            label.setBounds(100, 100, 50, 50);
            
            /* -- End -- */
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
            setSize(500,500);
            setLocationRelativeTo(null);
            setVisible(true);
            
            
            while(true)
            {
                
                
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
