package Pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.InformacionJuego;
import Logica.Validacion;
import junit.framework.TestCase;

public class TestInformacionJuego extends TestCase {
	private InformacionJuego ij;
	
	@Before
	public void setUp() throws Exception {
		ij = new InformacionJuego();
	}

	@After
	public void tearDown() throws Exception {
		ij = null;
	}
	
	@Test
	public void testListNotNull(){
		assertNotNull(ij.getPreguntasNivelUno());
	}
	
	@Test
	public void testListCartasnotNull(){
		assertNotSame(null, ij.getCartas());
	}
}
