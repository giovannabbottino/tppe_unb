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
	public void Test() throws Exception{ // duplicacao faixa 1
		simulador.cadastrarRendimento("Aluguel", 2903.98f);
		simulador.cadastraDeducao("Aluguel Deducao", 1000f);
		simulador.apuracaoImposto();
		assertEquals(0f , simulador.getTotalImposto(), 2f);
	}
	
	@Test
	public void Test2() throws Exception{ // duplicacao faixa 2
		simulador.cadastrarRendimento("Aluguel", 3826.65f);
		simulador.cadastraDeducao("Aluguel Deducao", 1000f);
		simulador.apuracaoImposto();
		assertEquals(69.20f , simulador.getTotalImposto(), 2f);
	}
	
	@Test
	public void Test3() throws Exception{ // duplicacao faixa 3
		simulador.cadastrarRendimento("Aluguel", 4751.05f);
		simulador.cadastraDeducao("Aluguel Deducao", 1000f);
		simulador.apuracaoImposto();
		assertEquals(207.86f , simulador.getTotalImposto(), 2f);
	}
	
	@Test
	public void Test4() throws Exception{ // duplicacao faixa 4
		simulador.cadastrarRendimento("Aluguel", 5664.68f);
		simulador.cadastraDeducao("Aluguel Deducao", 1000f);
		simulador.apuracaoImposto();
		assertEquals(413.42f , simulador.getTotalImposto(), 2f);
	}
	
	@Test
	public void Test5() throws Exception{ // duplicacao faixa 5
		simulador.cadastrarRendimento("Aluguel", 5664.68f);
		simulador.cadastraDeducao("Aluguel Deducao", 500f);
		simulador.apuracaoImposto();
		assertEquals(550.92f , simulador.getTotalImposto(), 2f);
	}
}
