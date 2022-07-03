package xadrez;

import tabuleiroJogo.Posicao;

//classe de conversao posicao comum para posicao xadrez por métodos devolvendo portanto a posicao do xadrez
public class PosicaoXadrez {

	//sistema de coordenadas pelos argumentos
	private char coluna;
	private int linha;
	
	
	//construtor dos argumentos
	public PosicaoXadrez(char coluna, int linha) {
		//programação defensiva por meio do teste
		//se a coluna for fora de a e h ou linha for fora de 1 a 8 não será aceito a asocciação da posiçao do xadrez
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			//tratamento da exceção
			throw new ExcecaoXadrez("Erro. Valores aceitos: a1 ate h8!");	
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	//gether permitindo acesso as linhas e colunas, sem os sethers para nao permitir alterações nas linhas e colunas  
	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}
	
	//métodos para conversão da posição do xadrez para a posição normal atravez do acesso na matriz dada pela subtração dos caracteres
	protected Posicao paraPosicao() {
		//retornando nova posicao
		return new Posicao(8 - linha, coluna - 'a');
	}

	protected static PosicaoXadrez dePosicao(Posicao posicao) {
		//retornando inverso do método paraPosicao
		return new PosicaoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());
	}

	//toString da posicao
	
	@Override
	public String toString() {
		// "" serve pra forçar o compilador entender a compilação de strings
		return "" + coluna + linha;
		
	}
	
	
	
	
	
	

	
	
	
}
