package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mundo.NaveJugador;

public class DialogoSeleccionarJugador extends JDialog implements ListSelectionListener, ActionListener {

	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------
	
	/**
	 * 
	 */
	private final static String ORDENAR = "Ordenar";

	private JButton butOrdenar;
	// Fin temporal

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private final static String ACEPTAR = "Aceptar";

	/**
	 * 
	 */
	private final static String CANCELAR = "Cancelar";

	// -----------------------------------------------------------------
	// --------------------------Asociaciones---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private InterfazSpaceInvaders interfaz;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private JList jugadores;

	/**
	 * 
	 */
	private JScrollPane scroll;

	/**
	 * 
	 */
	JButton butBotonAceptar;

	/**
	 * 
	 */
	JButton butBotonCancelar;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param interfaz
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DialogoSeleccionarJugador(InterfazSpaceInvaders interfaz) {

		super(interfaz, true);
		setLayout(new BorderLayout());

		this.interfaz = interfaz;
		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(240, 200));
		jugadores = new JList();
		jugadores.addListSelectionListener(this);
		jugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jugadores.setModel(new DefaultListModel());
		scroll.getViewport().add(jugadores);
		jugadores.setBackground(Color.BLACK);
		jugadores.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		jugadores.setForeground(Color.BLUE);
		scroll.setBackground(Color.BLACK);
		add(scroll, BorderLayout.CENTER);

		butBotonAceptar = new JButton(ACEPTAR);
		butBotonAceptar.setActionCommand(ACEPTAR);
		butBotonAceptar.addActionListener(this);
		butBotonAceptar.setBounds(5, 2, 130, 25);
		butBotonAceptar.setBackground(Color.BLACK);
		butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonAceptar.setForeground(Color.YELLOW);

		butBotonCancelar = new JButton(CANCELAR);
		butBotonCancelar.setActionCommand(CANCELAR);
		butBotonCancelar.addActionListener(this);
		butBotonCancelar.setBounds(140, 2, 130, 25);
		butBotonCancelar.setBackground(Color.BLACK);
		butBotonCancelar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonCancelar.setForeground(Color.green);

		butOrdenar = new JButton("ORDENAR");
		butOrdenar.addActionListener(this);
		butOrdenar.setActionCommand(ORDENAR);
		butOrdenar.setBounds(275, 2, 130, 25);
		butOrdenar.setBackground(Color.BLACK);
		butOrdenar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butOrdenar.setForeground(Color.BLUE);

		this.setBackground(Color.BLACK);
		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(null);
		auxiliar.setBackground(Color.BLACK);
		auxiliar.add(butBotonAceptar);
		auxiliar.add(butBotonCancelar);
		auxiliar.add(butOrdenar);
		auxiliar.setPreferredSize(new Dimension(240, 28));
		add(auxiliar, BorderLayout.SOUTH);

		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));

		// Fin temporal

	}

	// -----------------------------------------------------------------
	// ----------------------Manejador de eventos-----------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(CANCELAR))
			this.dispose();
		else if (comando.equals(ACEPTAR)) {
			if (darJugadorSeleccionado() != "") {
				interfaz.actualizarJugadorActual(darJugadorSeleccionado());
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Por favor cree un jugador", "No existen jugadores",
						JOptionPane.INFORMATION_MESSAGE);
				this.dispose();

			}
	
		} else if (comando.equals(ORDENAR)) {
			interfaz.ordenarJugadores();
		}

	}

	/**
	 * 
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {

	}

	// -----------------------------------------------------------------
	// -----------------------------Métodos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param lista
	 */
	@SuppressWarnings("unchecked")
	public void cambiarListaJugadores(Collection lista) {

		jugadores.setListData(lista.toArray());

		if (jugadores.getModel().getSize() > 0)
			jugadores.setSelectedIndex(0);
	}

	/**
	 * 
	 * @return
	 */
	public String darJugadorSeleccionado() {
		NaveJugador jugador = (NaveJugador) jugadores.getSelectedValue();
		if (jugador != null)
			return (String) jugador.getNickname();
		else
			return "";
	}

	/**
	 * 
	 */
	public void mostrar() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
}