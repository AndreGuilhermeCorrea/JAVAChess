package xadrez;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

//ESSA CLASSE � O CORA��O DO SISTEMA
//POIS � NELA QUE ESTAR�O AS REGRAS DO JOGO

public class PartidaXadrez {
	
	// no momento de criar a partida cria-se um tabuleiro 8x8 e chama iniciar partida
	
	private Tabuleiro tabuleiro;
	
	//Construtor
	//m�todo para atribuir o tamanho do tabuleiro
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		//iniciar a partida no construtor
		iniciarPartida();
		
	}
	
	//m�todo para retornar uma matriz de pecas de xadrez nessa partida
	//para que o programa conheca apenas a camada de xadrez e nao a camada de tabuleiro
	public PecaXadrez[][] getPecas(){
		//matriz
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		//percorrer a matriz de pecas do tabuleiro e para cada peca do tabuleiro ser� feito um DOWNCASTING para peca de xadrez
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
				
			}
		}
		//terminado o for retornar� a matriz (mat) de pecas de xadrez
		return mat;
	}
	
	
	//m�todo iniciar da partida de xadrez
	//respons�vel por iniciar a partida colocando as pe�as no tabuleiro
	
	private void iniciarPartida() {
		tabuleiro.localPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));
		tabuleiro.localPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
		tabuleiro.localPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));
		
	}
	
	
}
