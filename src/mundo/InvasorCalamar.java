package mundo;

/**
 *
 * @author Manuel Alejandro Coral Lozano - Juan Sebastián Quintero Yoshioka
 *         Proyecto final - Algoritmos y programación II.
 */
public class InvasorCalamar extends Enemigo {

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
	public InvasorCalamar(double velocidad, int posX, int posY, int vida, int ancho, int alto, int direccion, String rutaImage, String ruta) {
		super(velocidad, posX, posY, vida, ancho, alto, direccion, rutaImage, ruta);
		
		rutaImage = ("./data/imagenes/Naves/s0.png");
		setPuntosPorMuerte(30);
		
	}
}
