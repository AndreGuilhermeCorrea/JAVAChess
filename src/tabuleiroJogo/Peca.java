package tabuleiroJogo;

//pos��o protect #posicao


public class Peca {
	
	protected Posicao posicao;
	
	//a pe�a conhece onde se encontra para tal deve ter uma associa��o peca com tabuleiro 
	//da mesma forma que o tabuleiro tera associa��o com as pecas
	
	private Tabuleiro tabuleiro;

	//construtor da peca
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	//apenas o get para acessa-lo e nao com set para nao altera-lo
	//tamb�m dever� ser protected pois apenas classes do mesmo pacote e subclasses poder�o acessar o tabuleiro de uma pe�a
	//impedindo que o tabuleiro seja acessivel pela camada de xadrez sendo portanto para uso interno da camada de tabuleiro
	 
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	
	
	
	

}
