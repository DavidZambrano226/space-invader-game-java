package interfaz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DialogoInstrucciones extends JDialog implements ListSelectionListener, ActionListener {
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
	JButton butBotonAceptar;

	/**
	 * 
	 * @param interfaz
	 */
	JPanel auxiliar;

	public DialogoInstrucciones(InterfazSpaceInvaders interfaz) {

		super(interfaz, true);

		setLayout(null);

		butBotonAceptar = new JButton(ACEPTAR);
		butBotonAceptar.setActionCommand(ACEPTAR);
		butBotonAceptar.addActionListener(this);
		butBotonAceptar.setBounds(235, 270, 130, 25);
		butBotonAceptar.setBackground(Color.BLACK);
		butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonAceptar.setForeground(Color.BLUE);

		add(butBotonAceptar);

		setUndecorated(true);

		Color color = new Color(28, 28, 28);

		getContentPane().setBackground(color);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if (comando.equals(ACEPTAR)) {
			dispose();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
	}

	/**
	 * 
	 */
	public void mostrar() {
		setSize(600, 300);
		setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);

		// Dibujo de las teclas del teclado.
		g2.fillRect(50, 150, 50, 50);
		g2.fillRect(110, 150, 50, 50);
		g2.fillRect(170, 150, 50, 50);
		g2.fillRect(110, 90, 50, 50);

		// Dibuja la nave
		ImageIcon icono = new ImageIcon("./data/imagenes/Naves/nave.png");
		g2.drawImage(icono.getImage(), 110, 40, 50, 30, null);

		// Dibuja las flechas de la nave que indica movimiento
		g2.setColor(Color.GRAY);
		int[] x4 = { 75, 55, 75 };
		int[] y4 = { 40, 55, 70 };
		g2.fillPolygon(x4, y4, 3);

		int[] x5 = { 195, 215, 195 };
		int[] y5 = { 40, 55, 70 };
		g2.fillPolygon(x5, y5, 3);

		int[] x6 = { 75, 105, 105, 75 };
		int[] y6 = { 47, 47, 63, 63 };
		g2.fillPolygon(x6, y6, 4);

		int[] x7 = { 165, 195, 195, 165 };
		int[] y7 = { 47, 47, 63, 63 };
		g2.fillPolygon(x7, y7, 4);

		// Intrucción para mover
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("ArcadeClassic", Font.PLAIN, 18));
		g2.drawString("USE LAS FLECHAS DE", 60, 230);
		g2.drawString("DIRRECION PARA MOVERSE", 35, 250);

		// Dibuja las flechas
		g2.setColor(Color.WHITE);

		int[] x2 = { 85, 65, 85 };
		int[] y2 = { 160, 175, 190 };
		g2.fillPolygon(x2, y2, 3);

		int[] x3 = { 185, 205, 185 };
		int[] y3 = { 160, 175, 190 };
		g2.fillPolygon(x3, y3, 3);

		g2.setColor(Color.GRAY);

		int[] x = { 120, 135, 150 };
		int[] y = { 125, 105, 125 };
		g2.fillPolygon(x, y, 3);

		int[] x1 = { 120, 135, 150 };
		int[] y1 = { 165, 185, 165 };
		g2.fillPolygon(x1, y1, 3);

		// Dibujo de la barra espaceadora
		g2.setColor(Color.BLACK);
		g2.fillRect(320, 150, 260, 50);

		// Nombre de la barra espaceadora
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("ArcadeClassic", Font.PLAIN, 25));
		g2.drawString("SPACE", 340, 190);

		// Intrucción para disparar
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("ArcadeClassic", Font.PLAIN, 18));
		g2.drawString("DISPARA CON LA", 390, 230);
		g2.drawString("BARRA ESPACEADORA", 365, 250);

		// Dibuja la nave con el disparo
		g2.drawImage(icono.getImage(), 425, 100, 50, 30, null);
		g2.setStroke(new BasicStroke(4.0f));
		g2.drawLine(450, 80, 450, 90);
		g2.drawLine(460, 55, 460, 65);

	}

}
