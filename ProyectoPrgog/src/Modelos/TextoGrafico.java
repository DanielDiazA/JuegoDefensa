/**
 * Clase que implementa la Interfaz Dibujable.Crea un texto personalizado(Para puntuaciones ,vida ,etc..)
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

package Modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TextoGrafico implements Dibujable {
    String s;//Nombre
    Color color;//Color
    int anchoV;//Ancho del texto
    int altoV;//alto del texto
    int size;//tamaño del texto
/**
 * Constructor
 * @param hola
 * @param unColor
 * @param a
 * @param h
 */
    public TextoGrafico(String hola, Color unColor, int a, int h) {
        this.s = hola;
        this.color = unColor;
        this.size = 10;
        this.anchoV = a;
        this.altoV = h;
    }
/**
 * Borrrar texto
 * @param g
 * @param txt
 */
    public void Borrartexto(Graphics g,String txt)
    {
        g.setColor(Color.WHITE);//color
        g.setFont(new Font("Algerian", Font.PLAIN, this.getSize()));//fuente de letra
        int ancho = (int)g.getFontMetrics().getStringBounds(txt, g).getWidth();// ancho
        int alto = (int)g.getFontMetrics().getAscent();//alto
        int x = this.anchoV/2 - ancho/2;
        int y = this.altoV/2 + alto/4;        
        g.drawString(txt, x, y);
    }
   /**
    *  Pintar texto
    * @param g
    * @param txt
    */
    public void Pintartexto(Graphics g,String txt)
    {
        g.setColor(Color.RED);//color
        g.setFont(new Font("Algerian", Font.PLAIN, this.getSize()));//fuente de letra
        int ancho = (int)g.getFontMetrics().getStringBounds(txt, g).getWidth();//ancho
        int alto = (int)g.getFontMetrics().getAscent();//alto
        int x = this.anchoV/2 - ancho/2;
        int y = this.altoV/2 + alto/4;        
        g.drawString(txt, x, y);
    }
    /**
     *Dibujar texto 
     */
    @Override
    public void dibujar(Graphics g){
        g.setColor(color);//color
        g.setFont(new Font("Monospaced", Font.PLAIN, this.getSize()));//fuente de letra
        int ancho = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();//ancho
        int alto = (int)g.getFontMetrics().getAscent();//alto
        int x = this.anchoV/2 - ancho/2;
        int y = this.altoV/2 + alto/4;        
        g.drawString(s, x, y);
    }
    
    public void setSize(int nuevoSize){
        size = nuevoSize;
    }
    
    public int getSize(){
        return size;
    }  
    /**
     * Cambiar al color que quieras
     * @param a
     */
    public void SetColor(Color a){
    	this.color=a;
    }

}