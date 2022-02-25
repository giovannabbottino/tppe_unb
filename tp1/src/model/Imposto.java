package model;

public class Imposto {
	float valor;
	int faixa;
	
	public Imposto(float valor, int faixa) {
		this.valor = valor;
		this.faixa = faixa;
	}

	public float getValor() {
		return this.valor;
	}	

}
