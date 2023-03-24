package hilos;

import interfaz.InterfazSpaceInvaders;
import mundo.Partida;

public class HiloAuxiliarCreaDisparo extends Thread {

	private Partida partidaEnemigos;
	private InterfazSpaceInvaders interfaz;

	public HiloAuxiliarCreaDisparo(Partida a, InterfazSpaceInvaders principal) {
		// TODO Auto-generated constructor stub
		partidaEnemigos = a;
		interfaz = principal;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (interfaz.estaEnFuncionamiento()) {

			int fila = (int) (Math.random() * 4);
			int columna = (int) (Math.random() * 9);

			if (partidaEnemigos.getEnemigos()[fila][columna] != null) {
				partidaEnemigos.getEnemigos()[fila][columna].disparar(
						partidaEnemigos.getEnemigos()[fila][columna].getPosX(),
						partidaEnemigos.getEnemigos()[fila][columna].getPosY());
			}

			try {
				sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
