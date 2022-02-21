package Exceptions;

public class ValorDeducaoInvalidoException  extends Exception{
	public ValorDeducaoInvalidoException() {
		super("Valor Menor ou igual a zero!");
	}

}
