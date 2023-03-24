package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import excepciones.NicknameYaExisteException;
import excepciones.PartidaYaExisteException;

/**
 * Clase principal del mundo que representa el juego.
 * 
 * @author Manuel Alejandro Coral Lozano - Juan Sebastián Quintero Yoshioka
 *         Proyecto final - Algoritmos y programación II.
 */
public class SpaceInvaders {

	// -----------------------------------------------------------------
	// ---------------------------Asociaciones--------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private ArrayList<NaveJugador> jugadores;

	/**
	 * 
	 */
	private Partida partidaActual;

	/**
	 * 
	 */
	private NaveJugador jugadorActual;

	/**
	 * 
	 */
	private Puntaje primerPuntaje;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private boolean enFuncionamiento;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param enFuncionamiento
	 */
	public SpaceInvaders(boolean enFuncionamiento) {

		this.enFuncionamiento = enFuncionamiento;

		jugadores = new ArrayList<NaveJugador>();

		partidaActual = null;

		jugadorActual = null;

		primerPuntaje = null;

		try {
			deserializarJugador();
			deserializarPuntaje();
		} catch (ClassNotFoundException | IOException e) {

		}
	}

	// -----------------------------------------------------------------
	// -----------------------------Métodos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @return
	 */
	public boolean getEnFuncionamiento() {
		return this.enFuncionamiento;
	}

