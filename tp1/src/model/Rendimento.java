package model;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorRendimentoInvalidoException;
public class Rendimento {
	
	private String descricao;
	private float valor;
	
	public Rendimento(String descricao, float valor) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException{
		if (descricao.isEmpty() || descricao == null) throw new DescricaoEmBrancoException();
		if (valor < 0 ) throw new ValorRendimentoInvalidoException();
		this.descricao  = descricao;			
		this.valor = valor;			
	}

	public float getValor() {
		return valor;
	}

}
