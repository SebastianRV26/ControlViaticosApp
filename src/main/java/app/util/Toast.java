/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.util;

// Java program that creates the Toast message 
//(which is a selectively translucent JWindow) 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class Toast extends JFrame { 
  
    //String of Toast 
    String s; 
  
    // JWindow 
    JWindow w; 
  
    public Toast(Component parent, String s) 
    { 
        w = new JWindow(); 
  
        // make the background transparent 
        w.setBackground(new Color(0, 200, 0, 0)); 
  
        // create a panel 
        JPanel p = new JPanel() { 
            public void paintComponent(Graphics g) 
            { 
                int wid = g.getFontMetrics().stringWidth(s); 
                int hei = g.getFontMetrics().getHeight(); 
  
                // draw the boundary of the Toast and fill it 
                g.setColor(Color.green); 
                g.fillRect(10, 10, wid + 30, hei + 10); 
                g.setColor(Color.green); 
                g.drawRect(10, 10, wid + 30, hei + 10); 
  
                // set the color of text 
                g.setColor(Color.black); 
                g.drawString(s, 25, 27); 
                int t = 250;
            } 
        }; 
  
        w.add(p); 
        if (parent != null) {
            Dimension d = parent.getSize();

            Font font = new Font("Helvetica", Font.PLAIN, 12);
            Canvas c = new Canvas();
            int x = c.getFontMetrics(font).stringWidth(s) + 55;
            int y = (int) d.getHeight() - 80;
            w.setLocation((parent.getWidth() - x) / 2, y);
        }
        w.setSize(300, 100); 
    } 
  
    // function to pop up the Toast 
    public void showToast() 
    { 
        w.setOpacity(1); 
        w.setVisible(true); 
        
        new Thread(()->{
        try {
            // wait for some time 
            Thread.sleep(2000); 
  
            // make the message disappear  slowly 
            for (double d = 1.0; d > 0.2; d -= 0.1) {
                final double x = d;
                Thread.sleep(100); 
                SwingUtilities.invokeLater(()->{
                    w.setOpacity((float)x); 
                });
            } 

            SwingUtilities.invokeLater(()->{
                    // set the visibility to false 
                    w.setVisible(false);  
                });
            
            
        } 
        catch (Exception e) { 
            System.out.println(e.getMessage()); 
        } 
        }).run();
        
    } 
}
