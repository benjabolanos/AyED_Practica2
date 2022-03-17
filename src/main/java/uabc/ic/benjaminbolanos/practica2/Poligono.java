package uabc.ic.benjaminbolanos.practica2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author benjabolanos
 */
public class Poligono extends Figura{
    private final int[] puntosX;
    private final int[] puntosY;
    
    public Poligono(ArrayList<Integer> puntosX, ArrayList<Integer> puntosY, Color color){
        super(1, 1, puntosX.size(), color);
        this.puntosX = list2Array(puntosX);
        this.puntosY = list2Array(puntosY);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillPolygon(puntosX, puntosY, tam);
        
        g.setColor(Color.black);
        g.drawPolygon(puntosX, puntosY, tam);
    }
    
    private int [] list2Array(ArrayList<Integer> al){
        int[] array = new int[al.size()];
        for(int i = 0; i<al.size(); i++){
            array[i] = al.get(i);
        }
        return array;
    }

    @Override
    public boolean esValida() {
        for(int i = 0; i<tam; i++){
            if((puntosX[i]|puntosY[i]) < 0 || puntosX[i] > 700 || puntosY[i] > 550){
                return false;
            }
        }
        return true;
    }
}
