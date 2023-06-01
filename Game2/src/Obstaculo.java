import java.awt.*;

public class Obstaculo {

    public final  int ANCHO = 50;
    public final  int ALTO = 100;
    static int inc_x = -5;
    static int x1 = 100;
    static int x2 = 1200;
    int y = 250;

    Juego jueguito;

    public Obstaculo(Juego jueguito){
        this.jueguito = jueguito;
    }

    public void mover(){
        if (x1 > 1400 && x2 < -50){
            jueguito.puntos++;
            x1 = 100;
            x2 = 1200;

            if (jueguito.puntos == 3 || jueguito.puntos == 6 || jueguito.puntos == 9 || jueguito.puntos == 12){
                inc_x += -2;
                jueguito.nivel++;
            }
        }else {
            if (colision1() || colision2()){
                if (jueguito.vidas == 0){
                    jueguito.finJuego();
                }else {
                    jueguito.pierdeVida();
                }
            }
            x1 -= inc_x;
            x2 += inc_x;
        }
    }

    public boolean colision1(){
        return jueguito.personaje1.getBounds().intersects(getBounds1());
    }
    public boolean colision2(){
        return jueguito.personaje1.getBounds().intersects(getBounds2());
    }


    public void paint(Graphics2D g){
        g.fillRect(x1, y, ANCHO, ALTO);
        g.fillRect(x2, y, ANCHO, ALTO);
    }

    public Rectangle getBounds1(){
        return new Rectangle(x1-5, y, ANCHO, ALTO);
    }
    public Rectangle getBounds2(){
        return new Rectangle(x2-5, y, ANCHO, ALTO);
    }
}
