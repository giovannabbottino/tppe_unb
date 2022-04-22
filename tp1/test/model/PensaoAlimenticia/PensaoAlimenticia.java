package model.PensaoAlimenticia;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorInvalidoException;
import model.Simulador;

public class PensaoAlimenticia {
	
	private Simulador simul;
	
	@Before
	public void setup() {
		simul = new Simulador ();
	}
	
	@Test
	public void testUmaPensaoAlimenticia() throws Exception {
		simul.cadastraPensaoAlimenticia("Pensao 1",500f);
		assertEquals(500f, simul.getTotalPensaoAlimenticia(),0f);
	}
	
	@Test
	public void testUmaPensaoAlimenticiaSegunda() throws Exception {
		simul.cadastraPensaoAlimenticia("Pensao 1",600f);
		assertEquals(600f, simul.getTotalPensaoAlimenticia(),0f);
	}
	
	@Test
	public void testDuasPensaoAlimenticia() throws Exception {
		simul.cadastraPensaoAlimenticia("Pensao 1",600f);
		simul.cadastraPensaoAlimenticia("Pensao 2",400f);
		assertEquals(1000f, simul.getTotalPensaoAlimenticia(),0f);
	}
	
	@Test(expected = DescricaoEmBrancoException.class)
	public void testeDescEmBranco() throws Exception {
		simul.cadastraPensaoAlimenticia(" ", 1000f);
		
	}
	
	@Test(expected = ValorInvalidoException.class)
	public void testeValorMenorOuIgualZero() throws Exception {
		simul.cadastraPensaoAlimenticia(" Carnê", 0f);
		
	}

}
