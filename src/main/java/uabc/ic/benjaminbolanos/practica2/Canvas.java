package uabc.ic.benjaminbolanos.practica2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JColorChooser;

import javax.swing.JPanel;

/**
 *
 * @author jorgeeie
 */
public class Canvas extends JPanel{
    private final Stack<Figura> figuras;
    
    public Canvas(){
        figuras = new Stack();
    }
    
    public void crearCuadrado(int posX, int posY, int tam){
        Color color = JColorChooser.showDialog(this, "Selecciona un color:", new Color(0,163,255));
        figuras.push(new Cuadrado(posX, posY, tam, color));
    }
    
    public void crearTriangulo(int posX, int posY, int tam){
        Color color = JColorChooser.showDialog(this, "Selecciona un color:", new Color(0,163,255));
        figuras.push(new Triangulo(posX, posY, tam, color));
    }
    
    public void crearEspiral(int posX, int posY, int ciclos, int radioInicial, int incremento){
        Color color = JColorChooser.showDialog(this, "Selecciona un color:", new Color(0,163,255));
        figuras.push(new Espiral(posX, posY, ciclos, radioInicial, incremento, color));
    }
    
    public void crearCirculo(int posX, int posY, int diametro){
        Color color = JColorChooser.showDialog(this, "Selecciona un color:", new Color(0,163,255));
        figuras.push(new Circulo(posX, posY, diametro, color));
    }
    
    public void crearPoligono(ArrayList<Integer> puntosX, ArrayList<Integer> puntosY){
        Color color = JColorChooser.showDialog(this, "Selecciona un color:", new Color(0,163,255));
        figuras.push(new Poligono(puntosX, puntosY, color));
    }
    
    public void dibujarFiguras(boolean ascendente, boolean validar, boolean cuadrados, boolean triangulos, 
            boolean espirales, boolean circulos, boolean poligonos){
        Stack<Figura> aux = new Stack();
        if(ascendente){
            while(!figuras.isEmpty()){
                aux.push(figuras.pop());
            }
            while(!aux.isEmpty()){  
                Figura fig = aux.pop();
                figuras.push(fig);
                dibujarFigura(fig, validar, cuadrados, triangulos, espirales, circulos, poligonos);
            }
        } else {
            while(!figuras.isEmpty()){
                Figura fig = figuras.pop();
                aux.push(fig);
                dibujarFigura(fig, validar, cuadrados, triangulos, espirales, circulos, poligonos);
            }
            while(!aux.isEmpty()){
                figuras.push(aux.pop());
            }
        }
    }
    
    public void dibujarFigura(Figura fig, boolean validar, boolean cuadrados, boolean triangulos, 
            boolean espirales, boolean circulos, boolean poligonos){
        Class clase = fig.getClass();
        if(clase == Cuadrado.class & cuadrados ||
           clase == Triangulo.class & triangulos ||
           clase == Espiral.class & espirales ||
           clase == Circulo.class & circulos ||
           clase == Poligono.class & poligonos){
            if(validar && fig.esValida()){
                fig.dibujar(getGraphics());
            } else if(!validar){
                fig.dibujar(getGraphics());
            }

        }
    }
    
    public void limpiar(){
        super.paint(getGraphics());
    }
    
    public void reiniciarFiguras(){
        figuras.clear();
    }
    
    public int cantidadFiguras(){
        return figuras.size();
    }
}
