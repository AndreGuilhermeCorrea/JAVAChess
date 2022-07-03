package xadrez;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	
	//atributo da classe
	private Cor cor;

	//construtor recebendo o tabuleiro e a cor
	//nesse caso o tabuleiro repassa a chamada para o construtor da superclasse que é o construtor da classe peca 
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	//apenas o get para que a cor seja apenas acessada e nao modificada
	public Cor getCor() {
		return cor;
	}


	
	
	
	
	
	
}
