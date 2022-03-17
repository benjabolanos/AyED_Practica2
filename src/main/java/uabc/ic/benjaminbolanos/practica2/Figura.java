package uabc.ic.benjaminbolanos.practica2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author benjabolanos
 */
public abstract class Figura {
    protected int posX;
    protected int posY;
    protected int tam;
    protected Color color;
    
    public Figura(int posX, int posY, int tam, Color color){
        this.posX = posX;
        this.posY = posY;
        this.tam = tam;
        this.color = color;
    }
    
    public abstract void dibujar(Graphics g);
    public abstract boolean esValida();

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
}
