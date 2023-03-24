package mundo;

import junit.framework.TestCase;

public class EnemigoTest extends TestCase {

	
	private Enemigo enemigo;
	
	// MOVER - MOVER ABAJO - BORDE(EDGE)
	private void setUpEscenario1 (){
		
		enemigo = (InvasorCalamar) new InvasorCalamar(5, 300, 210, 0, 0, 0, 0, "", "");
		
	}
	
	public void testMover () {
		
		setUpEscenario1();
		
		assertTrue(enemigo.getPosX() == 300);
		
		// Mover hacia la derecha
		enemigo.mover(1);
		
		assertTrue(enemigo.getPosX() > 300);
		
		// Mover hacia la izquierda
		enemigo.mover(-1);
		
		assertTrue(enemigo.getPosX() <= 300);
		
		enemigo.mover(-1);
		
		assertTrue(enemigo.getPosX() < 300);
	}
	
	public void testMoverAbajo () {
		
		setUpEscenario1();
		
		assertTrue(enemigo.getPosY() == 210);
		
		enemigo.moverAbajo(1);
		
		assertTrue(enemigo.getPosY() > 210);
		
		enemigo.moverAbajo(1);
		
		assertTrue(enemigo.getPosY() == 230);
		
	}
	
	public void testEdge () {
		
		setUpEscenario1();
		
		enemigo.setPosX(600);
		
		assertTrue(enemigo.edge());
		
		enemigo.setPosX(100);
		
		assertFalse(enemigo.edge());
		
		enemigo.setPosX(-1);
		
		assertTrue(enemigo.edge());
		
	}
	
}
