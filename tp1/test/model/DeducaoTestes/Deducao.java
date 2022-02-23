package model.DeducaoTestes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorDeducaoInvalidoException;
import model.Simulador;

public class Deducao {

	private Simulador simul;

    @Before
    public void setup(){
        simul = new Simulador();
    }
    
	@Test
    public void testeCadastraDeducaoUm() throws Exception {
        simul.cadastraDeducao("Previdencia privada", 1500f);
        
        assertEquals(1500f, simul.getDeducao(),0f);
    }
	@Test
    public void testeCadastraDeducaoDois() throws Exception {
        simul.cadastraDeducao("Previdencia privada", 1200f);
        
        assertEquals(1200f, simul.getDeducao(),0f);
    }
	
	@Test
    public void testeCadastraDuasDeducao() throws Exception {
        simul.cadastraDeducao("Previdencia privada", 1500f);
        simul.cadastraDeducao("Funpresp", 1200f);
        
        assertEquals(2700f, simul.getDeducao(),0f);
    }
	
	@Test(expected = DescricaoEmBrancoException.class)
	public void testeDescEmBranco() throws Exception {
		simul.cadastrarPrevidenciaOficial(" ", 1000f);
		
	}
	
	@Test(expected = ValorDeducaoInvalidoException.class)
	public void testeValorMenorOuIgualZero() throws Exception {
		simul.cadastrarPrevidenciaOficial(" Funpresp", 0f);
		
	}

}
