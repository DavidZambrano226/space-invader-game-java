package mundo;

import java.io.IOException;

import excepciones.PartidaYaExisteException;
import junit.framework.TestCase;

public class PartidaTest extends TestCase {

	private Partida partida;
	private NaveJugador jugador;
	private Enemigo[][] enemigos;
	
	// AGREGAR PARTIDA - BUSCAR PARTIDA
	private void setUpEscenario1(){
		partida = new Partida("prueba_AgregarPartida_BuscarPartida");
		jugador = new NaveJugador("Manuel", "Escenario1");
	}
	
	// AGREGAR PARTIDA - BUSCAR PARTIDA
	private void setUpEscenario2() {
		
		partida = new Partida("test2");
		jugador = new NaveJugador("Manuel", "Escenario2");
		Partida p1 = new Partida("test2.1");
		Partida p2 = new Partida("test2.2");
		Partida p3 = new Partida("test2.3");
		
		
		try {
			jugador.agregarPartida(partida);
			jugador.agregarPartida(p1);
			jugador.agregarPartida(p2);
			jugador.agregarPartida(p3);
		} catch (PartidaYaExisteException e) {
			// TODO Auto-generated catch block
		}
	}
	
	// INICIAR ENEMIGOS
	private void setUpEscenario3() {
		
		partida = new Partida("prueba_IniciarEnemigos");
		
		enemigos = new Enemigo[5][10];
		
		partida.setEnemigos(enemigos);
		
	}
	
	// ELIMINAR UN ENIMIGO
	private void setUpEscenario4() {
		partida = new Partida("prueba_EliminarEnemigo");
		
		enemigos = new Enemigo[2][3];
		
		partida.setEnemigos(enemigos);
		
		for (int i = 0; i < enemigos.length; i++) {
			for (int j = 0; j < enemigos[i].length; j++) {
				enemigos[i][j] = new InvasorCalamar(0, 0, 0, 0, 0, 0, 0, "", "");
			}
		}
		
	}
	
	
	// TERMINAR NIVEL
	private void setUpEscenario5() {
		
		partida = new Partida("prueba_TerminarNivel");
		
		enemigos = new Enemigo[2][3];
		
		partida.setEnemigos(enemigos);
		
		for (int i = 0; i < enemigos.length; i++) {
			for (int j = 0; j < enemigos[i].length; j++) {
				enemigos[i][j] = null;
			}
		}
		enemigos[0][2] = (InvasorCalamar) new InvasorCalamar(0, 0, 0, 0, 0, 0, 0, "", "");
	}
	
	// NIVEL COMPLETO
	private void setUpEscenario6() {
		partida = new Partida("prueba_NivelCompleto");
		
		partida.setNivel(new Nivel("1", 0, 0, 0, 0, 0, 0, 0));
		
		partida.getNivel().setNivel("1");
		
		enemigos = new Enemigo[2][3];
		
		partida.setEnemigos(enemigos);
		
		for (int i = 0; i < enemigos.length; i++) {
			for (int j = 0; j < enemigos[i].length; j++) {
				enemigos[i][j] = null;
			}
		}
	}
	
	// ELIMINAR PARTIDA
	private void setUpEscenario7 () {
		
		partida = new Partida("prueba_EliminarPartida");
		
		Partida a = new Partida("prueba_EliminarPartida1");
		Partida b = new Partida("prueba_EliminarPartida2");
		Partida c = new Partida("prueba_EliminarPartida3");
		Partida d = new Partida("prueba_EliminarPartida4");
		
		try {
			partida.agregarPartida(partida);
			partida.agregarPartida(a);
			partida.agregarPartida(b);
			partida.agregarPartida(c);
			partida.agregarPartida(d);
		} catch (PartidaYaExisteException e) {
		}
		
	}
	
	public void testAgregarPartida() {
		setUpEscenario1();
		try {
			jugador.agregarPartida(partida);
		} catch (PartidaYaExisteException e) {
			fail("Lanza excepcion inesperada PartidaYaExisteException");
		}
	}
	
	public void testAgregarPartidaSinRepetidos () {
		try {
			setUpEscenario2();
			
			Partida agregar = new Partida("testAgregar");
			jugador.agregarPartida(agregar);
			
		} catch (PartidaYaExisteException e) {
			fail("Lanza excepcion inesperada PartidaYaExisteException");
		}
		
	}
	
	public void testAgregarPartidaRepetida () {
		setUpEscenario2();
		Partida agregar = new Partida("test2.1");
		
		try {
			jugador.agregarPartida(agregar);
			fail("Se esperaba excepcion PartidaYaExisteException");
		} catch (PartidaYaExisteException e) {
		}
	}
	
	public void testBuscarPartidaSiNoHayNada () {
		setUpEscenario1();
		
		Partida buscada = partida.buscarPartida("test2.1");
		assertNull("Debe de ser null", buscada);
	}
	
	public void testBuscarPartidaSiHayPartidas () {
		
		setUpEscenario2();
		
		Partida buscada = partida.buscarPartida("test2");
		assertNotNull("No debe de ser null", buscada);
		
	}
	
	public void testIniciarEnemigos () {
		
		setUpEscenario3();
		
		partida.inicializarEnemigos();
		
		Enemigo a = (InvasorCangrejo) new InvasorCangrejo(0, 0, 0, 0, 0, 0, 0, "", "");
		Enemigo b = (InvasorCalamar) new InvasorCalamar(0, 0, 0, 0, 0, 0, 0, "", "");
		Enemigo c = (InvasorPulpo) new InvasorPulpo(0, 0, 0, 0, 0, 0, 0, "", "");
		
		assertEquals(a.getClass(), partida.getEnemigos()[1][4].getClass());
		assertEquals(b.getClass(), partida.getEnemigos()[0][7].getClass());
		assertEquals(c.getClass(), partida.getEnemigos()[3][5].getClass());
	}
	
	public void testEliminarEnemigo () {
		
		setUpEscenario4();
		
		Enemigo eliminar = enemigos[1][2];
		
		assertNotNull("No debe ser null porque existe", enemigos[1][2]);
		
		partida.eliminarUnEnemigo(true, eliminar);
		
		assertNull("Deberia ser null, porque se elimino", enemigos[1][2]);
		
	}
	
	public void testTerminarNivel () {
		
		setUpEscenario5();
		
		assertFalse("Queda un enemigo", partida.terminarNivel());
		
		Enemigo eliminar = enemigos[0][2];
		
		partida.eliminarUnEnemigo(true, eliminar);
		
		assertTrue("No quedan enemigos", partida.terminarNivel());
		
	}
	
	public void testNivelCompleto () {
		
		setUpEscenario6();
		
		assertEquals("1", partida.getNivel().getNivel());
		
		if (partida.terminarNivel()) {
			try {
				partida.nivelCompleto();
			} catch (IOException e) {
			}
		}
		
		assertEquals("2", partida.getNivel().getNivel());
		
	}
	
	public void testEliminarPartida () {
		
		setUpEscenario7();
		
		partida.eliminar("prueba_EliminarPartida2");
		
		assertNull(partida.buscarPartida("prueba_EliminarPartida2"));
		
	}
	
	public void testEsHoja () {
		setUpEscenario1();
		
		assertTrue(partida.esHoja());
		partida.setPartidaDerecha(new Partida("noSoyHoja"));
		assertFalse(partida.esHoja());
	}
	
}
