package com.javeriana.interfaz;

import com.javeriana.InterfazSpaceInvaders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 * Panel que contiene el Menu principal del juego
 *
 * @author Juan Sebasti�n Quintero Yoshioka - Manuel Alejandro Coral Lozano
 *         Proyecto final - Algoritmos y programaci�n II
 */
public class PanelMenu extends JPanel implements ActionListener {

	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private final static String CREAR_JUGADOR = "CREAR JUGADOR";

	/**
	 *
	 */
	private final static String SELECCIONAR_JUGADOR = "SELECCIONAR JUGADOR";

	/**
	 *
	 */
	private final static String CREAR_PARTIDA = "CREAR PARTIDA";

	/**
	 *
	 */
	private final static String SELECCIONAR_PARTIDA = "SELECCIONAR PARTIDA";

	/**
	 *
	 */
	private final static String INTRUCCIONES = "INSTRUCCIONES";
	// -----------------------------------------------------------------
	// --------------------------Asociaciones---------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	InterfazSpaceInvaders interfaz;

	// -----------------------------------------------------------------
	// ---------------------------Atributos-----------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	DialogoCrearJugador dialogoCrearJugador;

	/**
	 *
	 */
	DialogoSeleccionarJugador dialogoSeleccionarJugador;

	/**
	 *
	 */
	DialogoCrearPartida dialogoCrearPartida;

	/**
	 *
	 */
	DialogoSeleccionarPartida dialogoSeleccionarPartida;

	/**
	 *
	 */
	DialogoInstrucciones dialogoInstrucciones;

	/**
	 *
	 */
	DialogoMejoresPuntajes dialogoMejoresPuntajes;

	/**
	 *
	 */
	JPopupMenu popMenuJugar;

	/**
	 *
	 */
	JMenuItem menuCrearPartida;

	/**
	 *
	 */
	JMenuItem menuCargarPartida;

	/**
	 *
	 */
	JPopupMenu popMenuJugador;

	/**
	 *
	 */
	JMenuItem menuNuevoJugador;

	/**
	 *
	 */
	JMenuItem menuSeleccionarJugador;

	/**
	 *
	 */
	JLabel labOpenMenuJugar;

	/**
	 *
	 */
	JLabel labOpenMenuJugador;


	JLabel labLoginRapido;

	/**
	 *
	 */
	JLabel labMejoresPuntajes;

