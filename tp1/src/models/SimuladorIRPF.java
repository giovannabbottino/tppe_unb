package models;

import java.util.LinkedList;
import java.util.List;

import Exceptions.DescricaoEmBrancoException;


public class SimuladorIRPF {

	private float totalRendimentos;
	private List<Rendimento> rendimentos;
	private float totalPrevidenciOficial;
	private List<PrevidenciaOficial> previdenciasOficiais;
	
	public SimuladorIRPF() {
		rendimentos = new LinkedList<Rendimento>();
		
		previdenciasOficiais =new LinkedList<PrevidenciaOficial>();
	}

	public void cadastrarRendimento(String descricao, float valorRendimento) {
		Rendimento r = new Rendimento(descricao, valorRendimento);
		this.rendimentos.add(r);
		
		this.totalRendimentos += valorRendimento;
	}

	public float getTotalRendimentos() {
		return totalRendimentos;
	}

	public void cadastrarPrevidenciaOficial(String descPrevidenciaOficial, float valor) throws  DescricaoEmBrancoException {
		if(descPrevidenciaOficial.trim().length()<1) {
			throw new DescricaoEmBrancoException();
		}
		PrevidenciaOficial prev = new PrevidenciaOficial(descPrevidenciaOficial,valor);
		this.previdenciasOficiais.add(prev);
		this.totalPrevidenciOficial += valor;
		
	}

	public float getTotalDeducaoPrevidenciaOficial() {
		return this.totalPrevidenciOficial;//Duplicacao
	}



}
