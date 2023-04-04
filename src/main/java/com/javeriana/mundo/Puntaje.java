package com.javeriana.mundo;

import java.io.Serializable;

/**
 * 
 * 
 * @author Manuel Alejandro Coral Lozano - Juan Sebasti�n Quintero Yoshioka
 *         Proyecto final - Algoritmos y programaci�n II.
 */
public class Puntaje implements Serializable {

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private int puntuacion;

	/**
	 * 
	 */
	private String nickname;

	/**
	 * 
	 */
	private String nombrePartida;

	/**
	 * 
	 */
	private Puntaje siguiente;

	private Puntaje anterior;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param puntuacion
	 * @param nombreJugador
	 */
	public Puntaje(int puntuacion, String nickname, String nombrePartida) {
		this.puntuacion = puntuacion;
		this.nickname = nickname;
		this.nombrePartida = nombrePartida;
	}

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @return
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}

	/**
	 * 
	 * @param puntuacion
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = this.puntuacion + puntuacion;
	}

	public String getNickname() {
		return this.nickname;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 
	 * @return
	 */
	public Puntaje getSiguiente() {
		return siguiente;
	}

	/**
	 * 
	 * @param siguiente
	 */
	public void setSiguiente(Puntaje siguiente) {
		this.siguiente = siguiente;
	}

	
	
	public Puntaje getAnterior() {
		return anterior;
	}

	public void setAnterior(Puntaje anterior) {
		this.anterior = anterior;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombrePartida() {
		return nombrePartida;
	}

	/**
	 * 
	 * @param nombrePartida
	 */
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}

	@Override
	public String toString() {
		String puntos = puntuacion + "";
		return "" + puntos + " " + nickname + " " + nombrePartida;
	}

}
