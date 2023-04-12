package com.javeriana.interfaz;

import com.javeriana.InterfazSpaceInvaders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;

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
		labNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 18));
		labNombre.setBounds(10, 60, 350, 20);

		txtNombre = new JTextField("Tu Nombre");
		txtNombre.setBackground(Color.orange);
		txtNombre.setBounds(10, 85, 205, 25);
		txtNombre.setForeground(Color.BLUE);
		txtNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));

		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNombre.getText().equals("Tu Nombre")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.BLUE);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNombre.getText().equals("")) {
					txtNombre.setText("Tu Nombre");
					txtNombre.setForeground(Color.GRAY);
				}
			}
		});

		labNickname = new JLabel("NICKNAME");
		labNickname.setForeground(Color.red);
		labNickname.setFont(new Font("ArcadeClassic", Font.PLAIN, 18));
		labNickname.setBounds(10, 150, 260, 20);

		txtNickame = new JTextField("Gamersito");
		txtNickame.setBackground(Color.orange);
		txtNickame.setBounds(10, 180, 150, 25);
		txtNickame.setForeground(Color.GRAY);
		txtNickame.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));
		txtNickame.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNickame.getText().equals("Gamersito")) {
					txtNickame.setText("");
					txtNickame.setForeground(Color.BLUE);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNickame.getText().equals("")) {
					txtNickame.setText("Gamersito");
					txtNickame.setForeground(Color.GRAY);
				}
			}
		});

		JLabel imagen = new JLabel();
		ImageIcon icono = new ImageIcon("./data/imagenes/fondAgJ.jpg");
		imagen.setIcon(icono);
		imagen.setBounds(0, 0, icono.getIconWidth(), icono.getIconHeight());

		butBotonAceptar = new JButton(ACEPTAR);
		butBotonAceptar.setActionCommand(ACEPTAR);
		butBotonAceptar.addActionListener(this);
		butBotonAceptar.setBounds(10, 210, 130, 25);
		butBotonAceptar.setBackground(Color.BLUE);
		butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonAceptar.setForeground(Color.WHITE);
		butBotonAceptar.setBorderPainted(false);
		butBotonAceptar.setOpaque(true);

		butBotonCancelar = new JButton(CANCELAR);
		butBotonCancelar.setActionCommand(CANCELAR);
		butBotonCancelar.addActionListener(this);
		butBotonCancelar.setBounds(10, 350, 130, 25);
		butBotonCancelar.setBackground(Color.ORANGE);
		butBotonCancelar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonCancelar.setForeground(Color.WHITE);
		butBotonCancelar.setBorderPainted(false);
		butBotonCancelar.setOpaque(true);

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
