package models;

import java.util.LinkedList;
import java.util.List;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorMenorOuIgualZero;


public class SimuladorIRPF {

	private float totalRendimentos;
	private List<Rendimento> rendimentos;
	private float totalPrevidenciOficial;
	private List<PrevidenciaOficial> previdenciasOficiais;
	private String descPensaoAlimentica;
	private float valorPensaoAlimenticia;
	
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

	public void cadastrarPrevidenciaOficial(String descPrevidenciaOficial, float valor) throws  Exception {
		if(descPrevidenciaOficial.trim().length()<1) {
			throw new DescricaoEmBrancoException();
		}
		if(valor<=0) {
			throw new ValorMenorOuIgualZero();
		}
		PrevidenciaOficial prev = new PrevidenciaOficial(descPrevidenciaOficial,valor);
		this.previdenciasOficiais.add(prev);
		this.totalPrevidenciOficial += valor;
		
	}

	public float getTotalDeducaoPrevidenciaOficial() {
		return this.totalPrevidenciOficial;//Duplicacao
	}

	public void cadastraPensaoAlimenticia(String descPensaoAlimentica, float valorPensaoAlimenticia) {
		this.descPensaoAlimentica = descPensaoAlimentica;
		this.valorPensaoAlimenticia = valorPensaoAlimenticia;
		
	}

	public float getPensaoAlimenticia() {
		return this.valorPensaoAlimenticia;// Duplicacao
	}



}
