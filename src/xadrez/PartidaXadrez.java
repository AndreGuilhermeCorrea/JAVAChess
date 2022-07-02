package xadrez;

import tabuleiroJogo.Peca;
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
	
	
	//m�todo para executar o movimento do xadrez com posi��o de origem, posicao de destino retornando entao uma posicao capturada
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		//conversao das 02 posicoes para posicao da matriz
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		//validacao da posicao de origem, caso nao exista ser� lancado uma excess�o atravez da implementacao da opera�ao no metodo abaixo
		validacaoPosicaoOrigem(origem);
		//caso nao ocorra exce��o a variavel declarada com o nome capturaPeca receber� o resultado da operacao fazermover responsavel por realizar o movimento da peca
		Peca capturaPeca = fazerMover(origem, destino);
		//retorno da peca capturada por meio de um downCasting para pecaXadrez pois essa peca capturada era do tipo peca
		return (PecaXadrez)capturaPeca;
		
	}
	
	//implementa��o da operacao fazerMover 
	private Peca fazerMover(Posicao origem, Posicao destino) {
		//sa�da da peca na posicao de origem
		Peca p = tabuleiro.removePeca(origem); 
		//remover possivel peca que estiver na posicao de destino passando portanto a ser a peca capturada
		Peca capturaPeca = tabuleiro.removePeca(destino);
		//entrada da peca de origem para peca de destino
		tabuleiro.localPeca(p, destino);
		//programa entao retorna a peca capturada
		return capturaPeca;
	}
	
	
	//implementa��o da operacao validacaoPosicaoOrigem recebendo uma posicao
	private void validacaoPosicaoOrigem(Posicao posicao) {
		//teste negado, ou seja se nao existir peca na posicao sera lancado a exce��o
		if (!tabuleiro.pecaNaPosicao(posicao)) {
			throw new ExcecaoXadrez("Existe uma peca na posicao de origem!!!");
		}
		
	}
	
	
	//instancia�ao da opera��o paraPosicao informando as coordenadas do sistema do xadrez e nao o sistema da matriz
	//esse m�todo � uma opera��o de colocar pecas passando as posicoes nas coordenadas do xadrez
	private void novaPosicaoPeca(char coluna, int linha, PecaXadrez peca) {
		//m�todo chamara o tabuleiro passando a peca por uma instanciacao da posicao do xadrez pelos dados para uma posicao de matriz
		tabuleiro.localPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
		
	}
	
	//m�todo iniciar da partida de xadrez
	//respons�vel por iniciar a partida colocando as pe�as no tabuleiro
	private void iniciarPartida() {
		//colocar uma peca y da cor z na posicao x 
	
		
		novaPosicaoPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		novaPosicaoPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		novaPosicaoPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		novaPosicaoPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		novaPosicaoPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		novaPosicaoPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		novaPosicaoPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
	

	
}
