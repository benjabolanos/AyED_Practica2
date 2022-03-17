package uabc.ic.benjaminbolanos.practica2;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author benjabolanos
 */
public class Triangulo extends Figura{
    private final int[] puntosX;
    private final int[] puntosY;
    
    public Triangulo(int posX, int posY, int tam, Color color){
        super(posX, posY, tam, color);
        puntosX = new int[3];
        puntosY = new int[3];
        calcularPuntos();
    }
    
    @Override
    public void dibujar(Graphics g) {
        //Se pone en color azul
        g.setColor(color);
        //Se dibuja un poligono de tres lados, con los puntos calculados.
        g.fillPolygon(puntosX, puntosY, 3);
        
        //Se pone en color negro
        g.setColor(Color.black);
        //Se dibujar el perimetro de un poligono de tres lados, con los puntos
        //calculados.
        g.drawPolygon(puntosX, puntosY, 3);
    }
    
    private void calcularPuntos(){
        //Se calculan los puntos en X.
        //En uno se suma y en otro se resta medio lado.
        puntosX[0] = posX;
        puntosX[1] = posX + tam/2;
        puntosX[2] = posX - tam/2;
        
        //Se calculan los puntos en Y.
        //Ambos puntos (1 y 2) se calculan con Teorema de Pitagoras.
        puntosY[0] = posY;
        puntosY[1] = (int) (posY + sqrt(pow(tam,2)-pow(tam/2,2)));
        puntosY[2] = puntosY[1];
    }

    @Override
    public boolean esValida() {
        for(int i = 0; i < 3; i++){
            if((puntosX[i]|puntosY[i]) < 0 || puntosX[i] > 700 || puntosY[i] > 550){
                return false;
            }
        }
        return true;
    }
}
