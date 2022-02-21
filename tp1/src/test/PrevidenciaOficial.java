package test;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DescricaoEmBrancoException;
import models.SimuladorIRPF;

public class PrevidenciaOficial {
    private SimuladorIRPF simul;

	    @Before
	    public void setup(){
	        simul = new SimuladorIRPF();
	    }
	    
		@Test
	    public void testeCadastroPrevOficial() throws DescricaoEmBrancoException{
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 1000f);
	        assertEquals(1000f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
		
		@Test
	    public void testeCadastroPrevOficialDOIS() throws DescricaoEmBrancoException{
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 500f);
	        assertEquals(500f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
		
		@Test
	    public void testeCadastroDUASrevOficialDOIS() throws DescricaoEmBrancoException{
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 1000f);
	        simul.cadastrarPrevidenciaOficial("Carnê INSS", 2000f);
	        assertEquals(3000f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
		
		@Test
	    public void testeCadastroTRESrevOficialDOIS() throws DescricaoEmBrancoException{
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 1000f);
	        simul.cadastrarPrevidenciaOficial("Carnê INSS", 2000f);
	        simul.cadastrarPrevidenciaOficial("Carnê INSS 2", 3000f);
	        assertEquals(6000f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
}
