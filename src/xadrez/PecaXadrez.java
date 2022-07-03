package xadrez;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	
	//atributo da classe
	private Cor cor;

	//construtor recebendo o tabuleiro e a cor
	//nesse caso o tabuleiro repassa a chamada para o construtor da superclasse que � o construtor da classe peca 
	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	//apenas o get para que a cor seja apenas acessada e nao modificada
	public Cor getCor() {
		return cor;
	}
	
	//implementa��o do m�todo para verificar se existe uma peca advers�ria na posicao
	protected boolean existePecaOponente(Posicao posicao) {
		//teste com downcasting para saber se a pe�a p � advers�ria se o p � diferente de nulo e se p � diferente da cor da minha peca
		PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}


}
