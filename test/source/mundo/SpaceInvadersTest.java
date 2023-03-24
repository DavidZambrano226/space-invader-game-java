package mundo;

import java.io.IOException;
import java.util.ArrayList;

import excepciones.NicknameYaExisteException;
import junit.framework.TestCase;

public class SpaceInvadersTest extends TestCase {

	private SpaceInvaders space;
	private ArrayList<NaveJugador> jugadores;
	
	// AGREGAR JUGADOR
	private void setUpEscenario1 () {
		
		space = new SpaceInvaders(true);
		jugadores = new ArrayList<>();
		space.setJugadores(jugadores);
		
	}
	
	// AGREGAR JUGADOR - BUSCAR JUGADOR - BUSCAR RAPIDO
	private void setUpEscenario2 () {
		
		space = new SpaceInvaders(true);
		jugadores = new ArrayList<>();
		
		NaveJugador a = new NaveJugador("Manuel", "juga1");
		NaveJugador b = new NaveJugador("Manuel", "juga2");
		NaveJugador c = new NaveJugador("Manuel", "juga3");
		NaveJugador d = new NaveJugador("Manuel", "juga4");
		
		jugadores.add(a);
		jugadores.add(b);
		jugadores.add(c);
		jugadores.add(d);
		
		space.setJugadores(jugadores);
		
	}
	
	// ORDENAR POR NICKNAME
	private void setUpEscenario3 () {
		
		space = new SpaceInvaders(true);
		jugadores = new ArrayList<>();
		
		NaveJugador a = new NaveJugador("Manuel", "juga1");
		NaveJugador b = new NaveJugador("Manuel", "juga2");
		NaveJugador c = new NaveJugador("Manuel", "juga3");
		NaveJugador d = new NaveJugador("Manuel", "juga4");
		
		jugadores.add(b);
		jugadores.add(d);
		jugadores.add(c);
		jugadores.add(a);
		
		space.setJugadores(jugadores);
	}
	
	public void testAgregarJugadorVectorVacio () {
		
		setUpEscenario1();
		
		// No hay nada, esta vacio
		assertEquals(0, jugadores.size());
		
		try {
			space.agregarJugador("Yo1", "agre1");
		} catch (NicknameYaExisteException | IOException e) {
			fail("Lanza excepcion inesperada NicknameYaExisteException");
		}
		
		assertEquals(1, jugadores.size());
		
		try {
			space.agregarJugador("Yo2", "agre2");
			space.agregarJugador("Yo2", "agre3");
			space.agregarJugador("Yo2", "agre4");
		} catch (NicknameYaExisteException | IOException e) {
			fail("Lanza excepcion inesperada NicknameYaExisteException");
		}
		
		assertEquals(4, jugadores.size());
		
	}
	
	public void testAgregarJugadorVectorLleno () {
		setUpEscenario2();
		
		assertEquals(4, jugadores.size());
		
		try {
			space.agregarJugador("Manuel", "juga5");
		} catch (NicknameYaExisteException | IOException e) {
			fail("Lanza excepcion inesperada NicknameYaExisteException");
		}
		
		assertEquals(5, jugadores.size());
		
	}
	
	public void testAgregarJugadorRepetidoVector () {
		
		setUpEscenario2();
		
		try {
			space.agregarJugador("Manuel", "juga4");
			fail("No lanza excepcion esperado NicknameYaExisteException");
		} catch (NicknameYaExisteException | IOException e) {
		}
		
		assertEquals(4, jugadores.size());
		
	}
	
	public void testBuscarJugadorVector () {
		
		setUpEscenario2();
		
		NaveJugador buscado = space.buscarJugador("juga3");
		
		assertNotNull(buscado);
		assertEquals(jugadores.get(2), buscado);
		
		NaveJugador buscado1 = space.buscarJugador("juga0");
		
		assertNull(buscado1);
		
	}
	
	public void testOrdenarNickName () {
		
		setUpEscenario3();
		
		ArrayList<NaveJugador> players = space.ordenarPorNickname();
		
		assertEquals(players.get(0), jugadores.get(3));
		assertEquals(players.get(1), jugadores.get(0));
		assertEquals(players.get(2), jugadores.get(2));
		assertEquals(players.get(3), jugadores.get(1));
		
	}
	
	public void testBuscarRapido () {
		setUpEscenario2();
		
		assertTrue(space.busquedaRapida("juga3"));
		assertFalse(space.busquedaRapida("juga8"));
	}
	
}
