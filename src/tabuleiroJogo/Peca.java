package tabuleiroJogo;

//posção protect #posicao


public class Peca {
	
	protected Posicao posicao;
	
	//a peça conhece onde se encontra para tal deve ter uma associação peca com tabuleiro 
	//da mesma forma que o tabuleiro tera associação com as pecas
	
	private Tabuleiro tabuleiro;

	//construtor da peca
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	//apenas o get para acessa-lo e nao com set para nao altera-lo
	//também deverá ser protected pois apenas classes do mesmo pacote e subclasses poderão acessar o tabuleiro de uma peça
	//impedindo que o tabuleiro seja acessivel pela camada de xadrez sendo portanto para uso interno da camada de tabuleiro
	 
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	
	
	
	

}
