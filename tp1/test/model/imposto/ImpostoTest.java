package model.imposto;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import model.Simulador;

@RunWith(Parameterized.class)
public class ImpostoTest {
	
	Simulador simulador;
	Object[][] rendimentos;
	Object[][] deducoes;
	private float totalImpostoEsperado; 
	private float baseCalculoEsperado;
	
	public ImpostoTest(Object[][] rendimentos, Object[][] deducoes, float totalImpostoEsperado, float baseCalculoEsperado){
		this.rendimentos = rendimentos;
		this.deducoes = deducoes;
		this.totalImpostoEsperado = totalImpostoEsperado;
		this.baseCalculoEsperado = baseCalculoEsperado;
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
			}, 0f,  1903.98f },
			{ new Object[][] {
				{"Aluguel", 5664.68f },
			}, new Object[][] {
				{"Aluguel Deducao", 500f},
			}, 550.92f ,  5164.68f },
			{ new Object[][] {
				{"Aluguel", 5664.68f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 413.42f ,  4664.68f },
			{ new Object[][] {
				{"Aluguel", 4751.05f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 207.86f ,  3751.05f },
			{ new Object[][] {
				{"Aluguel", 3826.65f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 69.20f ,  2826.65f},
			{ new Object[][] {
				{ "Reserva", 1913.33f },
				{ "Imovel" , 1913.32f }
			}, new Object[][] {
				{"Reserva Deducao", 500f},
				{"Imovel Deducao", 500f}
			}, 69.20f ,  2826.65f},
		};
		
		return Arrays.asList(dados);
	}
	
	
	@Test
	public void TestTotalImposto() throws Exception{ 
		for (Object[] rendimento : rendimentos) {
			simulador.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		for (Object[] deducao : deducoes) {
			simulador.cadastraDeducao((String)deducao[0], (float)deducao[1]);
		}
		simulador.setBaseCalculo(simulador.getTotalRendimento() - simulador.getTotalDeducao());
		simulador.apuracaoImposto();
		assertEquals(this.totalImpostoEsperado, simulador.getTotalImposto(), 2f);
	}
	
	@Test
	public void TestBaseCalculo() throws Exception{ 
		for (Object[] rendimento : rendimentos) {
			simulador.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		for (Object[] deducao : deducoes) {
			simulador.cadastraDeducao((String)deducao[0], (float)deducao[1]);
		}
		simulador.setBaseCalculo(simulador.getTotalRendimento() - simulador.getTotalDeducao());
		simulador.apuracaoImposto();
		assertEquals(this.baseCalculoEsperado, simulador.getBaseCalculo(), 2f);
	}
}
