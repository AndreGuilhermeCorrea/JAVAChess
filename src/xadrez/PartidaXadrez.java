package xadrez;

import tabuleiroJogo.Tabuleiro;

//ESSA CLASSE É O CORAÇÃO DO SISTEMA
//POIS É NELA QUE ESTARÃO AS REGRAS DO JOGO

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	//método para atribuir o tamanho do tabuleiro
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		
	}
	
	//método para retornar uma matriz de pecas de xadrez nessa partida
	//para que o programa conheca apenas a camada de xadrez e nao a camada de tabuleiro
	public PecaXadrez[][] getPecas(){
		//matriz
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		//percorrer a matriz de pecas do tabuleiro e para cada peca do tabuleiro será feito um DOWNCASTING para peca de xadrez
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
				
			}
		}
		//terminado o for retornará a matriz (mat) de pecas de xadrez
		return mat;
	}
}
