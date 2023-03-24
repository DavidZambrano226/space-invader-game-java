package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mundo.Disparo;
import mundo.NaveJugador;
import mundo.Partida;
import mundo.SpaceInvaders;

public class PanelNivel extends JPanel {

	private Partida partida;
	private SpaceInvaders space;
	private InterfazSpaceInvaders interfaz;

	private int posJugadorActualX;
	private int posJugadorActualY;

	public PanelNivel(Partida actual, SpaceInvaders b, InterfazSpaceInvaders c) {
		// TODO Auto-generated constructor stub
		// BORAR

		partida = actual;
		space = b;
		interfaz = c;

		setSize(640, 480);

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		ImageIcon iconFondo = new ImageIcon("./data/imagenes/fondoJuego.jpg");

		g.drawImage(iconFondo.getImage(), 0, 0, null);

		ImageIcon imagen = new ImageIcon("./data/imagenes/Naves/nave.png");

		g.drawImage(imagen.getImage(), ((NaveJugador) space.getJugadorActual()).getPosInicialX(),
				((NaveJugador) space.getJugadorActual()).getPosIncialY(), imagen.getIconWidth(), imagen.getIconHeight(),
				null);

		posJugadorActualX = (int) ((NaveJugador) space.getJugadorActual()).getPosInicialX();
		posJugadorActualY = (int) ((NaveJugador) space.getJugadorActual()).getPosIncialY();


		//DIBUJAR INFORMACIÓN DEL JUGADOR
		g.setColor(Color.WHITE);
		g.setFont(new Font("ArcadeClassic", Font.PLAIN, 24));
		g.drawString("NICKNAME", 30, 40);
		g.drawString("PUNTUACION ", 250, 40);

		g.setColor(Color.GREEN);
		g.drawString(interfaz.getJugadorActual().getNickname(), 140, 40);
		g.drawString(partida.getPuntaje().getPuntuacion() + "", 400, 40);

		// DISPARO DE LA NAVE
		Disparo a = (Disparo) space.getJugadorActual().getDisparoUno();
		if (a != null) {
			g.setColor(Color.WHITE);
			g.fillOval(a.getPosX() + 13, a.getPosY(), 7, 7);

			if (a.getPosY() == 0 || a.getImpacto()) {
				ImageIcon choque = new ImageIcon("./data/imagenes/Naves/muereBicho.png");
				g.drawImage(choque.getImage(), a.getPosX(), a.getPosY() - 6, null);
			}

		}

		// DISPARO ENEMIGO

		for (int i = 0; i < partida.getEnemigos().length; i++) {
			for (int j = 0; j < partida.getEnemigos()[i].length; j++) {
				if (partida.getEnemigos()[i][j] != null) {
					if (partida.getEnemigos()[i][j].getDisparoUno() != null) {
						Disparo b = (Disparo) partida.getEnemigos()[i][j].getDisparoUno();
						if (b != null) {
							g.setColor(Color.RED);
							g.fillOval(b.getPosX(), b.getPosY(), 7, 7);
						}
					}
				}
			}
		}

		// DIBUJAR ENEMIGOS

		for (int i = 0; i < partida.getEnemigos().length; i++) {
			for (int j = 0; j < partida.getEnemigos()[i].length; j++) {
				if (partida.getEnemigos()[i][j] != null) {
					if (partida.getEnemigos()[i][j] != null) {
						ImageIcon icono = new ImageIcon(partida.getEnemigos()[i][j].getRutaImage());
						g.drawImage(icono.getImage(), partida.getEnemigos()[i][j].getPosX(),
								partida.getEnemigos()[i][j].getPosY(), null);
					}
				}
			}
		}

		if (space.getPartidaActual().terminarNivel()) {
			space.setEnFuncionamiento(false);
			interfaz.matarHilos();
			int bonificacion = (space.puntosPorVida() - space.puntosPorDisparos());
			if (bonificacion > 0)
				space.getPartidaActual().getPuntaje().setPuntuacion(bonificacion);
			interfaz.nivelCompleto();


		}

		// PERDIÓ
		if (space.getJugadorActual().perdio()) {
			space.setEnFuncionamiento(false);	
			interfaz.matarHilos();
			int bonificacion = (space.puntosPorVida() - space.puntosPorDisparos());
			if (bonificacion > 0)
				space.getPartidaActual().getPuntaje().setPuntuacion(bonificacion);
			interfaz.perder();
		}
		
		if (interfaz.estaEnFuncionamiento()) {
			
			g.drawString("Vidas jugador" + space.getJugadorActual().getVida(), 100, 470);
			
		}
		
	}

	public int getPosJugadorActualX() {
		return posJugadorActualX;
	}

	public int getPosJugadorActualY() {
		return posJugadorActualY;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

}