	/**
	 *
	 */
	JLabel labInstrucciones;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param interfaz
	 */
	public PanelMenu(InterfazSpaceInvaders interfaz) {

		// Inicializa la asociaci�n
		this.interfaz = interfaz;

		// Establece el tama�o, la contenedora de tama�o y le quita el fondo que
		// trae por defecto.
		setPreferredSize(new Dimension(640, 480));
		setLayout(null);
		setOpaque(false);

		// T�tulo del juego: "SPACE INVADERS"
		JLabel space = new JLabel("SPACE INVADERS");
		space.setForeground(Color.WHITE);
		space.setFont(new Font("ArcadeClassic", Font.BOLD, 60));
		space.setBounds(5, 75, 560, 80);
		add(space);

		// Inicializa los 4 di�logos que se puede ver en el Menu
		dialogoCrearJugador = new DialogoCrearJugador(interfaz);
		dialogoCrearPartida = new DialogoCrearPartida(interfaz);
		dialogoSeleccionarJugador = new DialogoSeleccionarJugador(interfaz);
		dialogoSeleccionarPartida = new DialogoSeleccionarPartida(interfaz);
		dialogoInstrucciones = new DialogoInstrucciones(interfaz);

		// Popup Menu Jugar
		popMenuJugar = new JPopupMenu();

		// Item1 de Menu Jugar
		menuCrearPartida = new JMenuItem("CREAR PARTIDA");
		menuCrearPartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

		// Item2 de Menu Jugar
		menuCargarPartida = new JMenuItem("CARGAR PARTIDA");
		menuCargarPartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

		// A�adir los action listener a los item's de Menu Jugar
		menuCrearPartida.addActionListener(this);
		menuCrearPartida.setActionCommand(CREAR_PARTIDA);
		menuCargarPartida.addActionListener(this);
		menuCargarPartida.setActionCommand(SELECCIONAR_PARTIDA);

		// Agregar al Menu Jugar los Item's
		popMenuJugar.add(menuCrearPartida);
		popMenuJugar.add(menuCargarPartida);

		// Popup Menu Jugador
		popMenuJugador = new JPopupMenu();

		// Item1 de Menu Jugador
		menuNuevoJugador = new JMenuItem("NUEVO JUGADOR");
		menuNuevoJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));
		menuNuevoJugador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Item2 de Menu Jugador
		menuSeleccionarJugador = new JMenuItem("SELECCIONAR JUGADOR");
		menuSeleccionarJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));
		menuSeleccionarJugador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// A�adir los action listener a los Item's de Menu Jugador
		menuNuevoJugador.addActionListener(this);
		menuNuevoJugador.setActionCommand(CREAR_JUGADOR);
		menuSeleccionarJugador.addActionListener(this);
		menuSeleccionarJugador.setActionCommand(SELECCIONAR_JUGADOR);

		// Agregar al Menu Jugar los Item's
		popMenuJugador.add(menuNuevoJugador);
		popMenuJugador.add(menuSeleccionarJugador);

		// TODO
		// Inicio temporal

		// JLabel de las mejoras
		labLoginRapido = new JLabel("LOGIN RAPIDO");
		labLoginRapido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labLoginRapido.setForeground(Color.WHITE);
		labLoginRapido.setBounds(10, 300, 400, 23);
		labLoginRapido.setFont(new Font("ArcadeClassic", Font.PLAIN, 28));
		add(labLoginRapido);
		labLoginRapido.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String respuesta = 	JOptionPane.showInputDialog(null, "Por favor ingresa tu nickname", "Login r�pido", JOptionPane.DEFAULT_OPTION);
				if(respuesta == null || respuesta.equals("")){
					JOptionPane.showMessageDialog(null, "Por favor ingresar un nickname v�lido",
							"Error al escribir el nickname", JOptionPane.ERROR_MESSAGE);
				} else if(respuesta.length() != 5){
					JOptionPane.showMessageDialog(null, "Recuerde que el nickname contiene 5 d�gitos",
							"Error al escribir el nickname", JOptionPane.ERROR_MESSAGE);
				} else
					interfaz.loginRapido(respuesta);
			}
		});

		//Fin temporal

		// Boton Open Menu Jugar
		labOpenMenuJugar = new JLabel("JUGAR");
		labOpenMenuJugar.setToolTipText("Crea una nueva partida o continua en una existente.");
		labOpenMenuJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labOpenMenuJugar.setBounds(10, 240, 190, 23);
		labOpenMenuJugar.setFont(new Font("ArcadeClassic", Font.PLAIN, 28));
		labOpenMenuJugar.setForeground(Color.WHITE);
		labOpenMenuJugar.setAlignmentX(RIGHT_ALIGNMENT);
		labOpenMenuJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popMenuJugar.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		add(labOpenMenuJugar);

		// Boton Open Menu Jugador
		labOpenMenuJugador = new JLabel("JUGADOR");
		labOpenMenuJugador.setToolTipText("Agrega y/o selecciona un jugador");
		labOpenMenuJugador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labOpenMenuJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 28));
		labOpenMenuJugador.setBounds(10, 270, 190, 23);
		labOpenMenuJugador.setForeground(Color.WHITE);
		labOpenMenuJugador.setAlignmentX(RIGHT_ALIGNMENT);
		labOpenMenuJugador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popMenuJugador.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		add(labOpenMenuJugador);

		// JLabel de los mejores puntajes
		labMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
		labMejoresPuntajes.setToolTipText("Listado con los mejores puntajes");
		labMejoresPuntajes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labMejoresPuntajes.setForeground(Color.WHITE);
		labMejoresPuntajes.setFont(new Font("ArcadeClassic", Font.PLAIN, 28));
		labMejoresPuntajes.setBounds(10, 360, 400, 23);
		add(labMejoresPuntajes);
		labMejoresPuntajes.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				interfaz.mejoresPuntajes();
			}
		});


		// JLabel con las intrucciones
		labInstrucciones = new JLabel("INSTRUCCIONES");
		labInstrucciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labInstrucciones.setToolTipText("Instrucciones del Juego");
		labInstrucciones.setForeground(Color.WHITE);
		labInstrucciones.setFont(new Font("ArcadeClassic", Font.PLAIN, 28));
		labInstrucciones.setBounds(10, 330, 400, 23);
		labInstrucciones.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dialogoInstrucciones.mostrar();
			}
		});
		// labInstrucciones.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// dialogoInstrucciones.mostrar();
		// }
		// });
		add(labInstrucciones);
	}

	// -----------------------------------------------------------------
	// ----------------------Manejador de eventos-----------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals(CREAR_JUGADOR)) {
			dialogoCrearJugador.mostrar();
		} else if (comando.equals(SELECCIONAR_JUGADOR)) {
			interfaz.actualizarJugadores();
			dialogoSeleccionarJugador.mostrar();
		}

		else if (comando.equals(CREAR_PARTIDA))
			if (interfaz.getJugadorActual() != null)
				dialogoCrearPartida.mostrar();
			else
				JOptionPane.showMessageDialog(this, "Por favor crear o seleccionar un jugador",
						"Error al iniciar partida", JOptionPane.ERROR_MESSAGE);

		else if (comando.equals(SELECCIONAR_PARTIDA)) {
			if (interfaz.getJugadorActual() != null) {
				interfaz.actualizarPartidas();
				dialogoSeleccionarPartida.mostrar();
			} else
				JOptionPane.showMessageDialog(this, "Por favor crear o seleccionar un jugador",
						"Error al seleccionar la partida", JOptionPane.ERROR_MESSAGE);

		}
	}

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	public DialogoSeleccionarJugador getDialogoSeleccionarJugador() {
		return dialogoSeleccionarJugador;
	}

	/**
	 *
	 * @return
	 */
	public DialogoSeleccionarPartida getDialogoSeleccionarPartida() {
		return dialogoSeleccionarPartida;
	}


	/**
	 *
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// Pinta la imagen de fondo
		ImageIcon fondo = new ImageIcon("./data/imagenes/menu2.png");
		g2.drawImage(fondo.getImage(), 0, 0, getSize().width, getSize().height, null);

		// Dibuja el nickname, nombre y monedas del jugador actual del juego.
		g2.setColor(Color.GREEN);
		g2.setFont(new Font("ArcadeClassic", Font.PLAIN, 24));
		g2.drawString("NICKNAME", 30, 40);
		g2.drawString("JUGADOR", 170, 40);

		g2.setColor(Color.RED);
		if (interfaz.getJugadorActual() != null) {

			g2.drawString(interfaz.getJugadorActual().getNickname(), 30, 60);

			if (interfaz.getJugadorActual().getNombre().length() <= 13)
				g2.drawString(interfaz.getJugadorActual().getNombre(), 170, 60);
			else
				g2.drawString(interfaz.getJugadorActual().getNombre().substring(0, 13), 170, 60);

		}
	}

	public DialogoMejoresPuntajes getDialogoMejoresPuntajes() {
		return dialogoMejoresPuntajes;
	}

	public void setDialogoMejoresPuntajes(DialogoMejoresPuntajes dialogoMejoresPuntajes) {
		this.dialogoMejoresPuntajes = dialogoMejoresPuntajes;
	}
}
