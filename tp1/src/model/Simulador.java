package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.NomeEmBrancoException;
import Exceptions.ValorDeducaoInvalidoException;
import Exceptions.ValorRendimentoInvalidoException;

public class Simulador {

	private static List<Rendimento> rendimentos;
	private float totalRendimento;
	
	private float totalPrevidenciOficial;
	private List<PrevidenciaOficial> previdenciasOficiais;
	
	private float valorTotalPensaoAlimenticia;
	private List<PensaoAlimentica> pensoesAlimentica;
	
	private float valorTotalDependente;
	private List<Dependente> dependente;
	
	public Simulador() {
		rendimentos = new ArrayList<Rendimento>();
		this.totalRendimento = 0;
		
		previdenciasOficiais =new LinkedList<PrevidenciaOficial>();
		
		pensoesAlimentica = new LinkedList<PensaoAlimentica>();
		
		dependente = new LinkedList<Dependente>();
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
	
	public void cadastraDependente(String nomeDependente, String dataDeNascimento) throws Exception {
		if(nomeDependente.trim().length()<1) {
			throw new NomeEmBrancoException();
		}
		Dependente dependente = new Dependente(nomeDependente, dataDeNascimento);
		this.dependente.add(dependente);
		
		this.valorTotalDependente += 189.59f;
	}

	public float getDependente() {
		return this.valorTotalDependente; // Duplicacao
	}
	
	

}
