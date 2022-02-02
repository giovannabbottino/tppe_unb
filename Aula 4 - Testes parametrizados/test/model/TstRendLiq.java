package model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TstRendLiq extends TstInvestimentoCDB{
	
	public TstRendLiq(double dias, double valor_inicial, double juros_anual, double expected_tstRendLiq, double expected_tstIR) {
		super(dias, valor_inicial, juros_anual, expected_tstRendLiq, expected_tstIR);
	}

	@DisplayName("Verifica o valor do rendimento liquido.")
	@Test
	public void Test() {
		Assert.assertEquals(this.expected_tstRendLiq, this.original.getRendimentoLiquido(), 0.001);
	}

}
