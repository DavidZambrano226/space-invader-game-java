package com.javeriana.mundo;

/**
 *
 * @author Manuel Alejandro Coral Lozano - Juan Sebasti�n Quintero Yoshioka
 *         Proyecto final - Algoritmos y programaci�n II.
 */
public class InvasorCangrejo extends Enemigo {

	private static final String rutaImage ="./data/imagenes/Naves/p0.png";
	private  static final String ruta =	"./data/imagenes/Naves/p1.png";

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
	 * @param direccion
	 */
	public InvasorCangrejo(double velocidad, int posX, int posY, int vida, int ancho, int alto, int direccion) {
		super(velocidad, posX, posY, vida, ancho, alto, direccion, rutaImage, ruta);
		setPuntosPorMuerte(20);
		
	}
}