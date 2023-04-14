package com.javeriana.mundo;

import com.javeriana.decorator.DisparoDecorador;

import java.io.Serializable;

/**
 * 
 * @author Manuel Alejandro Coral Lozano - Juan Sebasti�n Quintero Yoshioka
 *         Proyecto final - Algoritmos y programaci�n II.
 */
public abstract class Nave implements Serializable {

	// -----------------------------------------------------------------
	// ---------------------------Asociaciones--------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	Disparo disparoUno;
	DisparoDecorador disparoZic;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private double velocidad;

	/**
	 * 
	 */
	protected int posX;

	/**
	 * 
	 */
	protected int posY;

	/**
	 * 
	 */
	private int vida;

	/**
	 * 
	 */
	private int ancho;

	/**
	 * 
	 */
	private int alto;

	/**
	 * 
	 */
	private String rutaImage;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param velocidad
	 * @param posX
	 * @param posY
	 * @param vida
	 * @param ancho
	 * @param alto
	 */
	public Nave() {
		this.velocidad = 0;
		this.posX = 0;
		this.posY = 0;
		this.vida = 0;
		this.ancho = 0;
		this.alto = 0;
	}

	public Nave(double velocidad, int posX, int posY, int vida, int ancho, int alto, String ruta) {
		this.velocidad = velocidad;
		this.posX = posX;
		this.posY = posY;
		this.vida = vida;
		this.ancho = ancho;
		this.alto = alto;
		rutaImage = ruta;
	}

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	public String getRutaImage() {
		return rutaImage;
	}

	public void setRutaImage(String rutaImage) {
		this.rutaImage = rutaImage;
	}

	/**
	 * 
	 * @return
	 */
	public double getVelocidad() {
		return this.velocidad;
	}
	public void setDisparoZic(DisparoDecorador disparoZic) {
		this.disparoZic = disparoZic;
	}public DisparoDecorador getDisparoZic() {
		return disparoZic;
	}

	/**
	 * 
	 * @param velocidad
	 */
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * 
	 * @return
	 */
	public int getPosX() {
		return this.posX;
	}

	/**
	 * 
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * 
	 * @return
	 */
	public int getPosY() {
		return this.posY;
	}

	/**
	 * 
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * 
	 * @return
	 */
	public int getVida() {
		return this.vida;
	}

	/**
	 * 
	 * @param vidas
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * 
	 * @param da�o
	 */
	public void golpe (int danio) {
		this.vida = this.vida - danio;
	}
	
	/**
	 * 
	 * @param ancho
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * 
	 * @return
	 */
	public int getAncho() {
		return this.ancho;
	}

	/**
	 * 
	 * @return
	 */
	public int getAlto() {
		return this.alto;
	}

	/**
	 * 
	 * @param alto
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * 
	 * @return
	 */
	public Disparo getDisparoUno() {
		return disparoUno;
	}

	/**
	 * 
	 * @param disparoUno
	 */
	public void setDisparoUno(Disparo disparoUno) {
		this.disparoUno = disparoUno;
	}

	/**
	 * 
	 * @return
	 */
	public boolean estaViva() {
		return vida != 0;
	}

	/**
	 * 
	 */
	public void mover(int dir) {
	}

	/**
	 * 
	 */
	public void resetear() {
	}
	
	/**
	 * 
	 */
	public void eliminarDisparo() {
		disparoUno = null;
	}
	
	/**
	 * 
	 * @param posX
	 * @param posY
	 */
	public void disparar (int posX, int posY) {
		
		if (disparoUno == null) {
			disparoUno = new Disparo(posX, posY);
		}
		
	}

}