	/**
	 * 
	 * @param enFuncionamiento
	 */
	public void setEnFuncionamiento(boolean enFuncionamiento) {
		this.enFuncionamiento = enFuncionamiento;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<NaveJugador> getJugadores() {
		return jugadores;
	}

	/**
	 * 
	 * @param jugadores
	 */
	public void setJugadores(ArrayList<NaveJugador> jugadores) {
		this.jugadores = jugadores;
	}

	/**
	 * 
	 * @return
	 */
	public Partida getPartidaActual() {
		return partidaActual;
	}

	/**
	 * 
	 * @param partidaActual
	 */
	public void setPartidaActual(Partida partidaActual) {
		this.partidaActual = partidaActual;
	}

	/**
	 * 
	 * @return
	 */
	public NaveJugador getJugadorActual() {
		return jugadorActual;
	}

	/**
	 * 
	 * @param jugadorActual
	 */
	public void setJugadorActual(NaveJugador jugadorActual) {
		this.jugadorActual = jugadorActual;
	}

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public NaveJugador buscarJugador(String nickname) {
		NaveJugador naveBuscada = null;
		boolean buscado = false;

		for (int i = 0; i < jugadores.size() && !buscado; i++) {
			if (jugadores.get(i).getNickname().equalsIgnoreCase(nickname)) {
				naveBuscada = jugadores.get(i);
				buscado = true;
			}
		}

		return naveBuscada;
	}

	/**
	 * 
	 * @param nombre
	 * @param directorio
	 * @throws NicknameYaExisteException
	 * @throws IOException
	 */
	public void agregarJugador(String nombre, String nickname) throws NicknameYaExisteException, IOException {

		if (buscarJugador(nickname) == null) {
			NaveJugador agregar = new NaveJugador(nombre, nickname);
			jugadores.add(agregar);
			jugadorActual = agregar;
			jugadorActual.setPosInicialX(300);
			jugadorActual.setPosIncialY(410);
			jugadorActual.setAncho(30);
			jugadorActual.setAlto(19);
			serializarJugador();
		} else
			throw new NicknameYaExisteException(nickname);

	}

	/**
	 * @throws IOException
	 * 
	 */
	public void serializarJugador() throws IOException {

		File archivo = new File("./data/jugador");

		FileOutputStream fos = new FileOutputStream(archivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(jugadores);

		oos.close();
		fos.close();

	}

	public void iniciarPartida () {
		jugadorActual.setVida(3);
	}

	/**
	 * 
	 * @param ruta
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void deserializarJugador() throws IOException, ClassNotFoundException {

		File archivo = new File("./data/jugador");

		FileInputStream fis = new FileInputStream(archivo);
		ObjectInputStream ois = new ObjectInputStream(fis);

		jugadores = (ArrayList<NaveJugador>) ois.readObject();

		ois.close();
		fis.close();
	}

	public ArrayList<Partida> darPartidasJugador() {
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		if (jugadorActual.getPartidaRaiz() != null)
			jugadorActual.getPartidaRaiz().inorden(partidas);

		return partidas;
	}

	public void crearPartida(String nombre) throws PartidaYaExisteException, IOException {
		partidaActual = jugadorActual.crearPartida(nombre);
		partidaActual.setPuntaje(new Puntaje(0, jugadorActual.getNickname(), partidaActual.getNombre()));
		serializarJugador();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<NaveJugador> ordenarPorNickname() {

		ArrayList<NaveJugador> jugadoresOrdenados = (ArrayList<NaveJugador>) jugadores.clone();

		if (jugadores != null) {
			for (int i = 1; i < jugadoresOrdenados.size(); i++) {
				for (int j = i; j > 0 && jugadoresOrdenados.get(j - 1).getNickname()
						.compareTo(jugadoresOrdenados.get(j).getNickname()) > 0; j--) {
					NaveJugador temp = (NaveJugador) jugadoresOrdenados.get(j);
					jugadoresOrdenados.set(j, jugadoresOrdenados.get(j - 1));
					jugadoresOrdenados.set(j - 1, temp);
				}
			}

		}
		return jugadoresOrdenados;

	}

	
	/**
	 * 
	 */
	public boolean busquedaRapida(String nickname){

		ArrayList<NaveJugador> jugadoresOrdenados = ordenarPorNickname();
		boolean encontrado = false;

		int posicion = -1;
		int inicio = 0;
		int fin = jugadoresOrdenados.size( ) - 1;
		while( inicio <= fin && posicion == -1 && !encontrado)	{
			int medio = ( inicio + fin ) / 2;
			NaveJugador mitad = ( NaveJugador )jugadoresOrdenados.get( medio );
			if( mitad.getNickname().compareToIgnoreCase(nickname) == 0 ){
				posicion = medio;
				encontrado = true;
			}
			else if(mitad.getNickname().compareToIgnoreCase(nickname) > 0){
				fin = medio - 1;
			}
			else{
				inicio = medio + 1;
			}
		}

		if(encontrado)
			jugadorActual = (NaveJugador) jugadoresOrdenados.get(posicion);

		return encontrado;
	}

	public void agregarPuntaje(Puntaje puntaje) {
		if (primerPuntaje == null) {
			primerPuntaje = puntaje;

		} else {   
			if (primerPuntaje.getPuntuacion() < puntaje.getPuntuacion()) {

				puntaje.setSiguiente(primerPuntaje);
				primerPuntaje.setAnterior(puntaje);
				primerPuntaje = puntaje;
			} else {

				Puntaje aux = primerPuntaje;


				while (aux.getSiguiente() != null && aux.getSiguiente().getPuntuacion() >= puntaje.getPuntuacion()) {

					aux = aux.getSiguiente();
				}

				Puntaje nuevaSiguiente = null;

				if (aux.getSiguiente() != null) {
					nuevaSiguiente = aux.getSiguiente();
					nuevaSiguiente.setAnterior(puntaje);
				}

				aux.setSiguiente(puntaje);
				puntaje.setAnterior(aux);
				puntaje.setSiguiente(nuevaSiguiente);

			}
		}
	}

	public ArrayList<String> mejoresPuntajes(){

		ArrayList<String> mejoresPuntajes = new ArrayList<String>();
		Puntaje primer = primerPuntaje;
		int contador = 1;
		while(primer != null && contador <= 10){
			mejoresPuntajes.add(contador + " " + primer.toString());
			contador++;
			primer = primer.getSiguiente();
		}

		return mejoresPuntajes;
	}

	/**
	 * @throws IOException
	 * 
	 */
	public void serializarPuntaje() throws IOException {

		File archivo = new File("./data/puntaje");

		FileOutputStream fos = new FileOutputStream(archivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(primerPuntaje);

		oos.close();
		fos.close();

	}

	/**
	 * 
	 * @param ruta
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void deserializarPuntaje() throws IOException, ClassNotFoundException {

		File archivo = new File("./data/puntaje");

		FileInputStream fis = new FileInputStream(archivo);
		ObjectInputStream ois = new ObjectInputStream(fis);

		primerPuntaje = (Puntaje) ois.readObject();

		ois.close();
		fis.close();
	}

	public int puntosPorVida(){
		return (jugadorActual.getVida()*200);
	}

	public int puntosPorDisparos(){
		return jugadorActual.getCantidadDisparos();
	}

	public void eliminarPartida() throws IOException{
		Puntaje nuevoPuntaje = new Puntaje(partidaActual.getPuntaje().getPuntuacion(), jugadorActual.getNickname(), partidaActual.getNombre());
		agregarPuntaje(nuevoPuntaje);
		jugadorActual.setPartidaRaiz(jugadorActual.getPartidaRaiz().eliminar(partidaActual.getNombre()));
		serializarJugador();
		serializarPuntaje();
	}
}
