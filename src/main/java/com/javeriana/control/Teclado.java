package com.javeriana.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.javeriana.InterfazSpaceInvaders;
import com.javeriana.commands.ICommand;
import com.javeriana.commands.InvokerCommand;
import com.javeriana.commands.Receiver;
import com.javeriana.commands.impl.CloseGameCommand;
import com.javeriana.commands.impl.PauseCommand;
import com.javeriana.commands.impl.PlayCommand;
import com.javeriana.mundo.NaveJugador;
import com.javeriana.mundo.SpaceInvaders;

/**
 * 
 * @author Manuel Alejandro Coral Lozano - Juan Sebasti�n Quintero Yoshioka
 *         Proyecto final - Algoritmos y programaci�n II.
 */
public class Teclado implements KeyListener, IKeyBoard {

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	// public Partida actu;

	private SpaceInvaders actu;

	public NaveJugador navesita;

	public InterfazSpaceInvaders interfaz;

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	public Teclado(InterfazSpaceInvaders principal, SpaceInvaders actual) {
		// TODO Auto-generated constructor stub
		interfaz = principal;
		actu = actual;
		navesita = actu.getJugadorActual();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		InvokerCommand invokerCommand = new InvokerCommand();
		Receiver receiver = new Receiver(interfaz);

		if (actu.getEnFuncionamiento()) {
			navesita = actu.getJugadorActual();
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {

				if (navesita.getDisparoUno() == null) {
					navesita.disparar(interfaz.darPosActualJugador(), 410);
					interfaz.startHiloJugador();
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				navesita.mover(-1);
				interfaz.getPanelNivel().updateUI();
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				navesita.mover(1);
				interfaz.getPanelNivel().updateUI();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			invokerCommand.executeCommand(new CloseGameCommand(receiver));
		}
		
		if (e.getKeyCode() == KeyEvent.VK_P) {

			if (interfaz.estaEnPausa()) {
				invokerCommand.executeCommand(new PlayCommand(receiver));
			} else {
				invokerCommand.executeCommand(new PauseCommand(receiver));
			}
		}
	}

	/**
	 * 
	 */
	public void keyReleased(KeyEvent e) {

	}

	/**
	 * 
	 */
	public void keyTyped(KeyEvent e) {

	}

}
