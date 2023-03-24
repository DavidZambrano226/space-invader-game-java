package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoMejoresPuntajes extends JDialog implements ActionListener {

	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	public final static String ACEPTAR = "Aceptar";

	// -----------------------------------------------------------------
	// --------------------------Asociaciones---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	InterfazSpaceInvaders interfaz;

	/**
	 * 
	 */
	JPanel auxiliar;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	JButton butBotonAceptar;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param interfaz
	 */
	public DialogoMejoresPuntajes(InterfazSpaceInvaders interfaz, ArrayList<String> puntajes) {

		super(interfaz, false);

		this.interfaz = interfaz;
		setLayout(null);

		auxiliar = new JPanel();
		auxiliar.setLayout(null);

		butBotonAceptar = new JButton(ACEPTAR);
		butBotonAceptar.setActionCommand(ACEPTAR);
		butBotonAceptar.addActionListener(this);
		butBotonAceptar.setBounds(235, 360, 130, 25);
		butBotonAceptar.setBackground(Color.BLACK);
		butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonAceptar.setForeground(Color.YELLOW);

		auxiliar.setSize(600,400);
		auxiliar.add(butBotonAceptar);

		auxiliar.setBackground(Color.BLACK);

		setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		setForeground(Color.RED);

		JLabel labPosicion = new JLabel("POSICION");
		labPosicion.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labPosicion.setForeground(Color.GREEN);
		labPosicion.setBounds(10, 10, 100, 25);
		auxiliar.add(labPosicion);
		
		JLabel labPuntaje = new JLabel("PUNTAJE");
		labPuntaje.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labPuntaje.setForeground(Color.GREEN);
		labPuntaje.setBounds(110, 10, 200, 25);
		auxiliar.add(labPuntaje);
		
		JLabel labNickname = new JLabel("NICKNAME");
		labNickname.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labNickname.setForeground(Color.GREEN);
		labNickname.setBounds(200, 10, 300, 25);
		auxiliar.add(labNickname);
		
		JLabel labNombrePartida = new JLabel("PARTIDA");
		labNombrePartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labNombrePartida.setForeground(Color.GREEN);
		labNombrePartida.setBounds(310, 10, 400, 25);
		auxiliar.add(labNombrePartida);
	
		int x = 10;
		int y = 30;

		JLabel numero;
		JLabel puntaje;
		JLabel nickname;
		JLabel partida;
		
		if(puntajes != null){
			for(int i = 0; i < puntajes.size(); i++){
				
				String[] informacion = puntajes.get(i).split(" ");
				
				numero = new JLabel();
				puntaje = new JLabel();
				nickname = new JLabel();
				partida = new JLabel();
		
				numero.setText(informacion[0]);
				puntaje.setText(informacion[1]);
				nickname.setText(informacion[2]);
				partida.setText(informacion[3]);
				
				numero.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
				numero.setForeground(Color.WHITE);
				puntaje.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
				puntaje.setForeground(Color.WHITE);
				nickname.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
				nickname.setForeground(Color.WHITE);
				partida.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
				partida.setForeground(Color.WHITE);
				
				numero.setBounds(x, y, 100, 25);
				puntaje.setBounds(x + 100, y, 210, 30);
				nickname.setBounds(x + 190, y, 300, 25);
				partida.setBounds(x + 300, y, 400, 25);
			
				auxiliar.add(numero);
				auxiliar.add(puntaje);
				auxiliar.add(nickname);
				auxiliar.add(partida);
				
				y = y + 30;

			}
		}
		add(auxiliar);
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

		if (comando.equals(ACEPTAR)) {
			this.dispose();
		}
	}
	// -----------------------------------------------------------------
	// -----------------------------Métodos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	public void mostrar() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
