package com.javeriana;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.javeriana.control.Teclado;
import com.javeriana.excepciones.NicknameYaExisteException;
import com.javeriana.excepciones.PartidaYaExisteException;
import com.javeriana.hilos.HiloAnimacionEnemigos;
import com.javeriana.hilos.HiloAuxiliarCreaDisparo;
import com.javeriana.hilos.HiloDisparoEnemigos;
import com.javeriana.hilos.HiloDisparoJugador;
import com.javeriana.hilos.HiloEnemigos;
import com.javeriana.interfaz.DialogoMejoresPuntajes;
import com.javeriana.interfaz.PanelImagenInicial;
import com.javeriana.interfaz.PanelMenu;
import com.javeriana.interfaz.PanelNivel;
import com.javeriana.mundo.NaveJugador;
import com.javeriana.mundo.Partida;
import com.javeriana.mundo.SpaceInvaders;
import com.javeriana.hilos.SpaceInvaderStartFacade;

public class InterfazSpaceInvaders extends JFrame {

	/**
	 * The class
	 */
	private static final long serialVersionUID = 1L;

	public static CardLayout card = new CardLayout();

	public static Container contenedor;

	private PanelImagenInicial imagen;

	private Teclado tecladito;

	private PanelMenu panelMenu;

	private PanelNivel panelNivel;

	private SpaceInvaders mundo;

	private boolean pausa;

