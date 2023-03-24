package mundo;

import junit.framework.TestCase;

public class DisparoTest extends TestCase {

	private Disparo disparo;
	private NaveJugador nave;
	private Enemigo enemigo;
	
	// GOLPEA ENEMIGO
	private void setUpEscenario1 () {
		
		nave = new NaveJugador("JugadorPrueba1", "Test1");
		
		enemigo = (InvasorCangrejo) new InvasorCangrejo(0, 100, 100, 0, 12, 0, 0, "", "");
		
		disparo = new Disparo(100, 100);
		
		nave.setDisparoUno(disparo);
		
	}
	
	// NO GOLPEA ENEMIGO
	private void setUpEscenario2 () {
		
		nave = new NaveJugador("JugadorPrueba2", "Test2");
		
		enemigo = (InvasorCangrejo) new InvasorCangrejo(0, 200, 200, 0, 12, 0, 0, "", "");
		
		disparo = new Disparo(100, 100);
		
		nave.setDisparoUno(disparo);
	}
	
	private void setUpEscenario3 () {
		
		enemigo = (InvasorPulpo) new InvasorPulpo(0, 190, 0, 0, 12, 0, 0, "", "");
		disparo = new Disparo(190, 0);
		enemigo.setDisparoUno(disparo);
		
		nave = new NaveJugador("JugadorPrueba3", "Test3");
		nave.setPosInicialX(190);
		nave.setPosIncialY(410);
		
	}
	
	public void testHitEnemigo () {
		setUpEscenario1();
		
		assertTrue(disparo.hitsEnemigo(enemigo));
		
	}
	
	
	public void testNoHitEnemigo () {
		setUpEscenario2();
		
		assertFalse(disparo.hitsEnemigo(enemigo));
		
	}
	
	public void testHitJugador () {
		setUpEscenario3();
		
		disparo.setPosY(410);
		
		assertTrue(disparo.hitsJugador(nave));
		
	}
	
	public void testNoHitJugador () {
		
		setUpEscenario3();
		
		disparo.setPosY(100);
		
		assertFalse(disparo.hitsJugador(nave));
		
	}
	
}
