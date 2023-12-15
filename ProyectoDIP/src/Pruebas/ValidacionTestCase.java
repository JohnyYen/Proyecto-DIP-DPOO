package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Logica.Carta;
import Logica.Validacion;

public class ValidacionTestCase {
	private Validacion validar;
	
	@Before
	public void setUp() throws Exception {
		validar = new Validacion();
	}

	@After
	public void tearDown() throws Exception {
		validar = null;
	}

	@Test
	public void testUsuarioIncorrecto() {
		assertEquals(false, validar.esUsuarioCorrecto("231853"));
	}

	@Test
	public void testUsuarioCorrecto() {
		assertEquals(true, validar.esUsuarioCorrecto("rafa03"));
	}
	
	@Test
	public void testContraseniaNoValida() {
		assertEquals(false, validar.esValidaContrasenia("rrjy3P".toCharArray()));
	}
	
	@Test
	public void testContraseniaValida() {
		assertEquals(true, validar.esValidaContrasenia("RRP2003".toCharArray()));
	}
	
	@Test
	public void testNumeroFlotante() {
		assertEquals(true, validar.esNumeroflotante("3.1416"));
	}
	
	@Test
	public void testNoEsNumeroFlotante() {
		assertEquals(false, validar.esNumeroflotante("13r54.2"));
	}
	
	@Test
	public void testCartasValidas() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta("sumatoria", "permite sumar dos numeros dados", "5235"));
		cartas.add(new Carta("corredor", "permite al usuario correr hacia un lugar especifico", "787"));
		cartas.add(new Carta("escalador", "permite escalar cierto objetivo especificado", "10780"));
		assertEquals(true, validar.validarCarta(cartas));
	}
	
	@Test
	public void testCartasNoValidas() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta("suma", "permite sumar dos numeros dados", "1"));
		cartas.add(new Carta("corredor", "permite al usuario correr hacia un lugar especifico", "787"));
		cartas.add(new Carta("escalar", "permite escalar cierto objetivo especificado", "2"));
		assertEquals(false, validar.validarCarta(cartas));
	}
}
