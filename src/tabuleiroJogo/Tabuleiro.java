package tabuleiroJogo;

//classe tabuleiro com linhas e colunas 




/*
8 - - - - - - - -
7 - - - - - - - -
6 - - - - - - - -
5 - - - - - - - -
4 - - - - - - - -
3 - - - - - - - -
2 - - - - - - - -
1 - - - - - - - -
 a b c d e f g h
 */

public class Tabuleiro {

	private int linhas;
	private int colunas;
	// matriz de pecas
	private Peca[][] pecas;

	// construtor apenas com a quantidade de linhas e colunas
	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		//matriz de pecas sendo instanciada com peca na quantidade de linhas informadas e na quantidade de colunas informadas
		pecas = new Peca[linhas][colunas];
		
	}

	// gethers e sether da linha e coluna
	// pois a classe tabuleiro ira retorna apenas uma peca por vez

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	//m�todo para retornar uma peca dada linha e coluna
	
	public Peca peca(int linha, int coluna) {
		//m�todo retorna matriz pecas na linha e coluna
		return pecas[linha][coluna];
	}
	
	//sobrecarga do metodo peca recebendo a posicao da posicao
	public Peca peca(Posicao posicao) {
		//m�toro retornara a peca pela posicao
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
}
