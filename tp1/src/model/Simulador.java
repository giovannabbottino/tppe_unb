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
	
	private List<Deducao> deducoes;
	private float valorTotalDeducao;
	
	
	private float totalImposto;
	private float baseCalculo;
	private static List<Imposto> impostos;
	
	public Simulador() {
		rendimentos = new ArrayList<Rendimento>();
		this.totalRendimento = 0;
		
		previdenciasOficiais =new LinkedList<PrevidenciaOficial>();
		
		pensoesAlimentica = new LinkedList<PensaoAlimentica>();
		
		dependente = new LinkedList<Dependente>();
		
		this.baseCalculo = 0;

		this.totalImposto = 0;
		impostos = new ArrayList<Imposto>();
		
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
		return this.totalPrevidenciOficial;
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
		return this.valorTotalPensaoAlimenticia;
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
		if(descricaoDeducao.trim().length()<1) {
			throw new DescricaoEmBrancoException();
		}
		if(valorDeducao<=0) {
			throw new ValorDeducaoInvalidoException();
		}
		
		Deducao deducao = new Deducao(descricaoDeducao,valorDeducao);
		this.valorTotalDeducao += valorDeducao;
		
		
	}

	public float getDeducao() {
		return this.valorTotalDeducao ;
	}
	
	public void setBaseCalculo(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}
	
	public float getBaseCalculo() {
		return this.baseCalculo;
	}
	

	public void apuracaoImposto() {		
		Imposto temp;
		float base = this.baseCalculo;
		
		if (base > 1903.98f){
            // 2a faixa
            base -= 1903.98f;
            temp = new Imposto((Math.min(base, 922.67f) * 7.5f/100), 2); 
            impostos.add(temp);
            if(base > 922.67f) {
                // 3a faixa
                base -= 922.67f;
                temp = new Imposto((Math.min(base, 924.40f) * 15f/100), 3); 
                impostos.add(temp);
                if (base > 924.40f) {
                    // 4a faixa
                    base -= 924.40f;
                    temp = new Imposto((Math.min(base, 913.63f) * 22.5f/100), 4);
                    impostos.add(temp);
                    if(base > 913.63f) {
                        // 5a faixa
                        base -= 913.63f;
                        temp = new Imposto(( base * 27.5f/100), 5);
                        impostos.add(temp);
                        
                    }
                }
            }    
        }
	}
	
	public float getTotalImposto() {
		for(Imposto i : impostos){
			this.totalImposto += i.getValor();
		}
		return this.totalImposto;
	}
	
	

}