	public InterfazSpaceInvaders() {

		mundo = new SpaceInvaders(false);


		panelMenu = new PanelMenu(this);
		panelNivel = new PanelNivel(mundo.getPartidaActual(), mundo, this);

		imagen = new PanelImagenInicial(this);
		addKeyListener(imagen);
		contenedor = this.getContentPane();
		card.addLayoutComponent(imagen, "Inicio");
		card.addLayoutComponent(panelMenu, "Menu");
		card.addLayoutComponent(panelNivel, "Juego");

		contenedor.add(imagen);
		contenedor.add(panelMenu);
		contenedor.add(panelNivel);

		contenedor.setLayout(card);
		card.show(contenedor, "Inicio");

		tecladito = new Teclado(this, mundo);
		addKeyListener(tecladito);

		setSize(640, 480);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));

	}

	/**
	 *
	 * @param nombre
	 */
	public void cambiarPanel(String nombre) {
		if (nombre.equals("Menu")) {
			card.show(contenedor, "Menu");
		} else if (nombre.equals("Juego")) {
			card.show(contenedor, "Juego");
		}
	}

	/**
	 * cerrar method
	 */
	public void cerrar() {
		try {
			mundo.serializarJugador();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	/**
	 *
	 * @return
	 */
	public boolean estaEnPausa() {
		return pausa;
	}

	/**
	 *
	 * @param paus
	 */
	public void cambiarPausa (boolean paus) {
		this.pausa = paus;
	}


	/**
	 *
	 * @return
	 */
	public int darPosActualJugador() {
		return panelNivel.getPosJugadorActualX();
	}

	/**
	 *
	 * @return
	 */
	public boolean estaEnFuncionamiento() {
		return mundo.getEnFuncionamiento();
	}

	/**
	 *
	 * @param salida
	 */
	public void modificarFuncionamiento (boolean salida) {
		mundo.setEnFuncionamiento(salida);
	}

	/**
	 *
	 * @return
	 */
	public PanelNivel getPanelNivel() {
		return panelNivel;
	}

	/**
	 *
	 * @return
	 */
	public NaveJugador getJugadorActual() {
		return mundo.getJugadorActual();
	}

	/**
	 *
	 * @param panelNivel
	 */
	public void setPanelNivel(PanelNivel panelNivel) {
		this.panelNivel = panelNivel;
	}

	/**
	 *
	 * @return
	 */
	public PanelMenu getPanelMenu() {
		return panelMenu;
	}

	/**
	 *
	 * @param panelMenu
	 */
	public void setPanelMenu(PanelMenu panelMenu) {
		this.panelMenu = panelMenu;
	}

	private SpaceInvaderStartFacade startFacade = new SpaceInvaderStartFacade();

	/**
	 *
	 */
	public void startHiloJugador() {
		startFacade.startKeyboardPlayer();
	}

	/**
	 *
	 */
	public void iniciarTodosLosHilos() {
		mundo.setEnFuncionamiento(true);
		startFacade.iniciarJuego(mundo, this);
	}

	/**
	 *
	 */
	public void matarHilos (){;
		startFacade.detenerJuego();
	}

	/**
	 *
	 * @param nombre
	 */
	public void reqCrearPartida(String nombre) {
		try {
			mundo.crearPartida(nombre);
			mundo.getPartidaActual().inicializarPartida();
			actualizarPartidas();
			actualizarPartidaActual(nombre);
			panelNivel.setPartida(mundo.getPartidaActual());
			mundo.iniciarPartida();
			cambiarPanel("Juego");
		} catch (PartidaYaExisteException | IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error al crear la partida", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 *
	 * @param nombre
	 * @param nickname
	 */
	public void reqAgregarJugador(String nombre, String nickname) {
		try {
			mundo.agregarJugador(nombre, nickname);
			panelMenu.repaint();
			actualizarJugadores();
			actualizarJugadorActual(nickname);
		} catch (NicknameYaExisteException | IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error al agregar el jugador",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 *
	 * @param nickname
	 */
	public void actualizarJugadorActual(String nickname) {
		if (!nickname.equals("")) {
			NaveJugador actual = mundo.buscarJugador(nickname);
			mundo.setJugadorActual(actual);
			panelMenu.repaint();
		} else
			JOptionPane.showMessageDialog(this, "Por favor cree algún jugador", "No existen jugadores",
					JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 *
	 * @param nombre
	 */
	public void actualizarPartidaActual(String nombre) {

		Partida partidaActual = mundo.getJugadorActual().getPartidaRaiz().buscarPartida(nombre);
		mundo.setPartidaActual(partidaActual);
		panelNivel.setPartida(partidaActual);
		iniciarTodosLosHilos();

	}

	/**
	 *
	 */
	public void actualizarJugadores() {
		ArrayList<NaveJugador> jugadores = mundo.getJugadores();
		if (jugadores == null)
			jugadores = new ArrayList<>();
		panelMenu.getDialogoSeleccionarJugador().cambiarListaJugadores(jugadores);
	}

	/**
	 *
	 */
	public void actualizarPartidas() {
		ArrayList<Partida> partidas = mundo.darPartidasJugador();
		if (partidas.size() == 0)
			partidas = new ArrayList<Partida>();
		panelMenu.getDialogoSeleccionarPartida().cambiarListaPartidas(partidas);
	}

	/**
	 *
	 */
	public void nivelCompleto () {
		try {
			if (mundo.getPartidaActual().nivelCompleto()) {
				iniciarTodosLosHilos();
			} else {
				panelMenu.repaint();
				mundo.eliminarPartida();
				actualizarPartidas();
				cambiarPanel("Menu");
				panelMenu.repaint();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	public void perder(){
		panelMenu.repaint();
		try {
			mundo.eliminarPartida();
		} catch (IOException e) {
			e.printStackTrace();
		}
		actualizarPartidas();
		cambiarPanel("Menu");
		panelMenu.repaint();
	}

	/**
	 *
	 */
	public void ordenarJugadores() {
		ArrayList<NaveJugador> jugadores = mundo.ordenarPorNickname();
		if (jugadores == null)
			jugadores = new ArrayList<>();
		panelMenu.getDialogoSeleccionarJugador().cambiarListaJugadores(jugadores);
	}

	/**
	 *
	 * @param nickname
	 */
	public void loginRapido(String nickname){
		if(!mundo.busquedaRapida(nickname)){
			JOptionPane.showMessageDialog(null, "El jugador con el nickname " + nickname + " no existe",
					"Jugador no encontrado", JOptionPane.ERROR_MESSAGE);
		}
		panelMenu.repaint();
	}

	/**
	 *
	 */
	public void mejoresPuntajes(){
		panelMenu.setDialogoMejoresPuntajes(new DialogoMejoresPuntajes(this,mundo.mejoresPuntajes()));
		panelMenu.getDialogoMejoresPuntajes().mostrar();
	}


	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		InterfazSpaceInvaders ventana = new InterfazSpaceInvaders();
		ventana.setVisible(true);
	}

}
