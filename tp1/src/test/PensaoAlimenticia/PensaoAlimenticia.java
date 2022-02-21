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
	public void testUmaPensaoAlimenticia() {
		simul.cadastraPensaoAlimenticia("Pensao 1",500f);
		assertEquals(500f, simul.getPensaoAlimenticia(),0f);
	}

}
