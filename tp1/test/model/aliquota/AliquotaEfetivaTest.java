package model.aliquota;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import model.Simulador;

@RunWith(Parameterized.class)
public class AliquotaEfetivaTest{
	
	Simulador simulador;
	Object[][] rendimentos;
	Object[][] deducoes;
	private float aliquotaEfetivaEsperado; 
	
	public AliquotaEfetivaTest(Object[][] rendimentos, Object[][] deducoes, float aliquotaEfetivaEsperado){
		this.rendimentos = rendimentos;
		this.deducoes = deducoes;
		this.aliquotaEfetivaEsperado = aliquotaEfetivaEsperado;
	}
	
	@Before
	public void setUp() {
		simulador = new Simulador();
	}
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
			{ new Object[][] {
				{"Aluguel", 2903.98f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 0f },
			{ new Object[][] {
				{"Aluguel", 5664.68f },
			}, new Object[][] {
				{"Aluguel Deducao", 500f},
			}, 9.72f },
			{ new Object[][] {
				{"Aluguel", 5664.68f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 7.29f },
			{ new Object[][] {
				{"Aluguel", 4751.05f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 4.37f },
			{ new Object[][] {
				{"Aluguel", 3826.65f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 1.8f},
			{ new Object[][] {
				{ "Reserva", 1913.33f },
				{ "Imovel" , 1913.32f }
			}, new Object[][] {
				{"Reserva Deducao", 500f},
				{"Imovel Deducao", 500f}
			}, 0f},
		};

		return Arrays.asList(dados);
	}
	@Test
	public void Test() throws Exception{ 
		for (Object[] rendimento : rendimentos) {
			simulador.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		for (Object[] deducao : deducoes) {
			simulador.cadastraDeducao((String)deducao[0], (float)deducao[1]);
		}
		simulador.setBaseCalculo(simulador.getTotalRendimento() - simulador.getTotalDeducao());
		simulador.apuracaoImposto();
		simulador.setAliquotaEfetiva();
		assertEquals(this.aliquotaEfetivaEsperado, simulador.getAliquotaEfetiva(), 2f);
	}

}
