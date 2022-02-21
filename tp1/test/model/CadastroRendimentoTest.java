package model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroRendimentoTest{

	@DisplayName("Testa o cadastro de rendimento")
	@Test
	public void Test() {
	    assertEquals(5000f, Simulador.cadastrarRendimento("salario", 5000f), 0);
	}
}
