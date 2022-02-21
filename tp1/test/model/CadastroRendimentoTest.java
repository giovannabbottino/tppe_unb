package model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;

public class CadastroRendimentoTest{
	
	Simulador simulador;
	
	@Before
	public void setUp() {
		simulador = new Simulador();
	}

	@DisplayName("Testa o cadastro de rendimento")
	@Test
	public void Test() {
	    assertEquals(5000f, simulador.cadastrarRendimento("salario", 5000f), 0);
	}
	
	@DisplayName("Testa o cadastro de rendimento")
	@Test
	public void Test2() {
	    assertEquals(3000f, simulador.cadastrarRendimento("aluguel", 3000f), 0);
	}
	
	@DisplayName("Testa o cadastro de rendimento")
	@Test
	public void Test3() {
	    assertEquals(3000f, simulador.cadastrarRendimento("aluguel", 3000f), 0);
	    assertEquals(5000f, simulador.cadastrarRendimento("aluguel", 2000f), 0);
	}
}
