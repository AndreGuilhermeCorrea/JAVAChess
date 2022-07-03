package tabuleiroJogo;

//pos��o protect #posicao


public abstract class  Peca {
	
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

	
	//dada uma pe�a, seus possiveis movimentos se d� por meio de uma matriz de valores booleanos contendo os poss�veis movimentos
	//essa matriz possuir� um valor falso em todas as pe�as porem um valor verdadeiro nas casas pelas quais as pe�as podem se mover

	//implementa��o opera��o movimentos possiveis de uma peca gen�rica portanto m�todo abstrato 
	public abstract boolean[][] movimentosPossiveis();
	
	//implementa��o do m�todo movimento possivel para verificar se a peca pode se mover para uma dada posicao
	//esse m�todo concreto otimiza o m�todo abstrato (m�todo que faz subgancho com a subclasse da classe peca
	public boolean movimentoPossivel(Posicao posicao) {
		//teste retornando o m�todo movimentosPossiveis (matriz) na linha x e na coluna y
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	
	//implementa��o do m�todo se existe pelo menos um movimento possivel ou essa peca se encontra presa(xeque)
	//m�todo padr�o concreto que depende de um m�todo abstrato
	public boolean umPossivelMovimento() {
		//chamada do m�todo abstrato movimentosPossiveis que retornar� uma matriz de boolean 
		//fazer entao uma varredura para saber se existe pelo menos uma posicao na matriz que seja verdadeira
		//variavel auxiliar tipo boolean recebendo movimentosPossiveis (chamada do m�todo abstrato)
		boolean [][] mat = movimentosPossiveis();
		//varredura para saber se possui posi��o verdadeira
		for (int i=0; i<mat.length; i++) {
			//.length pois presume-se que a matriz � quadrada 
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
