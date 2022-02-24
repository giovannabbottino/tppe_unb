package model.faixa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Simulador;

public class FaixaImpostoTest {
	
	Simulador simulador;
	@Before
	public void setUp() {
		simulador = new Simulador();
	}
	
	
	@Test
	public void Test() throws Exception{
		simulador.cadastrarRendimento("Aluguel", 0f);
		simulador.cadastraDeducao("Aluguel Deducao", 0f);
		assertEquals(0f , simulador.getFaixa(), 0f);
	}
}
