package test;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import models.SimuladorIRPF;

public class PrevidenciaOficial {
    private SimuladorIRPF simul;

	    @Before
	    public void setup(){
	        simul = new SimuladorIRPF();
	    }
	    
		@Test
	    public void testeCadastroPrevOficial(){
	        simul.cadastrarPrevidenciaOficial("Contribuição compulsoria", 1000f);
	        assertEquals(1000f, simul.getTotalDeducaoPrevidenciaOficial(),0f);
	    }
}
