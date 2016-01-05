import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import gnu.io.*;
import java.io.*;
import java.util.*;

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

            // create all layouts
            /* Action list layout <left screen> */
            JPanel list = new JPanel();
            
            //list.setLayout(new FlowLayout());

            ArrayList<String> route = new ArrayList<String>();
            
            final AbstractListModel<String> model = new AbstractListModel<String>(){
                public String getElementAt(int index){
                    return route.get(index);
                }
                public int getSize(){
                    return route.size();
                }
            };
            
            final JList<String> commandList = new JList<String>(model);
            
            list.add(new JScrollPane(commandList));

            /* Route buttons <middle screen> */
            JPanel routeButtons = new JPanel();

            routeButtons.setLayout(new GridLayout(5,1));

            /* WASD layout <right screen> */
            JPanel WASD = new JPanel();
            WASD.setLayout(new GridLayout(2,3));

            // set main layout
            GridLayout layout = new GridLayout(1, 3);
            setLayout(layout);

            // Add layouts to main layout
            add(list);
            add(routeButtons);
            add(WASD);

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

            JButton startRoute = new JButton("Start");
            startRoute.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        write('}', out);
                    };
            });
            
            JButton deleteRoute = new JButton("Verwijder");
            deleteRoute.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        // delete the thang;
                    };
            });
                
            JButton go = new JButton("Ga door");
            go.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        route.add("Vooruit");
                        
                        write(FOREWARD, out);
                        
                        for(ListDataListener p : model.getListDataListeners())
                            p.contentsChanged(null);
                    };
                });
            JButton left = new JButton("Ga links");
            left.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        route.add("Links");
                        
                        write(Config.LEFT, out);
                        
                        for(ListDataListener p : model.getListDataListeners())
                            p.contentsChanged(null);
                    };
                });
            JButton right = new JButton("Ga rechts");
            right.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ 
                        route.add("Rechts"); 
                        
                        write(Config.RIGHT, out);
                        
                        for(ListDataListener p : model.getListDataListeners())
                            p.contentsChanged(null);
                    };
                });

            /* pimp modus */
            start.setIcon(new ImageIcon("start.jpeg"));
            w.setIcon(new ImageIcon("test.png"));
            stop.setIcon(new ImageIcon("stop.png"));
            a.setIcon(new ImageIcon("left.png"));
            d.setIcon(new ImageIcon("right.png"));
            s.setIcon(new ImageIcon("s.png"));

            /* add buttons to gui */
            WASD.add(start);    
            WASD.add(w);
            WASD.add(stop);
            WASD.add(a);
            WASD.add(s);
            WASD.add(d);

            routeButtons.add(startRoute);
            routeButtons.add(go);
            routeButtons.add(left);
            routeButtons.add(right);
            routeButtons.add(deleteRoute);

            /* -- End -- */
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
            setSize(1000,500);
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