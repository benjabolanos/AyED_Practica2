package uabc.ic.benjaminbolanos.practica2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author benjabolanos
 */
public class Espiral extends Figura{
    private final int radioInicial;
    private final int incremento;
    
    public Espiral(int posX, int posY, int ciclos, 
            int radioInicial, int incremento, Color color){
        super(posX, posY, ciclos, color);
        this.radioInicial = radioInicial;
        this.incremento = incremento;
    }
    
    @Override
    public void dibujar(Graphics g) {
        //Se pone en color negro
        g.setColor(color);
        //Se crea una variable radio para utilizar al dibujar y no modificar el radioInicial
        int radio = radioInicial;
        
        //Ciclo para dibujar dos arcos, se va aumentando el radio en cada arco
        //Por cada ciclo, se dibujan dos arcos.
        for(int i=0; i<tam;i++){
            g.drawArc(posX-radio, posY-radio, 2*radio, 2*radio, 0, 180);
            radio += incremento;
            g.drawArc(posX-radio, posY-radio, 2*radio-incremento, 2*radio, 180, 180);
        }
    }

    @Override
    public boolean esValida() {
        int radioFinal = radioInicial + (incremento * (tam-1));
        return (posX-radioFinal|posY-radioFinal-incremento) >= 0 && (posX+radioFinal) <= 700 && (posY+radioFinal+incremento) <= 550;
    }
}
