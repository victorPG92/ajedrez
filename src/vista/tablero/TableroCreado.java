package vista.tablero;

import java.awt.Canvas;
import java.awt.Graphics;

public abstract class TableroCreado extends Canvas
{
	
	



	protected static final long serialVersionUID = 1L;
	protected int largo = this.getHeight();
	protected int ancho = this.getWidth();
				
	protected int casX = (int)(ancho/8);
	protected int casY = (int)(largo/8);
	
	
	public abstract void paint(Graphics g);
	public abstract Integer getFila();
	public abstract void setFila(Integer fila);
	public abstract Integer getColumna();
	public abstract void setColumna(Integer columna);

	
	
	public void init()
	{
		  largo = this.getHeight();
		  ancho = this.getWidth();
					
		  casX = (int)(ancho/8);
		  casY = (int)(largo/8);
	}

	
	
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getCasX() {
		return casX;
	}
	public void setCasX(int casX) {
		this.casX = casX;
	}
	public int getCasY() {
		return casY;
	}
	public void setCasY(int casY) {
		this.casY = casY;
	}
	
}