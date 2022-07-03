package xadrez;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	
	//atributo da classe
	private Cor cor;
	
	//atributo contarMovimentos inteiro por padr�o comeca com valor 0
	private int contarMovimentos;

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
	
	//gether da contagem
	public int getContarMovimentos() {
		return contarMovimentos;
	}
	
	//m�todo para incrementar ou decrementa o atributo
	public void aumentarContagemMovimentos() {
		contarMovimentos++;
		
	}
	
	public void diminuirContagemMovimentos() {
		contarMovimentos--;
	}
	
	//m�todo para retornar a posicao no formato do xadrez (letra e Numero)
	public PosicaoXadrez getPosicaoXadrez() {
		//conversao da posicao herdada da peca para a posicao xadrez 
		//atravez do m�todo estatico da posicaoxadrez
		return PosicaoXadrez.dePosicao(posicao);	
	}
	
	//implementa��o do m�todo para verificar se existe uma peca advers�ria na posicao
	protected boolean existePecaOponente(Posicao posicao) {
		//teste com downcasting para saber se a pe�a p � advers�ria se o p � diferente de nulo e se p � diferente da cor da minha peca
		PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}


}
