package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorRendimentoInvalidoException;

public class CadastroRendimentoExceptionTest {
	Simulador simulador;
	
	@Before
	public void setUp() {
		simulador = new Simulador();
	}

	@Test(expected = DescricaoEmBrancoException.class)
	public void cadastroRendimentoDescricaoEmBrancoExceptionTest() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastrarRendimento("", 1000);
		assertEquals(1000 , simulador.getTotalRendimento(), 0f);
	}

	@Test(expected = ValorRendimentoInvalidoException.class)
	public void cadastroRendimentoValorRendimentoInvalidoExceptionTest() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastrarRendimento("Aluguel", -1);
		assertEquals(-1 , simulador.getTotalRendimento(), 0f);
	}
}
