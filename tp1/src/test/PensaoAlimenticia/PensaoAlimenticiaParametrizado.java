package test.PensaoAlimenticia;

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
public class PensaoAlimenticiaParametrizado {

//	2.1
	private SimuladorIRPF simulador;
	@Before
	public void setuUp() {
		simulador = new SimuladorIRPF();
		
	}
	
	
	//Atributos do obj de teste
	Object[][] pensoes;
	float valorEsperado;
	
	
	//construtor obj de teste
	public PensaoAlimenticiaParametrizado(Object[][] pensoes,float valorEsperado) {
		this.pensoes=pensoes;
		this.valorEsperado=valorEsperado;
	}
	
	@Parameters
	public static Collection<Object[]>getParametres(){
		Object[][]resposta = new Object[][] {
			{ new Object[][]{
				{"Pensao Alimenticia 1",1000f}
							}, 1000f },// caso1

			{new Object[][]{
				{"Pensao Alimenticia 1",800f},
			}, 800f  },// caso2
			
			{ new Object[][]{
				{"Pensao Alimenticia 1",1000f},
				{"Pensao Alimenticia 2",800f},
			}, 1800f },// caso3
			
			{ new Object[][]{
				{"Pensao Alimenticia 1",1000f},
				{"Pensao Alimenticia 2",800f},
				{"Pensao Alimenticia 3",200f},
			}, 2000f },// caso4
			
		};
		
		return Arrays.asList(resposta);
	}
	
	
	
	
	@Test
	public void cadastroPensao() throws Exception {
		for(Object[]pensao:pensoes) {
			simulador.cadastraPensaoAlimenticia((String)pensao[0], (Float)pensao[1]);
		}
		assertEquals(valorEsperado, simulador.getPensaoAlimenticia(),0f);
	}

}
