package mundo;

import java.io.Serializable;

public class Disparo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean impacto;

	private int posX;

	private int posY;

	public Disparo(int posX, int posY) {
		// TODO Auto-generated constructor stub

		this.posX = posX;
		this.posY = posY;
		impacto = false;

	}

	public boolean getImpacto() {
		return this.impacto;
	}

	public void setImpacto(boolean impacto) {
		this.impacto = impacto;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void shoot() {
		this.posY = this.posY - 1;
	}

	public void shoot1() {
		this.posY = this.posY + 5;
	}

	public boolean hitsEnemigo(Enemigo a) {
		boolean salida = false;
		int r = 8;
		if (a != null) {
			double cateto = this.posX - a.getPosX();
			double cateto2 = this.posY - a.getPosY();
			double d = Math.sqrt((cateto * cateto) + (cateto2 * cateto2));

			if (d < (r + a.getAncho())) {
				salida = true;
			}
		}
		return salida;
	}

	public boolean hitsJugador(NaveJugador a) {

		boolean salida = false;

		if (a != null) {

			double cateto = posX - a.getPosInicialX();
			double cateto2 = posY - a.getPosIncialY();
			double d = Math.sqrt((cateto * cateto) + (cateto2 * cateto2));

			if (d < a.getAncho() + 8 && posY == a.getPosIncialY()
					&& (posX < a.getPosInicialX() + 35 && posX > a.getPosInicialX() - 10)) {
				salida = true;
			}
		}

		return salida;
	}

}
