package model.aliquota;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Simulador;

public class AliquotaTest {
	
	Simulador simulador;
	
	@Before
	public void setUp() {
		simulador = new Simulador();
	}
	
	@Test
	public void Test() throws Exception{ 
		simulador.cadastrarRendimento("Aluguel", 1f);
		simulador.cadastraDeducao("Aluguel", 1f);
		simulador.setBaseCalculo(simulador.getTotalRendimento() - simulador.getDeducao());
		simulador.apuracaoImposto();
		simulador.setAliquota( (simulador.getTotalImposto()/simulador.getTotalRendimento() )* 100);
		assertEquals(0, simulador.getAliquota(), 2f);
	}

}
