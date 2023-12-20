package Pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logica.ControladorTercerNivel;
import Logica.Validacion;
import junit.framework.TestCase;

public class TestControladorTercerNivel extends TestCase {
	private ControladorTercerNivel controlador;
	
	@Before
	public void setUp() throws Exception {
		controlador = new ControladorTercerNivel(0, 0, null);
	}

	@After
	public void tearDown() throws Exception {
		controlador = null;
	}
	
	@Test
	public void testRespuestaCorrectaMayusculas(){
		assertTrue(controlador.respuestaCorrecta("HOLA", "HOLA"));
	}
	
	@Test
	public void testRespuestaCorrectaMinusculas(){
		assertTrue(controlador.respuestaCorrecta("Hola", "HOLA"));
	}
	
	@Test
	public void testRespuestaIncorrecta(){
		assertFalse(controlador.respuestaCorrecta("HOLA", "hol"));
	}
	
	@Test
	public void testCartaNull(){
		try{
			assertNull(controlador.repartirCarta());
		}
		catch(NullPointerException e){
			
		}
	}
}
