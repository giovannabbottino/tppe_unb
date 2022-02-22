package models;

import java.util.LinkedList;
import java.util.List;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorDeducaoInvalidoException;


public class SimuladorIRPF {

	private float totalRendimentos;
	private List<Rendimento> rendimentos;
	private float totalPrevidenciOficial;
	private List<PrevidenciaOficial> previdenciasOficiais;
	
	private float valorTotalPensaoAlimenticia;
	private List<PensaoAlimentica> pensoesAlimentica;
	
	private float valorTotalDependente;
	private List<Dependente> dependente;
	
	public SimuladorIRPF() {
		rendimentos = new LinkedList<Rendimento>();
		
		previdenciasOficiais =new LinkedList<PrevidenciaOficial>();
		
		pensoesAlimentica = new LinkedList<PensaoAlimentica>();
		
		dependente = new LinkedList<Dependente>();
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
			throw new ValorDeducaoInvalidoException();
		}
		PrevidenciaOficial prev = new PrevidenciaOficial(descPrevidenciaOficial,valor);
		this.previdenciasOficiais.add(prev);
		this.totalPrevidenciOficial += valor;
		
	}

	public float getTotalDeducaoPrevidenciaOficial() {
		return this.totalPrevidenciOficial;//Duplicacao
	}

	public void cadastraPensaoAlimenticia(String descPensaoAlimentica, float valorPensaoAlimenticia) throws Exception {
		if(descPensaoAlimentica.trim().length()<1) {
			throw new DescricaoEmBrancoException();
		}
		if(valorPensaoAlimenticia<=0) {
			throw new ValorDeducaoInvalidoException();
		}
		PensaoAlimentica pensao = new PensaoAlimentica(descPensaoAlimentica,valorPensaoAlimenticia);
		this.pensoesAlimentica.add(pensao);
		
		this.valorTotalPensaoAlimenticia += valorPensaoAlimenticia;
		
	}

	public float getPensaoAlimenticia() {
		return this.valorTotalPensaoAlimenticia;// Duplicacao
	}
	
	public void cadastraDependente(String nomeDependente, String dataDeNascimento){
		Dependente dependente = new Dependente(nomeDependente, dataDeNascimento);
		this.dependente.add(dependente);
		
		this.valorTotalDependente += 189.59f;
	}

	public float getDependente() {
		return this.valorTotalDependente; // Duplicacao
	}

}
