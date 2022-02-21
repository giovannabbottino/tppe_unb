package model;

import java.util.ArrayList;
import java.util.List;

public class Simulador {

	private static List<Rendimento> rendimentos;
	
	public Simulador() {
		rendimentos = new ArrayList<Rendimento>();
	}
	public float cadastrarRendimento(String descricao, float valor) {
		float totalRendimento = 0;
		
		Rendimento temp = new Rendimento(descricao, valor);
		
		Boolean resposta = rendimentos.add(temp);
		
		if(resposta) {		
			for (Rendimento r : rendimentos)
				totalRendimento += r.getValor();
		}
		
		return totalRendimento;
	}

}
