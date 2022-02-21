package test.PrevidenciaSocial;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorMenorOuIgualZero;
import models.SimuladorIRPF;

public class PrevidenciaOficial {
    private SimuladorIRPF simul;

	    @Before
	    public void setup(){
	        simul = new SimuladorIRPF();
	    }
	    
		@Test
	    public void testeCadastroPrevOficial() throws Exception{
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 1000f);
	        assertEquals(1000f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
		
		@Test
	    public void testeCadastroPrevOficialDOIS() throws Exception{
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 500f);
	        assertEquals(500f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
		
		@Test
	    public void testeCadastroDUASrevOficialDOIS() throws Exception{
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 1000f);
	        simul.cadastrarPrevidenciaOficial("Carnê INSS", 2000f);
	        assertEquals(3000f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
		
		@Test
	    public void testeCadastroTRESrevOficialDOIS() throws Exception{
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 1000f);
	        simul.cadastrarPrevidenciaOficial("Carnê INSS", 2000f);
	        simul.cadastrarPrevidenciaOficial("Carnê INSS 2", 3000f);
	        assertEquals(6000f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
		
		@Test(expected = DescricaoEmBrancoException.class)
		public void testeDescEmBranco() throws Exception {
			simul.cadastrarPrevidenciaOficial(" ", 1000f);
			
		}
		
		@Test(expected = ValorMenorOuIgualZero.class)
		public void testeValorMenorOuIgualZero() throws Exception {
			simul.cadastrarPrevidenciaOficial(" Carnê", 0f);
			
		}
}
