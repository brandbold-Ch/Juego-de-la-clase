import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Personaje extends JPanel {

    static  final int ANCHO = 100;
    static  final int ALTO = 100;
    int x = 500;
    int y = 250;
    int y1 = 0;
    Juego jueguito;

    boolean saltando = false;
    boolean sube = false;
    boolean baja = false;

    public Personaje(Juego jueguito){
        this.jueguito = jueguito;
    }

    public void mover(){
        if(saltando){

            if (y==250) {
                sube = true;
                y1 = -5;
                baja = false;
            }

            if (y==50){
                baja = true;
                y1 = 5;
                sube = false;
            }

            if (sube){
                y += y1;
            }

            if (baja){
                y += y1;
                if (y==250){
                    saltando = false;
                }
            }
        }
    }

    public void paint(Graphics2D g){
        g.fillRect(x, y, ANCHO, ALTO);
    }

    public void keyPressed(KeyEvent e){
        System.out.println("Codigo: " + e.getKeyCode());

        switch (e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                saltando = true;
                break;
            case 37:
                if (x != 20){
                    x -= 30;
                }
                System.out.println("x1: " + x);
                break;
            case 38:
                if (y != 40){
                    y -= 30;
                }
                System.out.println("y1: " + y);
                break;
            case 39:
                if (x != 1070){
                    x += 30;
                }
                System.out.println("x2: " + x);
                break;
            case 40:
                if (y != 250){
                    y += 30;
                }
                System.out.println("y2: " + y);
                break;
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, ANCHO, ALTO);
    }
}
