
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gnu.io.*;
import java.io.*;

public class WASD extends JFrame{
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
            
            GridLayout layout = new GridLayout(2, 3);
            
            setLayout(layout);
            
            /* -- Pane -- */
            //Container contentPane = getContentPane();

            /* -- Buttons -- */
            JButton w = new JButton("");
            w.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write('w', out); };
                });
            JButton a = new JButton("");
            a.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write('a', out); };
                });
            JButton s = new JButton("");
            s.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write('s', out); };
                });
            JButton d = new JButton("");
            d.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write('d', out); };
                });
            JButton stop = new JButton("");
            stop.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ write(' ', out); };
                });
                
            JButton start = new JButton("");
            start.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){ write('x', out); };
            });

            /* pimp modus */
            start.setIcon(new ImageIcon("start.jpeg"));
            w.setIcon(new ImageIcon("test.png"));
            stop.setIcon(new ImageIcon("stop.png"));
            a.setIcon(new ImageIcon("left.png"));
            d.setIcon(new ImageIcon("right.png"));
            s.setIcon(new ImageIcon("s.png"));
            
            /* add buttons to gui */
            add(start);    
            add(w);
            add(stop);
            add(a);
            add(s);
            add(d);
            
            /* -- End -- */
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
            setSize(500,500);
            setLocationRelativeTo(null);
            setVisible(true);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void write(char a, OutputStream out){

        try{
            System.out.println(a);
            out.write(a);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}