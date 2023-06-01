import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse_Moved extends JPanel implements MouseMotionListener {

    int x, y;
    String text = "";

    public Mouse_Moved(){
        addMouseMotionListener(this);
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
