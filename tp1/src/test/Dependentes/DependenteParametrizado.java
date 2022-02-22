package test.Dependentes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import models.SimuladorIRPF;

@RunWith(Parameterized.class)
public class DependenteParametrizado {

	private SimuladorIRPF simulador;
	@Before
	public void setuUp() {
		simulador = new SimuladorIRPF();
	}

	//Atributos do objeto de teste
	Object[][] dependentes;
	float valorEsperado;

	//Construtor objeto de teste
	public DependenteParametrizado(Object[][] dependentes, float valorEsperado) {
		this.dependentes=dependentes;
		this.valorEsperado=valorEsperado;
	}

	@Parameters
	public static Collection<Object[]>getParametres(){
		Object[][]resposta = new Object[][] {
			{ new Object[][]{
				{"Joãozinho", "10/01/2000"}
							}, 189.59f }, // Caso1

			{new Object[][]{
				{"Mariazinha", "10/01/2000"},
			}, 189.59f  }, // Caso2

			{ new Object[][]{
				{"Joãozinho", "10/01/2000"},
				{"Mariazinha", "10/01/2000"},
			}, 379.18f }, // Caso3

			{ new Object[][]{
				{"Joãozinho", "10/01/2000"},
				{"Mariazinha", "10/01/2000"},
				{"José", "01/02/2008"},
			}, 568.77f }, // Caso4

		};
		return Arrays.asList(resposta);
	}

	@Test
	public void cadastraDependente() throws Exception {
		for(Object[]dependente:dependentes) {
			simulador.cadastraDependente((String)dependente[0], (String)dependente[1]);
		}
		assertEquals(valorEsperado, simulador.getDependente(),0f);
	}
}