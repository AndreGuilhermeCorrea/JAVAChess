package tabuleiroJogo;

//posção protect #posicao


public abstract class  Peca {
	
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

	
	//dada uma peça, seus possiveis movimentos se dá por meio de uma matriz de valores booleanos contendo os possíveis movimentos
	//essa matriz possuirá um valor falso em todas as peças porem um valor verdadeiro nas casas pelas quais as peças podem se mover

	//implementação operação movimentos possiveis de uma peca genérica portanto método abstrato 
	public abstract boolean[][] movimentosPossiveis();
	
	//implementação do método movimento possivel para verificar se a peca pode se mover para uma dada posicao
	//esse método concreto otimiza o método abstrato (método que faz subgancho com a subclasse da classe peca
	public boolean movimentoPossivel(Posicao posicao) {
		//teste retornando o método movimentosPossiveis (matriz) na linha x e na coluna y
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	
	//implementação do método se existe pelo menos um movimento possivel ou essa peca se encontra presa(xeque)
	//método padrão concreto que depende de um método abstrato
	public boolean umPossivelMovimento() {
		//chamada do método abstrato movimentosPossiveis que retornará uma matriz de boolean 
		//fazer entao uma varredura para saber se existe pelo menos uma posicao na matriz que seja verdadeira
		//variavel auxiliar tipo boolean recebendo movimentosPossiveis (chamada do método abstrato)
		boolean [][] mat = movimentosPossiveis();
		//varredura para saber se possui posição verdadeira
		for (int i=0; i<mat.length; i++) {
			//.length pois presume-se que a matriz é quadrada 
			for (int j=0; j<mat.length; j++) {
				//teste
				if (mat[i][j]) {
					return true;		
				}				
			}
		}
		return false;
	}
	

}
