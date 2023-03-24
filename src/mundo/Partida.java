package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import excepciones.PartidaYaExisteException;

/**
 *
 * 
 * @author Manuel Alejandro Coral Lozano - Juan Sebastián Quintero Yoshioka
 *         Proyecto final - Algoritmos y programación II.
 */
public class Partida implements Serializable {

	// -----------------------------------------------------------------
	// ---------------------------Asociaciones--------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private Partida partidaIzquierda;

	/**
	 * 
	 */
	private Partida partidaDerecha;

	/**
	 * 
	 */
	private Enemigo[][] enemigos;

	/**
	 * 
	 */
	private Puntaje puntaje;

	/**
	 * 
	 */
	private Nivel nivel;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private String nombre;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param nombre
	 * @param duracionNivel
	 */
	public Partida(String nombre) {
		this.nombre = nombre;
		nivel = new Nivel("1", 0, 0, 0, 0, 0, 0, 0);

		//		inicializarEnemigos();
	}

	// -----------------------------------------------------------------
	// -----------------------------Métodos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public Partida getPartidaIzquierda() {
		return partidaIzquierda;
	}

	/**
	 * 
	 * @param partidaIzquierda
	 */
	public void setPartidaIzquierda(Partida partidaIzquierda) {
		this.partidaIzquierda = partidaIzquierda;
	}

	/**
	 * 
	 * @return
	 */
	public Partida getPartidaDerecha() {
		return partidaDerecha;
	}

	/**
	 * 
	 * @param partidaDerecha
	 */
	public void setPartidaDerecha(Partida partidaDerecha) {
		this.partidaDerecha = partidaDerecha;
	}

	public Enemigo[][] getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(Enemigo[][] enemigos) {
		this.enemigos = enemigos;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	/**
	 * 
	 * @return
	 */
	public Puntaje getPuntaje() {
		return puntaje;
	}

	/**
	 * 
	 * @param puntaje
	 */
	public void setPuntaje(Puntaje puntaje) {
		this.puntaje = puntaje;
	}

	public void agregarPartida(Partida nodo) throws PartidaYaExisteException {

		if (this.nombre.compareToIgnoreCase(nodo.nombre) == 0) {
			throw new PartidaYaExisteException(nodo.nombre);
		} else if (this.nombre.compareToIgnoreCase(nodo.nombre) > 0) {

			if (partidaIzquierda == null) {
				setPartidaIzquierda(nodo);
			} else {
				partidaIzquierda.agregarPartida(nodo);
			}

		} else {

			if (partidaDerecha == null) {
				setPartidaDerecha(nodo);
			} else {
				partidaDerecha.agregarPartida(nodo);
			}

		}

	}

	public Partida buscarPartida(String nombre) {

		Partida aBuscar = null;

		if (this != null) {
			if (this.getNombre().equals(nombre)) {
				aBuscar = this;
			} else {

				if (this.getNombre().compareToIgnoreCase(nombre) > 0) {
					if(this.getPartidaIzquierda() != null)
					aBuscar = this.getPartidaIzquierda().buscarPartida(nombre);
				} else if (this.getNombre().compareToIgnoreCase(nombre) < 0) {
					if(this.getPartidaDerecha() != null)
					aBuscar = this.getPartidaDerecha().buscarPartida(nombre);
				}

			}
		}

		return aBuscar;
	}

	/**
	 * @throws IOException
	 * 
	 */
	public void inicializarPartida() throws IOException {

		File archivo = new File("");

		if (nivel.getNivel().equals("1")) {
			archivo = new File("./data/nivel1.txt");
		} else if (nivel.getNivel().equals("2")) {
			archivo = new File("./data/nivel2.txt");
		}

		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);

		int cantEnemigos = 0;

		String linea = br.readLine();

		linea = br.readLine();

		String nivelActual = linea;

		linea = br.readLine();
		linea = br.readLine();
		int filas = Integer.parseInt(linea);
		linea = br.readLine();
		linea = br.readLine();
		int colums = Integer.parseInt(linea);

		enemigos = new Enemigo[filas][colums];

		linea = br.readLine();
		linea = br.readLine();

		int vidaEnemigo = Integer.parseInt(linea);

		linea = br.readLine();
		linea = br.readLine();

		cantEnemigos = Integer.parseInt(linea);

		linea = br.readLine();
		linea = br.readLine();

		int velocidad = Integer.parseInt(linea);

		linea = br.readLine();
		linea = br.readLine();
		String[] arreglo = linea.split("\t");

		this.nivel = new Nivel(nivelActual, velocidad, cantEnemigos,
				vidaEnemigo, Integer.parseInt(arreglo[0]), Integer.parseInt(arreglo[1]),
				Integer.parseInt(arreglo[2]), Integer.parseInt(arreglo[3]));

		inicializarEnemigos();

		br.close();
		fr.close();
	}

	public void inicializarEnemigos() {

		for (int i = 0; i < enemigos.length; i++) {
			for (int j = 0; j < enemigos[i].length; j++) {

				if (i == 0) {
					enemigos[i][j] = new InvasorCalamar(nivel.getVelocidadEnemigos(), (j * nivel.getPosXPrimerEnemigo() + nivel.getPosXPrimerEnemigo())
							, nivel.getPosYPrimerEnemigo(), nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
							Enemigo.DERECHA, "./data/imagenes/Naves/s0.png", "./data/imagenes/Naves/s1.png");
				} else if (i == 1 || i == 2) {

					enemigos[i][j] = new InvasorCangrejo(nivel.getVelocidadEnemigos(), (j * nivel.getPosXPrimerEnemigo() + nivel.getPosXPrimerEnemigo()),
							(i *  nivel.getPosYPrimerEnemigo() +  nivel.getPosYPrimerEnemigo()), nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
							Enemigo.DERECHA, "./data/imagenes/Naves/p0.png", "./data/imagenes/Naves/p1.png");

				} else if (i == 3 || i == 4) {
					enemigos[i][j] = new InvasorPulpo(nivel.getVelocidadEnemigos(), (j * nivel.getPosXPrimerEnemigo() + nivel.getPosXPrimerEnemigo()),
							(i * nivel.getPosYPrimerEnemigo() + nivel.getPosYPrimerEnemigo()), nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
							Enemigo.DERECHA, "./data/imagenes/Naves/r0.png", "./data/imagenes/Naves/r1.png");
				}
			}
		}

	}

	/**
	 * 
	 * @param elimino
	 * @param a
	 */
	public void eliminarUnEnemigo(boolean elimino, Enemigo a) {
		boolean salida = false;
		if (elimino) {

			for (int i = 0; i < enemigos.length && !salida; i++) {
				for (int j = 0; j < enemigos[0].length && !salida; j++) {

					if (enemigos[i][j] != null) {
						if (enemigos[i][j].equals(a)) {
							enemigos[i][j] = null;
							salida = true;
						}
					}
				}
			}
		}

	}


	/**
	 * 
	 */
	public boolean terminarNivel() {

		int contador = 0;

		for (int i = 0; i < enemigos.length; i++) {
			for (int j = 0; j < enemigos[i].length; j++) {

				if (enemigos[i][j] == null) {
					contador++;
				}
			}
		}

		return (contador == (enemigos.length*enemigos[0].length));
	}

	/**
	 * @throws IOException 
	 * 
	 */
	public boolean nivelCompleto() throws IOException {

		if (nivel.getNivel().equals("1")) {
			nivel.setNivel("2");
			inicializarPartida();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return nombre;
	}

	public void inorden(ArrayList<Partida> acumulado) {
		if (partidaIzquierda != null)
			partidaIzquierda.inorden(acumulado);
		acumulado.add(this);
		if (partidaDerecha != null)
			partidaDerecha.inorden(acumulado);
	}

	public Partida eliminar( String nombre ) {
		if(esHoja( ))
			return null;
		if( this.nombre.compareToIgnoreCase(nombre) == 0) {
			if( partidaIzquierda == null )
				return partidaDerecha;
			if( partidaDerecha == null )
				return partidaIzquierda;

			Partida sucesor = partidaDerecha.darMenor( );

			partidaDerecha = partidaDerecha.eliminar( sucesor.getNombre());

			sucesor.partidaIzquierda = partidaIzquierda;
			sucesor.partidaDerecha = partidaDerecha;
			return sucesor;
		}
		else if( this.nombre.compareToIgnoreCase(nombre) > 0)
			partidaIzquierda = partidaIzquierda.eliminar( nombre );
		else
			partidaDerecha = partidaDerecha.eliminar(nombre);
		return this;
	}


	public Partida darMenor( ) {
		return (partidaIzquierda == null) ? this : partidaIzquierda.darMenor();
	}

	public boolean esHoja(){
		return (partidaIzquierda == null && partidaDerecha == null);
	}

}