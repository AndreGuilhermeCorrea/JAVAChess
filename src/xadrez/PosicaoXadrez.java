package xadrez;

import tabuleiroJogo.Posicao;

//classe de conversao posicao comum para posicao xadrez por m�todos devolvendo portanto a posicao do xadrez
public class PosicaoXadrez {

	//sistema de coordenadas pelos argumentos
	private char coluna;
	private int linha;
	
	
	//construtor dos argumentos
	public PosicaoXadrez(char coluna, int linha) {
		//programa��o defensiva por meio do teste
		//se a coluna for fora de a e h ou linha for fora de 1 a 8 n�o ser� aceito a asoccia��o da posi�ao do xadrez
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			//tratamento da exce��o
			throw new ExcecaoXadrez("Erro. Valores aceitos: a1 ate h8!");	
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	//gether permitindo acesso as linhas e colunas, sem os sethers para nao permitir altera��es nas linhas e colunas  
	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}
	
	//m�todos para convers�o da posi��o do xadrez para a posi��o normal atravez do acesso na matriz dada pela subtra��o dos caracteres
	protected Posicao paraPosicao() {
		//retornando nova posicao
		return new Posicao(8 - linha, coluna - 'a');
	}

	protected static PosicaoXadrez dePosicao(Posicao posicao) {
		//retornando inverso do m�todo paraPosicao
		return new PosicaoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());
	}

	//toString da posicao
	
	@Override
	public String toString() {
		// "" serve pra for�ar o compilador entender a compila��o de strings
		return "" + coluna + linha;
		
	}
	
	
	
	
	
	

	
	
	
}
