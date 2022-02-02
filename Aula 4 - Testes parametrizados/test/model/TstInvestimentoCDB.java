package model;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TstInvestimentoCDB {
	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
						{  60, 1000 , 8.5, 1.0829 , 3.14  },
						{ 120, 500  , 8.0, 2.0384 , 2.96  },
						{ 240, 3000 , 9.0, 4.7342 , 35.51 },
						{ 270, 2000 , 8.5, 5.0301 , 25.15 },
						{ 390, 100  , 7.5, 6.6113 , 1.40  },
						{ 420, 250  , 8.0, 7.5945 , 4.03  },
						{ 550, 400  , 8.0, 9.9452 , 8.44  },
						{ 670, 800  , 8.0, 12.1151, 20.56 },
					 	{ 700, 2500 , 9.0, 14.2397, 75.51 },
						{ 900, 4200 , 9.5, 19.9110, 147.58},
						{1000, 100  , 7.5, 17.4658, 3.08  }						
		};

		return Arrays.asList(dados);
	}
	protected InvestimentoCDB original;
	protected double expected_tstRendLiq;
	protected double expected_tstIR;
	
    public TstInvestimentoCDB(double dias, double valor_inicial, double juros_anual, double expected_tstRendLiq, double expected_tstIR) {
      this.original = new InvestimentoCDB(dias,valor_inicial, juros_anual);
      this.expected_tstRendLiq = expected_tstRendLiq;
      this.expected_tstIR = expected_tstIR;
    }
    
	@DisplayName("Verifica o valor do rendimento liquido.")
	@Ignore
	@Test
	public void Test() {}

}
