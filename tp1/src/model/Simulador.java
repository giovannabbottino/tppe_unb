package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.NomeEmBrancoException;
import Exceptions.ValorInvalidoException;
import Exceptions.ValorRendimentoInvalidoException;

public class Simulador {

	private static List<Rendimento> rendimentos;
	
	private List<PrevidenciaOficial> previdenciasOficiais;
	
	private float valorTotalPensaoAlimenticia;
	private List<PensaoAlimentica> pensoesAlimentica;
	
	private float valorTotalDependente;
	private List<Dependente> dependente;
	
	private List<Deducao> deducoes;
	
	
	private float totalImposto;
	private float baseCalculo;
	private float aliquotaEfetiva;
	private List<Imposto> impostos;
	
	public void addImposto(Imposto imposto) {
		this.impostos.add(imposto);
	}
	
	public Simulador() {
		rendimentos = new ArrayList<Rendimento>();
		
		previdenciasOficiais =new LinkedList<PrevidenciaOficial>();
		
		pensoesAlimentica = new LinkedList<PensaoAlimentica>();
		
		dependente = new LinkedList<Dependente>();
		deducoes = new LinkedList<Deducao>();
		
		this.baseCalculo = 0;

		this.totalImposto = 0;
		impostos = new ArrayList<Imposto>();
		
		this.aliquotaEfetiva = 0;
		
	}
	
	public void cadastrarRendimento(String descricao, float valor) throws DescricaoEmBrancoException, ValorInvalidoException{
		

		verificaExceptions(descricao, valor);
		Rendimento temp = new Rendimento(descricao, valor);
		
		rendimentos.add(temp);
	}
	
	public float getTotalRendimento() {
		float totalRendimento =0.0f;
		for(Rendimento rendimento: this.rendimentos) {
			totalRendimento+= rendimento.getValor();
		}
		return totalRendimento;
	}
	

	public void cadastrarPrevidenciaOficial(String descPrevidenciaOficial, float valor) throws  Exception {
		verificaExceptions(descPrevidenciaOficial, valor);
		PrevidenciaOficial prev = new PrevidenciaOficial(descPrevidenciaOficial,valor);
		this.previdenciasOficiais.add(prev);
		
	}

	public float getTotalDeducaoPrevidenciaOficial() {
		float totalPrevidenciOficial= 0.0f;
		for(PrevidenciaOficial prev: this.previdenciasOficiais) {
			totalPrevidenciOficial+= prev.getValor();
		}
		return totalPrevidenciOficial;
	}



	public void cadastraPensaoAlimenticia(String descPensaoAlimentica, float valorPensaoAlimenticia) throws Exception {
		verificaExceptions(descPensaoAlimentica, valorPensaoAlimenticia);
		PensaoAlimentica pensao = new PensaoAlimentica(descPensaoAlimentica,valorPensaoAlimenticia);
		this.pensoesAlimentica.add(pensao);
		
	
		
	}

	public float getTotalPensaoAlimenticia() {
		float valorTotalPensaoAlimenticia =0.0f;
		for(PensaoAlimentica pensao: this.pensoesAlimentica) {
			valorTotalPensaoAlimenticia+= pensao.getValor();
		}
		return valorTotalPensaoAlimenticia;
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
		return this.valorTotalDependente;
	}
	
	

	public void cadastraDeducao(String descricaoDeducao, float valorDeducao) throws Exception  {
		verificaExceptions(descricaoDeducao, valorDeducao);
		
		Deducao deducao = new Deducao(descricaoDeducao,valorDeducao);
		this.deducoes.add(deducao);
		
		
	}

	public float getTotalDeducao() {
		float valorTotalDeducao=0.0f;
		for(Deducao deducao: this.deducoes) {
			valorTotalDeducao+= deducao.getValor();
		}
		return valorTotalDeducao ;
	}
	
	public void setBaseCalculo(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}
	
	public float getBaseCalculo() {
		return this.baseCalculo;
	}
	

	public void apuracaoImposto() {		
		new ApuracaoImposto(this).computar();
	}
	
	public float getTotalImposto() {
		for(Imposto i : impostos){
			this.totalImposto += i.getValor();
		}
		return this.totalImposto;
	}

	public float getAliquotaEfetiva() {
		return this.aliquotaEfetiva;
	}

	public void setAliquotaEfetiva() {
		this.aliquotaEfetiva = ( this.getTotalImposto()/this.getTotalRendimento() ) * 100;
	}
	
	private void verificaExceptions(String descricao, float valor)
			throws DescricaoEmBrancoException, ValorInvalidoException {
		if(descricao.trim().length()<1) {
			throw new DescricaoEmBrancoException();
		}
		if(valor<=0) {
			throw new ValorInvalidoException();
		}
	}

}
