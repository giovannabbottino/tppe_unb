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
		simulador.cadastrarRendimento("Aluguel", 2903.98f);
		simulador.cadastraDeducao("Aluguel", 1000f);
		simulador.setBaseCalculo(simulador.getTotalRendimento() - simulador.getDeducao());
		simulador.apuracaoImposto();
		simulador.setAliquota();
		assertEquals(0f, simulador.getAliquota(), 2f);
	}
	
	@Test
	public void Test2() throws Exception{ 
		simulador.cadastrarRendimento("Aluguel", 5664.68f);
		simulador.cadastraDeducao("Aluguel", 1000f);
		simulador.setBaseCalculo(simulador.getTotalRendimento() - simulador.getDeducao());
		simulador.apuracaoImposto();
		simulador.setAliquota();
		assertEquals(7.29f, simulador.getAliquota(), 2f);
	}
	
	@Test
	public void Test3() throws Exception{ 
		simulador.cadastrarRendimento("Aluguel", 4664.68f);
		simulador.cadastraDeducao("Aluguel", 1000f);
		simulador.setBaseCalculo(simulador.getTotalRendimento() - simulador.getDeducao());
		simulador.apuracaoImposto();
		simulador.setAliquota();
		assertEquals(4.17f, simulador.getAliquota(), 2f);
	}

}
