package model;

public class ApuracaoImposto {
	private static final float LIMITE_QUARTA_FAIXA = 913.63f;
	private static final float LIMITE_TERCEIRA_FAIXA = 924.40f;
	private static final float LIMITE_SEGUNDA_FAIXA = 922.67f;
	private static final float LIMITE_PRIMEIRA_FAIXA = 1903.98f;
	private static final float ALIQUOTA_PRIMEIRA_FAIXA = 7.5f/100;
	private static final float ALIQUOTA_SEGUNDA_FAIXA = 15f/100;
	private static final float ALIQUOTA_TERCEIRA_FAIXA = 22.5f/100;
	private static final float ALIQUOTA_QUARTA_FAIXA = 27.5f/100;
	private Simulador simulador;
	private float base1aFaixa;
	private float base2aFaixa;
	private float base3aFaixa;
	private float base4aFaixa;
	private float base5aFaixa;

	public ApuracaoImposto(Simulador fonte) {
		this.simulador = fonte;
		this.base1aFaixa = this.simulador.getBaseCalculo();
		this.base2aFaixa = base1aFaixa - LIMITE_PRIMEIRA_FAIXA;
		this.base3aFaixa = base2aFaixa - LIMITE_SEGUNDA_FAIXA;
		this.base4aFaixa = base3aFaixa - LIMITE_TERCEIRA_FAIXA;
		this.base5aFaixa = base4aFaixa - LIMITE_QUARTA_FAIXA;
	}
	
	public void computar(){		
		if(this.base1aFaixa > LIMITE_PRIMEIRA_FAIXA){
            // 2a faixa
            this.simulador.addImposto(new Imposto((Math.min(this.base2aFaixa, LIMITE_SEGUNDA_FAIXA) * ALIQUOTA_PRIMEIRA_FAIXA), 2));
            if(this.base2aFaixa > LIMITE_SEGUNDA_FAIXA) {
                // 3a faixa
                this.simulador.addImposto(new Imposto((Math.min(this.base3aFaixa, LIMITE_TERCEIRA_FAIXA) * ALIQUOTA_SEGUNDA_FAIXA), 3));
                if (this.base3aFaixa > LIMITE_TERCEIRA_FAIXA) {
                    // 4a faixa
                    this.simulador.addImposto(new Imposto((Math.min(this.base4aFaixa, LIMITE_QUARTA_FAIXA) * ALIQUOTA_TERCEIRA_FAIXA), 4));
                    if(this.base4aFaixa > LIMITE_QUARTA_FAIXA) {
                        // 5a faixa
                        this.simulador.addImposto(new Imposto((this.base5aFaixa * ALIQUOTA_QUARTA_FAIXA), 5));    
                    }
                }
            }    
        }
	}
}
