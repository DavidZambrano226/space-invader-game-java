package mundo;

import junit.framework.TestCase;

public class NaveTest extends TestCase {

	private NaveJugador nave;
	private Disparo disparo;
	
	// MOVER - DISPARAR
	private void setUpEscenario1 () {
		
		nave = new NaveJugador("prueba_Mover", "test1");
		nave.setVelocidad(10);
		nave.setPosInicialX(300);
		
	}
	
	// ELIMINAR DISPARO
	private void setUpEscenario2 (){
		
		nave = new NaveJugador("prueba_EliminarDisparo", "test2");
		disparo = new Disparo(20, 10);
		
		nave.setDisparoUno(disparo);
	}
	
	// ESTA VIVA
	private void setUpEscenario3 () {
		
		nave = new NaveJugador("prueba_EstaViva", "test3");
		nave.setVida(3);
		
	}
	
	public void testMoverNave () {
		
		setUpEscenario1();
		
		assertEquals(300, nave.getPosInicialX());
		
		// Mover nave a la DERECHA
		nave.mover(1);
		
		assertEquals(310, nave.getPosInicialX());

		// Mover nace a su posicion inicial
		nave.mover(-1);
		
		assertEquals(300, nave.getPosInicialX());
		
		// Mover nave a la izquierda
		nave.mover(-1);
		
		assertEquals(290, nave.getPosInicialX());
	}
	
	public void testDispara () {
		
		setUpEscenario1();
		
		assertNull(nave.getDisparoUno());
		
		// Crea un disparo a la nave
		nave.disparar(200, 310);
		
		assertNotNull(nave.getDisparoUno());
		
		Enemigo momentaneo = (InvasorPulpo) new InvasorPulpo(0, 0, 0, 0, 0, 0, 0, "", "");
		// Crea un disparo a un enemigo
		momentaneo.disparar(100, 300);
		
		assertNotNull(momentaneo.getDisparoUno());
		
		// Los disparos no son iguales
		assertNotSame(nave.getDisparoUno(), momentaneo.getDisparoUno());
		
	}
	
	public void testEliminaDisparo (){
		
		setUpEscenario2();
		
		assertNotNull(nave.getDisparoUno());
		
		nave.eliminarDisparo();
		
		assertNull(nave.getDisparoUno());
		
	}
	
	public void testEstaViva () {
		
		setUpEscenario3();
		
		assertTrue(nave.estaViva());
		assertEquals(3, nave.getVida());
		
		nave.setVida(2);
		assertTrue(nave.estaViva());
		
		// Murio el jugador
		nave.setVida(0);
		assertFalse(nave.estaViva());
		
		
	}
}
