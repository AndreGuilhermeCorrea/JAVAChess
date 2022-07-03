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
			// se o teste acima ser verdadeiro ser� lancado uma exce��o (throw)
			throw new ExcecaoTabuleiro("Erro na criacao do tabuleiro!!!");

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

	// m�todo para retornar uma peca em uma dada linha e coluna
	public Peca peca(int linha, int coluna) {

		// programa��o defensiva atravez de um teste
		if (!posicaoExistente(linha, coluna)) {

			// se essa posicao nao existir ser� lancado uma nova exce��o
			throw new ExcecaoTabuleiro("Essa posicao nao existe!!!");
		}

		// m�todo retorna matriz pecas na linha e coluna
		return pecas[linha][coluna];
	}

	// sobrecarga do metodo peca recebendo a posicao da posicao
	public Peca peca(Posicao posicao) {

		// programa��o defensiva atravez de um teste
		if (!posicaoExistente(posicao)) {

			// se essa posicao nao existir ser� lancado uma nova exce��o
			throw new ExcecaoTabuleiro("Essa posicao nao existe!!!");
		}

		// m�toro retornara a peca pela posicao
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	// m�todo para colocar peca na posicao
	public void localPeca(Peca peca, Posicao posicao) {
		// teste para saber se tem outra pe�a na posicao
		if (pecaNaPosicao(posicao)) {

			// ser� portanto lan�ado uma exce��o
			throw new ExcecaoTabuleiro("Ja existe uma peca nessa posicao!!! " + posicao);

		}
		// na matriz de peca do tabuleiro instanciada no construtor
		// atribuir na matriz de pecas a peca que veio como argumento
		// matriz na posicao dada atribuir a ela a peca
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;

		// ou seja ela passa a para a seguinte posi��o informada no m�todo
		// a posicao da peca � acessivel diretamente pois esta como protect, por estar
		// no mesmo pacote torna-se possivel acessar livremente a posicao da peca
		peca.posicao = posicao;
	}
	
	
	
	//m�todo puclic retornando uma pe�a chamado removePeca que recebe a posicao como argumento
	public Peca removePeca(Posicao posicao) {
		//programa��o defensiva com teste
		 // se essa posicao nao existir ser� lancado uma nova exce��o por meio de um teste if
		if (!posicaoExistente(posicao))
		throw new ExcecaoTabuleiro("Essa posicao nao existe!!!");
		//teste para saber se a peca na posicao � igual a nulo
		//ou seja se for verdade nao existe peca albuma na posicao
		if (peca(posicao) == null) {
			//retornando simplesmente o valor nulo
			return null; 
		}
		//caso isso nao ocorra simplesmente sera retirado a peca do tabuleiro por meio de um procedimento
		//declaracao de vari�vel aux de peca recebendo a peca que estiver no tabuleiro nessa posicao onde a variavel aux aponta pra ela
		Peca aux = peca(posicao);
		//essa peca aux agora passa a ser nula, ou seja retirada do tabuleiro, nao possui mais posicao
		aux.posicao = null;
		//agora sera acessada a matriz de pecas na linha e na coluna recebera nulo
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		//o metodo portanto retorna a vari�vel aux que contem a peca retirada
		return aux;
		
	}
	

	// m�todo auxiliar posicaoExistente receber uma linha e uma coluna
	// tornando portanto realizar o teste pela linha e coluna ao inv�s da posi�ao
	private boolean posicaoExistente(int linha, int coluna) {
		// posicao s� existe se estiver dentro do tabuleiro atravez da condi��o
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	// implementando a fun�ao se a posi��o existe atrav�s do boolean e recebendo uma
	// posicao como argumento
	public boolean posicaoExistente(Posicao posicao) {
		// com base na implementa�ao acima(reaproveitamento), esse m�todo testar� se a
		// posicao � existente
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}

	public boolean pecaNaPosicao(Posicao posicao) {
		
		// programa��o defensiva atravez de um teste
		if (!posicaoExistente(posicao)) {

			// se essa posicao nao existir ser� lancado uma nova exce��o
			throw new ExcecaoTabuleiro("Essa posicao nao existe!!!");
		}
		//retorno com teste se possui peca na posicao da matriz dessa posicao
		return peca(posicao) != null;
	}

}
