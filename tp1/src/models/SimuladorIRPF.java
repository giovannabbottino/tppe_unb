package models;

import java.util.LinkedList;
import java.util.List;

public class SimuladorIRPF {

	private float totalRendimentos;
	private List<Rendimento> rendimentos;
	private float previdenciOficial;
	private String descPrevidenciOficial;
	
	public SimuladorIRPF() {
		rendimentos = new LinkedList<Rendimento>();
	}

	public void cadastrarRendimento(String descricao, float valorRendimento) {
		Rendimento r = new Rendimento(descricao, valorRendimento);
		this.rendimentos.add(r);
		
		this.totalRendimentos += valorRendimento;
	}

	public float getTotalRendimentos() {
		return totalRendimentos;
	}

	public void cadastrarPrevidenciaOficial(String descPrevidenciaOficial, float valor) {
		this.descPrevidenciOficial = descPrevidenciaOficial;
		this.previdenciOficial = valor;

		
	}

	public float getTotalDeducaoPrevidenciaOficial() {
		return 1000f;//Falsificacao
	}



}
