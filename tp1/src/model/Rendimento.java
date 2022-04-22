package model;


public class Rendimento {
	
	private String descricao;
	private float valor;
	
	public Rendimento(String descricao, float valor){
	
		this.descricao  = descricao;			
		this.valor = valor;			
	}

	public float getValor() {
		return valor;
	}

}
