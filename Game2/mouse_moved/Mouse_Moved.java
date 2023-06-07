
package mouse_moved;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alexander
 */
public class Mouse_Moved extends JPanel implements MouseMotionListener{
    int x, y;
    String texto="";
    
    public Mouse_Moved(){
        addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g; //casting
        g2.setPaint(Color.white);
        ImageIcon img =  new ImageIcon(getClass().getResource("images2.png"));
        g2.drawImage(img.getImage(), x, y,32,32,null);
       Font score =  new Font("Arial",Font.BOLD,30);
            g2.setFont(score);
            g2.setColor(Color.BLACK);
            g2.drawString(texto, 20, 30);
    }
    public static void main(String[] args) {
        JFrame f = new  JFrame("Ejemplo moved");
        f.getContentPane().add(new Mouse_Moved());

        f.setSize(500, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = (int)e.getPoint().getX();
        y = (int)e.getPoint().getY();
        texto = "X: "+x+"   Y: "+y;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
