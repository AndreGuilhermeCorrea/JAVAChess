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
		if (linhas < 1 || colunas < 1) {
			// se o teste acima ser verdadeiro será lancado uma exceção (throw)
			throw new ExcecaoTabuleiro("Erro na criação do tabuleiro!!!");

		}
		this.linhas = linhas;
		this.colunas = colunas;
		// matriz de pecas sendo instanciada com peca na quantidade de linhas informadas
		// e na quantidade de colunas informadas
		pecas = new Peca[linhas][colunas];

	}

	// gethers e sether da linha e coluna
	// pois a classe tabuleiro ira retorna apenas uma peca por vez
	// foi retirado os gethers da linha e coluna para que nao seja alterada a
	// quantidade de linhas e colunas no tabuloeiro

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	// método para retornar uma peca em uma dada linha e coluna
	public Peca peca(int linha, int coluna) {

		// programação defensiva atravez de um teste
		if (!posicaoExistente(linha, coluna)) {

			// se essa posicao nao existir será lancado uma nova exceção
			throw new ExcecaoTabuleiro("Essa posição nao existe!!!");
		}

		// método retorna matriz pecas na linha e coluna
		return pecas[linha][coluna];
	}

	// sobrecarga do metodo peca recebendo a posicao da posicao
	public Peca peca(Posicao posicao) {

		// programação defensiva atravez de um teste
		if (!posicaoExistente(posicao)) {

			// se essa posicao nao existir será lancado uma nova exceção
			throw new ExcecaoTabuleiro("Essa posição nao existe!!!");
		}

		// métoro retornara a peca pela posicao
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	// método para colocar peca na posicao
	public void localPeca(Peca peca, Posicao posicao) {
		// teste para saber se tem outra peça na posicao
		if (pecaNaPosicao(posicao)) {

			// será portanto lançado uma exceção
			throw new ExcecaoTabuleiro("Já existe uma peça nessa posição!!! " + posicao);

		}
		// na matriz de peca do tabuleiro instanciada no construtor
		// atribuir na matriz de pecas a peca que veio como argumento
		// matriz na posicao dada atribuir a ela a peca
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;

		// ou seja ela passa a para a seguinte posição informada no método
		// a posicao da peca é acessivel diretamente pois esta como protect, por estar
		// no mesmo pacote torna-se possivel acessar livremente a posicao da peca
		peca.posicao = posicao;
	}

	// método auxiliar posicaoExistente receber uma linha e uma coluna
	// tornando portanto realizar o teste pela linha e coluna ao invés da posiçao
	private boolean posicaoExistente(int linha, int coluna) {
		// posicao só existe se estiver dentro do tabuleiro atravez da condição
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	// implementando a funçao se a posição existe através do boolean e recebendo uma
	// posicao como argumento
	public boolean posicaoExistente(Posicao posicao) {
		// com base na implementaçao acima(reaproveitamento), esse método testará se a
		// posicao é existente
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}

	public boolean pecaNaPosicao(Posicao posicao) {
		
		// programação defensiva atravez de um teste
		if (!posicaoExistente(posicao)) {

			// se essa posicao nao existir será lancado uma nova exceção
			throw new ExcecaoTabuleiro("Essa posição nao existe!!!");
		}
		//retorno com teste se possui peca na posicao da matriz dessa posicao
		return peca(posicao) != null;
	}

}
