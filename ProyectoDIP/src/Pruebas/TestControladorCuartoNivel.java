package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;





import Logica.InformacionJuego;
import Logica.Objeto;
import Logica.ControladorCuartoNivel;



public class TestControladorCuartoNivel  extends TestCase {

	private ControladorCuartoNivel c;


	@Before 
	public	void setUp()throws Exception{
		InformacionJuego inf = new InformacionJuego();
		inf.crearObjeto("tapete",10, "drecoracion");
		inf.crearObjeto("parche", 4, "adorno");
		inf.crearObjeto("casa", 30, "vivienda");
		inf.crearObjeto("perro",8,"animal");

		ControladorCuartoNivel c = new ControladorCuartoNivel (3,3, inf);





	} 
	@After
	public void tearDown()throws Exception{
		c = null;
		
	}



	@Test
	public void testPrepararLabel() {
		InformacionJuego inf = new InformacionJuego();
		inf.crearObjeto("tapete",10, "drecoracion");
		inf.crearObjeto("parche", 4, "adorno");
		inf.crearObjeto("casa", 30, "vivienda");
		inf.crearObjeto("perro",8,"animal");

		ControladorCuartoNivel c = new ControladorCuartoNivel (3,3, inf);

		
		ArrayList<Objeto> aux = new ArrayList<Objeto>(); 
		aux.add(new Objeto("tapete",10, "drecoracion"));
		aux.add(new Objeto("parche", 4, "adorno"));
		aux.add(new Objeto ("casa", 30, "vivienda"));
		aux.add(new Objeto ("perro",8,"animal"));

		c.setObjPerdidos(aux);
		String temp =c.getObjPerdidos().get(0).getNombre()+ " "+ c.getObjPerdidos().get(0).getTamanio()+ " " +c.getObjPerdidos().get(1).getNombre()+" "+ c.getObjPerdidos().get(1).getTamanio()+" "+ c.getObjPerdidos().get(2).getNombre()+" "+c.getObjPerdidos().get(2).getTamanio()+" "+c.getObjPerdidos().get(3).getNombre()
				+" "+c.getObjPerdidos().get(3).getTamanio();

		assertEquals(c.prepararLabel(), temp);

	}

	@Test
	public void testOrdenEsCorrecto() {
		InformacionJuego inf = new InformacionJuego();
		inf.crearObjeto("tapete",10, "drecoracion");
		inf.crearObjeto("parche", 4, "adorno");
		inf.crearObjeto("casa", 30, "vivienda");
		inf.crearObjeto("perro",8,"animal");

		ControladorCuartoNivel c = new ControladorCuartoNivel (3,3, inf);

		ArrayList<Objeto> aux = new ArrayList<Objeto>(); 
		aux.add(new Objeto("tapete",10, "drecoracion"));
		aux.add(new Objeto("parche", 4, "adorno"));
		aux.add(new Objeto ("casa", 30, "vivienda"));
		aux.add(new Objeto ("perro",8,"animal"));

		c.setObjPerdidos(aux);
		c.setControl(1);

		c.setObjEncontrados(aux.get(0));
		c.setObjEncontrados(aux.get(1));
		c.setObjEncontrados(aux.get(2));
		c.setObjEncontrados(aux.get(3));

		assertEquals(c.ordenEsCorrecto(), true);


	}


	@Test
	public void testMismOrden() {
		InformacionJuego inf = new InformacionJuego();
		inf.crearObjeto("tapete",10, "drecoracion");
		inf.crearObjeto("parche", 4, "adorno");
		inf.crearObjeto("casa", 30, "vivienda");
		inf.crearObjeto("perro",8,"animal");

		ControladorCuartoNivel c = new ControladorCuartoNivel (3,3, inf);

		ArrayList<Objeto> aux = new ArrayList<Objeto>(); 
		aux.add(new Objeto("tapete",10, "drecoracion"));
		aux.add(new Objeto("parche", 4, "adorno"));
		aux.add(new Objeto ("casa", 30, "vivienda"));
		aux.add(new Objeto ("perro",8,"animal"));

		c.setObjPerdidos(aux);

		c.setObjEncontrados(aux.get(0));
		c.setObjEncontrados(aux.get(1));
		c.setObjEncontrados(aux.get(2));
		c.setObjEncontrados(aux.get(3));

		assertEquals(c.mismOrden(), true);

	}

	@Test
	public void testMenorMayor() {
		InformacionJuego inf = new InformacionJuego();
		inf.crearObjeto("tapete",10, "drecoracion");
		inf.crearObjeto("parche", 4, "adorno");
		inf.crearObjeto("casa", 30, "vivienda");
		inf.crearObjeto("perro",8,"animal");

		ControladorCuartoNivel c = new ControladorCuartoNivel (3,3, inf);

		ArrayList<Objeto> aux = new ArrayList<Objeto>(); 
		aux.add(new Objeto("tapete",10, "drecoracion"));
		aux.add(new Objeto("parche", 4, "adorno"));
		aux.add(new Objeto ("casa", 30, "vivienda"));
		aux.add(new Objeto ("perro",8,"animal"));

		c.setObjPerdidos(aux);

		c.setObjEncontrados(aux.get(0));
		c.setObjEncontrados(aux.get(1));
		c.setObjEncontrados(aux.get(2));
		c.setObjEncontrados(aux.get(3));

		assertEquals(c.menorMayor(), false);
	}

}


