package model;

import java.util.ArrayList;
import java.util.List;

public class ApuracaoImposto {
	private Simulador simulador;
	private Imposto temp;
	private float base;
	//private List<Imposto> impostos;

	public ApuracaoImposto(Simulador fonte) {
		this.simulador = fonte;
		//this.impostos = new ArrayList<Imposto>();
	}
	
	public void computar(){		
		this.base = this.simulador.getBaseCalculo();
		if (this.base > 1903.98f){
            // 2a faixa
            this.base -= 1903.98f;
            this.temp = new Imposto((Math.min(this.base, 922.67f) * 7.5f/100), 2); 
            this.simulador.addImposto(this.temp);
            if(this.base > 922.67f) {
                // 3a faixa
                this.base -= 922.67f;
                this.temp = new Imposto((Math.min(this.base, 924.40f) * 15f/100), 3); 
                this.simulador.addImposto(this.temp);
                if (this.base > 924.40f) {
                    // 4a faixa
                    this.base -= 924.40f;
                    this.temp = new Imposto((Math.min(this.base, 913.63f) * 22.5f/100), 4);
                    this.simulador.addImposto(this.temp);
                    if(this.base > 913.63f) {
                        // 5a faixa
                        this.base -= 913.63f;
                        this.temp = new Imposto(( this.base * 27.5f/100), 5);
                        this.simulador.addImposto(this.temp);
                        
                    }
                }
            }    
        }
	}
}
