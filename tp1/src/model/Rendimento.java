package model;

public class Rendimento {
	
	private String descricao;
	private double valor;
	
	public Rendimento(String descricao, double valor){
			this.descricao  = descricao;			
			this.valor = valor;			
	}

	public double getValor() {
		return valor;
	}

}
