package uabc.ic.benjaminbolanos.practica2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author benjabolanos
 */
public class Circulo extends Figura{
    public Circulo(int posX, int posY, int diametro, Color color){
        super(posX, posY, diametro, color);
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(posX, posY, tam, tam);
        
        g.setColor(Color.black);
        g.drawOval(posX, posY, tam, tam);
    }

    @Override
    public boolean esValida() {
        return (posX|posY) >= 0 && (posX | (posX+tam)) <= 700 && (posY | (posY+tam)) <= 550;
    }
}
