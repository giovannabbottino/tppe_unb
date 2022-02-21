package test.PensaoAlimenticia;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import models.SimuladorIRPF;

public class PensaoAlimenticia {
	
	private SimuladorIRPF simul;
	
	@Before
	public void setup() {
		simul = new SimuladorIRPF();
	}
	
	@Test
	public void testUmaPensaoAlimenticia() throws Exception {
		simul.cadastraPensaoAlimenticia("Pensao 1",500f);
		assertEquals(500f, simul.getPensaoAlimenticia(),0f);
	}
	
	@Test
	public void testUmaPensaoAlimenticiaSegunda() throws Exception {
		simul.cadastraPensaoAlimenticia("Pensao 1",600f);
		assertEquals(600f, simul.getPensaoAlimenticia(),0f);
	}
	
	@Test
	public void testDuasPensaoAlimenticia() throws Exception {
		simul.cadastraPensaoAlimenticia("Pensao 1",600f);
		simul.cadastraPensaoAlimenticia("Pensao 2",400f);
		assertEquals(1000f, simul.getPensaoAlimenticia(),0f);
	}

}
