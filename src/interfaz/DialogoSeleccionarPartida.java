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

import mundo.Partida;

public class DialogoSeleccionarPartida extends JDialog implements ListSelectionListener, ActionListener {

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
	private JList partidas;

	/**
	 * 
	 */
	private JScrollPane scroll;

	/**
	 * 
	 */
	JButton butBotonAceptar, butBotonCancelar;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param interfaz
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DialogoSeleccionarPartida(InterfazSpaceInvaders interfaz) {

		super(interfaz, true);
		setLayout(new BorderLayout());

		this.interfaz = interfaz;
		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(230, 200));
		partidas = new JList();
		partidas.addListSelectionListener(this);
		partidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		partidas.setModel(new DefaultListModel());
		scroll.getViewport().add(partidas);
		partidas.setBackground(Color.BLACK);
		partidas.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		partidas.setForeground(Color.BLUE);
		scroll.setBackground(Color.BLACK);
		add(scroll, BorderLayout.CENTER);

		butBotonAceptar = new JButton(ACEPTAR);
		butBotonAceptar.setActionCommand(ACEPTAR);
		butBotonAceptar.addActionListener(this);
		butBotonAceptar.setBounds(60, 2, 130, 25);
		butBotonAceptar.setBackground(Color.BLACK);
		butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonAceptar.setForeground(Color.YELLOW);

		butBotonCancelar = new JButton(CANCELAR);
		butBotonCancelar.setActionCommand(CANCELAR);
		butBotonCancelar.addActionListener(this);
		butBotonCancelar.setBounds(210, 2, 130, 25);
		butBotonCancelar.setBackground(Color.BLACK);
		butBotonCancelar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonCancelar.setForeground(Color.green);

		this.setBackground(Color.BLACK);
		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(null);
		auxiliar.setBackground(Color.BLACK);
		auxiliar.add(butBotonAceptar);
		auxiliar.add(butBotonCancelar);
		auxiliar.setPreferredSize(new Dimension(230, 28));
		add(auxiliar, BorderLayout.SOUTH);

		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));
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
			String partidaSeleccionada = darPartidaSeleccionada();
			if (!partidaSeleccionada.equals("")) {
				interfaz.actualizarPartidaActual(partidaSeleccionada);
				this.dispose();
				interfaz.cambiarPanel("Juego");
			} else {
				JOptionPane.showMessageDialog(this, "Por favor cree una partida para el jugaodor",
						"No existen partidas", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}

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
	public void cambiarListaPartidas(Collection lista) {

		partidas.setListData(lista.toArray());

		if (partidas.getModel().getSize() > 0)
			partidas.setSelectedIndex(0);
	}

	/**
	 * 
	 * @return
	 */
	public String darPartidaSeleccionada() {
		Partida partida = (Partida) partidas.getSelectedValue();
		if (partida != null)
			return (String) partida.getNombre();
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
