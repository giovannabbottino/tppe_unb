package test.PrevidenciaSocial;

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
public class PrevidenciaOficalParametrizado {
	
	private SimuladorIRPF simulador;
	@Before
	public void setuUp() {
		simulador = new SimuladorIRPF();
		
	}
	
	
	//Atributos do obj de teste
	Object[][] contribuicoes;
	float valorEsperado;
	
	
	//construtor obj de teste
	public PrevidenciaOficalParametrizado(Object[][] contribuicoes,float valorEsperado) {
		this.contribuicoes=contribuicoes;
		this.valorEsperado=valorEsperado;
	}
	
	@Parameters
	public static Collection<Object[]>getParametres(){

		
		Object[][]resposta = new Object[][] {
			{ new Object[][]{
				{"Contribuição Compulsoria",1000f}
							}, 1000f },// caso1

			{new Object[][]{
				{"Contribuição Compulsoria",800f},
			}, 800f  },// caso2
			
			{ new Object[][]{
				{"Contribuição Compulsoria",1000f},
				{"Carne InSS",800f},
			}, 1800f },// caso3
			
			{ new Object[][]{
				{"Contribuição Compulsoria",1000f},
				{"Carne InSS1",800f},
				{"Carne InSS2",200f},
			}, 2000f },// caso4
			
		};
		
		return Arrays.asList(resposta);
	}
	
	
	
	
	@Test
	public void cadastroContribuicoes() throws Exception {
		for(Object[]contribuicao:contribuicoes) {
			simulador.cadastrarPrevidenciaOficial((String)contribuicao[0], (Float)contribuicao[1]);
		}
		assertEquals(valorEsperado, simulador.getTotalDeducaoPrevidenciaOficial(),0f);
	}
	

}
