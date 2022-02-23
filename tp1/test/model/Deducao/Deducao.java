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
    public void testeCadastraDeducao() {
        simul.cadastraDeducao("Previdencia privada", 1500f);
        
        assertEquals(1500f, simul.getDeducao(),0f);
    }
	
}
