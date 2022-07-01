package xadrez.pecas;

import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

//pecas do xadrez no sub-pacote (apenas para Oganiza�ao das classes)

public class Rei extends PecaXadrez {

	// construtor para repassar a chamada para superclasse
	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	
	}

	// toString da classe
	// coversao da torre para string
	@Override
	public String toString() {
		return "R";// essa letra entrar� na impressao do tabuleiro, ou seja no local da pe�a
					// aparecer� a letra
	}
}
