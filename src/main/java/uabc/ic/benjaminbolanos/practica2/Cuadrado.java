package uabc.ic.benjaminbolanos.practica2;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase Cuadrado que hereda de Figura.
 * No añade atributos extras.
 * @author benjabolanos
 */
public class Cuadrado extends Figura{
    
    public Cuadrado(int posX, int posY, int tam, Color color){
        super(posX, posY, tam, color);
    }
    
    @Override
    public void dibujar(Graphics g) {
        //Se cambia el color y se dibuja un cuadrado lleno
        g.setColor(color);
        g.fillRect(posX, posY, tam, tam);
        
        //Se pone en color negro y se dibujar el perimetro de un cuadrado
        g.setColor(Color.black);
        g.drawRect(posX, posY, tam, tam);
    }

    @Override
    public boolean esValida() {
        return (posX|posY) >= 0 && (posX | (posX+tam)) <= 700 && (posY | (posY+tam)) <= 550;
    }
}
