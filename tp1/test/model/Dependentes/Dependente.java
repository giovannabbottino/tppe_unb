package model.Dependentes;

import static org.junit.Assert.assertEquals;
import Exceptions.NomeEmBrancoException;
import model.Simulador;

import org.junit.Before;
import org.junit.Test;


public class Dependente {
    private Simulador simul;

	    @Before
	    public void setup(){
	        simul = new Simulador();
	    }
	    
		@Test
	    public void testeCadastraDependente() throws Exception{
	        simul.cadastraDependente("Joãozinho", "10/01/2000");
	        assertEquals(189.59f, simul.getDependente(),0f);
	    }
		
		@Test
	    public void testeCadastraUmDependente() throws Exception{
	        simul.cadastraDependente("Mariazinha", "10/01/2000");
	        assertEquals(189.59f, simul.getDependente(),0f);
	    }
		
		@Test
	    public void testeCadastraDoisDependente() throws Exception{
	        simul.cadastraDependente("José", "01/02/2008");
	        simul.cadastraDependente("Maria", "22/05/2010");
	        assertEquals(379.18f, simul.getDependente(),0f);
	    }
		
		@Test(expected = NomeEmBrancoException.class)
		public void testeNomeEmBranco() throws Exception {
			simul.cadastraDependente(" ", "27/03/2005");

		}
}
