package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import exception.DescricaoEmBrancoException;
import exception.ValorRendimentoInvalidoException;

public class CadastroRendimentoExceptionTest {
	Simulador simulador;
	
	@Before
	public void setUp() {
		simulador = new Simulador();
	}

	@DisplayName("Testa a expection Descricao em Branco")
	@Test(expected = DescricaoEmBrancoException.class)
	public void cadastroRendimentoDescricaoEmBrancoExceptionTest() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastrarRendimento("", 1000);
		assertEquals(1000 , simulador.getTotalRendimento(), 0f);
	}

	@DisplayName("Testa a expection Rendimento Invalido")
	@Test(expected = ValorRendimentoInvalidoException.class)
	public void cadastroRendimentoValorRendimentoInvalidoExceptionTest() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		simulador.cadastrarRendimento("Aluguel", -1);
		assertEquals(-1 , simulador.getTotalRendimento(), 0f);
	}
}
