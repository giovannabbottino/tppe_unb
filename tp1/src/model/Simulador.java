package model;

import java.util.ArrayList;
import java.util.List;

import exception.DescricaoEmBrancoException;
import exception.ValorRendimentoInvalidoException;

public class Simulador {

	private static List<Rendimento> rendimentos;
	private float totalRendimento;
	
	public Simulador() {
		rendimentos = new ArrayList<Rendimento>();
		this.totalRendimento = 0;
	}
	
	public void cadastrarRendimento(String descricao, float valor) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException{
		
		Rendimento temp = new Rendimento(descricao, valor);
		
		Boolean resposta = rendimentos.add(temp);
		
		if(resposta) {		
			this.totalRendimento += valor;
		}
	}
	
	public float getTotalRendimento() {
		return totalRendimento;
	}

}
