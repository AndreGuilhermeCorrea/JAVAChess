package xadrez;

import tabuleiroJogo.ExcecaoTabuleiro;

//classe para tratamento das exce�oes extendida para exce�oes do tabuleiro tabuleiro
public class ExcecaoXadrez extends ExcecaoTabuleiro{

	
	private static final long serialVersionUID = 1L;

	//construtor que recebe o string
	public ExcecaoXadrez(String msg) {
		//repassar para o construtor da super classe a mensagem msg
		super(msg);
		
	}
}
