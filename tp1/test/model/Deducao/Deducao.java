package model.Deducao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Simulador;

public class Deducao {

	private Simulador simul;

    @Before
    public void setup(){
        simul = new Simulador();
    }
    
	@Test
    public void testeCadastraDeducaoUm() {
        simul.cadastraDeducao("Previdencia privada", 1500f);
        
        assertEquals(1500f, simul.getDeducao(),0f);
    }
	@Test
    public void testeCadastraDeducaoDois() {
        simul.cadastraDeducao("Previdencia privada", 1200f);
        
        assertEquals(1200f, simul.getDeducao(),0f);
    }
	
	
}
