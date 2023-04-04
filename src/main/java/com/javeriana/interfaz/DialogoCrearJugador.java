package com.javeriana.interfaz;

import com.javeriana.InterfazSpaceInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author squin
 *
 */
public class DialogoCrearJugador extends JDialog implements ActionListener {

	private static DialogoCrearJugador instance;
	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private final static String ACEPTAR = "Aceptar";
	private final static String CANCELAR = "Cancelar";

	// -----------------------------------------------------------------
	// --------------------------Asociaciones---------------------------
	// -----------------------------------------------------------------

	private InterfazSpaceInvaders interfaz;

	private JPanel auxiliar;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	private JLabel labNombre;

	private JLabel labNickname;

	private JTextField txtNombre;

	private JTextField txtNickame;

	private JButton butBotonAceptar;

	private JButton butBotonCancelar;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	public DialogoCrearJugador(InterfazSpaceInvaders interfaz) {

		super(interfaz, true);
		this.interfaz = interfaz;
		setLayout(null);
		auxiliar = new JPanel();
		auxiliar.setLayout(null);

		labNombre = new JLabel("NOMBRE DEL JUGADOR");
		labNombre.setForeground(Color.RED);
		labNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 33));
		labNombre.setBounds(10, 60, 350, 20);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.orange);
		txtNombre.setBounds(10, 85, 205, 25);
		txtNombre.setForeground(Color.BLUE);
		txtNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));

		labNickname = new JLabel("NICKNAME");
		labNickname.setForeground(Color.red);
		labNickname.setFont(new Font("ArcadeClassic", Font.PLAIN, 33));
		labNickname.setBounds(10, 150, 260, 20);

		txtNickame = new JTextField();
		txtNickame.setBackground(Color.orange);
		txtNickame.setBounds(10, 180, 150, 25);
		txtNickame.setForeground(Color.BLUE);
		txtNickame.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));

		JLabel imagen = new JLabel();
		ImageIcon icono = new ImageIcon("./data/imagenes/fondAgJ.jpg");
		imagen.setIcon(icono);
		imagen.setBounds(0, 0, icono.getIconWidth(), icono.getIconHeight());

		butBotonAceptar = new JButton(ACEPTAR);
		butBotonAceptar.setActionCommand(ACEPTAR);
		butBotonAceptar.addActionListener(this);
		butBotonAceptar.setBounds(10, 210, 130, 25);
		butBotonAceptar.setBackground(Color.BLACK);
		butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonAceptar.setForeground(Color.YELLOW);

		butBotonCancelar = new JButton(CANCELAR);
		butBotonCancelar.setActionCommand(CANCELAR);
		butBotonCancelar.addActionListener(this);
		butBotonCancelar.setBounds(10, 350, 130, 25);
		butBotonCancelar.setBackground(Color.BLACK);
		butBotonCancelar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonCancelar.setForeground(Color.green);

		auxiliar.setSize(icono.getIconWidth(), icono.getIconHeight());
		auxiliar.add(labNombre);
		auxiliar.add(txtNombre);
		auxiliar.add(labNickname);
		auxiliar.add(txtNickame);
		auxiliar.add(butBotonAceptar);
		auxiliar.add(butBotonCancelar);
		auxiliar.add(imagen);

		setTitle("Crear Jugador");
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	public static DialogoCrearJugador getInstance(InterfazSpaceInvaders interfaz) {
		if (instance == null) {
			instance = new DialogoCrearJugador(interfaz);
		}
		return instance;
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
		switch (comando) {
			case CANCELAR:
				this.dispose();
				break;
			case ACEPTAR:
				if (isValidInput()) {
					interfaz.reqAgregarJugador(txtNombre.getText(), txtNickame.getText());
					this.dispose();
				}
				break;
		}
	}

	private boolean isValidInput() {
		String nombre = txtNombre.getText();
		String nickname = txtNickame.getText();
		if (nombre == null || nombre.trim().isEmpty() || nickname == null || nickname.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre y un nickname válido",
					"Error al crear el jugador", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (nickname.length() != 5) {
			JOptionPane.showMessageDialog(this, "El nickname debe contener 5 caracteres",
					"Error al asignar el nickname", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	// Fin temporal
	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	public void mostrar() {
		setSize(400, 400);
		add(auxiliar);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
