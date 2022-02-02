package model;

public class InvestimentoCDB {
	private double dias;
	private double anos;
	private double valor_inicial;
	private double juros_anual;
	private double imposto_renda;
	private double porcentagem_imposto_renda;
	private double rendimento_bruto;
	private double rendimento_liquido;
	
	public InvestimentoCDB(double dias, double valor_inicial, double juros_anual) {
		this.dias = dias;
		this.valor_inicial = valor_inicial;
		this.juros_anual = juros_anual;
		this.setAnos();
		this.setPorcentagemImposto_renda();
		this.setRendimentoBruto();
		this.setImposto_renda();
		this.setRendimentoLiquido();
	}

	public double getRendimentoLiquido() {
		return this.rendimento_liquido;
	}
	
	public void setRendimentoLiquido() {
		this.rendimento_liquido = 
				( 
					( 
						(
								this.getRendimentoBruto() + this.valor_inicial - this.getImposto_renda() 
						) /  this.valor_inicial
					) * 100 
				) - 100;
	}

	public double getDias() {
		return dias;
	}


	public void setDias(double dias) {
		this.dias = dias;
	}


	public double getAnos() {
		return this.anos;
	}


	public void setAnos() {
		this.anos = this.dias / 365;
	}


	public double getValor_inicial() {
		return valor_inicial;
	}


	public void setValor_inicial(double valor_inicial) {
		this.valor_inicial = valor_inicial;
	}


	public double getJuros_anual() {
		return juros_anual;
	}


	public void setJuros_anual(double juros_anual) {
		this.juros_anual = juros_anual;
	}


	public double getImposto_renda() {
		return imposto_renda;
	}
	
	public void setImposto_renda() {
		this.imposto_renda = (this.porcentagem_imposto_renda * this.rendimento_bruto) / 100;
	}
	
	public double getPorcentagemImposto_renda() {
		return porcentagem_imposto_renda;
	}

	public void setPorcentagemImposto_renda() {
		double porcentagem_imposto_renda;
		if (this.dias <= 180) {
			porcentagem_imposto_renda = 22.5;
		} else if (this.dias >= 181 && this.dias <= 360) {
			porcentagem_imposto_renda = 20;
		}  else if (this.dias >= 361 && this.dias <= 720) {
			porcentagem_imposto_renda = 17.5;
		} else {
			porcentagem_imposto_renda = 15;
		}
		this.porcentagem_imposto_renda = porcentagem_imposto_renda;
	}
	
	public void setRendimentoBruto() {
		this.rendimento_bruto = this.anos * this.valor_inicial * ( this.juros_anual/100 );
	}
	
	public double getRendimentoBruto() {
		return this.rendimento_bruto;
	}

}
