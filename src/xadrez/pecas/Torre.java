package xadrez.pecas;

import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

//pecas do xadrez no sub-pacote (apenas para Oganiza�ao das classes)

public class Torre extends PecaXadrez {

	//construtor para repassar a chamada para superclasse 
	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	
	}
	
	
	//toString da classe
	//coversao da torre para string
	@Override
	public String toString() {
		return "T";//essa letra entrar� na impressao do tabuleiro, ou seja no local da pe�a aparecer� a letra
	}


	@Override
	public boolean[][] movimentosPossiveis() {
		//matriz de boolean na mesma dimens�o do tabuleiro
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}
}
