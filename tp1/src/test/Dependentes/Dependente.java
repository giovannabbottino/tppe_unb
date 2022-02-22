package test.Dependentes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import models.SimuladorIRPF;

public class Dependente {
    private SimuladorIRPF simul;

	    @Before
	    public void setup(){
	        simul = new SimuladorIRPF();
	    }
	    
		@Test
	    public void testeCadastraDependente(){
	        simul.cadastraDependente("Joãozinho", "10/01/2000");
	        assertEquals(189.59f, simul.getDependente(),0f);
	    }
		
		@Test
	    public void testeCadastraUmDependente(){
	        simul.cadastraDependente("Mariazinha", "10/01/2000");
	        assertEquals(189.59f, simul.getDependente(),0f);
	    }
		
		@Test
	    public void testeCadastraDoisDependente(){
	        simul.cadastraDependente("José", "01/02/2008");
	        simul.cadastraDependente("Maria", "22/05/2010");
	        assertEquals(379.18f, simul.getDependente(),0f);
	    }
}
