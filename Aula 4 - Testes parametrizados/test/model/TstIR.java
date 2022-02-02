package model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TstIR extends TstInvestimentoCDB{
	
	public TstIR(double dias, double valor_inicial, double juros_anual, double expected_tstRendLiq, double expected_tstIR) {
		super(dias, valor_inicial, juros_anual, expected_tstRendLiq, expected_tstIR);
	}
	
	@DisplayName("Verifica o valor do imposto de renda")
	@Test
	public void Test() {
		Assert.assertEquals(this.expected_tstIR, this.original.getImposto_renda(), 0.01);
	}

}
