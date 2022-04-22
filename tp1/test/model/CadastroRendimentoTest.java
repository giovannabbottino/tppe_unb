package model;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorInvalidoException;
import Exceptions.ValorRendimentoInvalidoException;

import org.junit.Before;

@RunWith(Parameterized.class)
public class CadastroRendimentoTest{
	
	Simulador simulador;
	Object[][] rendimentos;
	private float expected;
	
	public CadastroRendimentoTest(Object[][] rendimentos, float expected){
		this.rendimentos = rendimentos;
		this.expected = expected;
	}
	
	@Before
	public void setUp() {
		simulador = new Simulador();
	}
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
			{ new Object[][] {
				{"Aluguel", 1000f },
			}, 1000f },
			{ new Object[][] {
				{"Salario", 50f },
			}, 50f },
			{ new Object[][] {
				{"Salario", 50f },
				{"Aposentadoria", 3000f },
			}, 3050f },
			{ new Object[][] {
				{"Viagem", 2000f },
				{ "Divida", 100f },
			}, 2100f },
			{ new Object[][] {
				{"Casamento", 250f },
			}, 250f },
			{ new Object[][] {
				{ "Reserva", 400f },
				{ "Imovel" , 800f },
			}, 1200f }
		};

		return Arrays.asList(dados);
	}

	@Test
	public void Test() throws DescricaoEmBrancoException, ValorInvalidoException {
		for (Object[] rendimento : rendimentos) {
			simulador.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		assertEquals(this.expected , simulador.getTotalRendimento(), 0f);
	}
}
