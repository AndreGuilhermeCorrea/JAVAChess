package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

//ESSA CLASSE � O CORA��O DO SISTEMA
//POIS � NELA QUE ESTAR�O AS REGRAS DO JOGO

public class PartidaXadrez {

	// no momento de criar a partida cria-se um tabuleiro 8x8 e chama iniciar
	// partida

	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	// propriedade boolean que diz se a partida esta em posicao de xeque ou nao
	private boolean xeque;
	//propriedade xeque mate!
	private boolean xequeMate;
	// declaracao das listas de pecas no tabuleiro e capturadas
	// chamada de pecas capturadas por meio de 2 listas quais estao no tabuleiro e
	// quais sao as pecas capturadas
	// ps a lista poderia ser instanciada no construtor mas deixando na declaracao
	// garante que vai ser iniciada na criacao da partida de xadrez(indiferente)
	private List<Peca> pecasTabuleiro = new ArrayList<>();
	// declaracao da lista de pecas capturadas
	private List<Peca> pecasCapturadas = new ArrayList<>();

	// Construtor
	// m�todo para atribuir o tamanho do tabuleiro
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		// iniciar a partida no construtor
		iniciarPartida();
	}

	// m�todos gethers turno e jogadorAtual
	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}

	// gether xeque
	public boolean getXeque() {
		return xeque;
	}
	
	//get xequeMate
	public boolean getXequeMate() {
		return xequeMate;
	}

	// m�todo para retornar uma matriz de pecas de xadrez nessa partida
	// para que o programa conheca apenas a camada de xadrez e nao a camada de
	// tabuleiro
	public PecaXadrez[][] getPecas() {
		// matriz
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		// percorrer a matriz de pecas do tabuleiro e para cada peca do tabuleiro ser�
		// feito um DOWNCASTING para peca de xadrez
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);

			}
		}
		// terminado o for retornar� a matriz (mat) de pecas de xadrez
		return mat;
	}

	// opera��o de movimentos possiveis dada uma posicao e poder imprimir as
	// posi�oes possiveis apartir da posicao de origem
	// retornando uma matriz de boolean contendo as posi�oes possiveis para que a
	// aplica��o possa colorir o fundo de cada posicao
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem) {
		// conversao dessa posicao de xadrez para uma posicao de matriz
		Posicao posicao = posicaoOrigem.paraPosicao();
		// valida��o da posicao de origem
		validacaoPosicaoOrigem(posicao);
		// retornar os movimentos possiveis da peca nessa posicao
		return tabuleiro.peca(posicao).movimentosPossiveis();

	}

	// m�todo para executar o movimento do xadrez com posi��o de origem, posicao de
	// destino retornando entao uma posicao capturada
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		// conversao das 02 posicoes para posicao da matriz
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();

		// validacao da posicao de origem, caso nao exista ser� lancado uma excess�o
		// atravez da implementacao da opera�ao no metodo abaixo
		validacaoPosicaoOrigem(origem);

		// validacao da posicao de destino, caso nao exista ser� lancado uma excess�o
		// atravez da implementacao da opera�ao no metodo abaixo
		validacaoPosicaoDestino(origem, destino);

		// caso nao ocorra exce��o a variavel declarada com o nome capturaPeca receber�
		// o resultado da operacao fazermover responsavel por realizar o movimento da
		// peca
		Peca pecaCapturada = fazerMover(origem, destino);

		// teste para saber se o movimento colocou o proprio joador em xeque
		if (testeXeque(jogadorAtual)) {
			desfazerMovimento(origem, destino, pecaCapturada);
			throw new ExcecaoXadrez("Voce nao pode se colocar em xeque!!!");
		}

		xeque = (testeXeque(oponente(jogadorAtual))) ? true : false;
		// teste se o jogo acabou por xequemate antes de passar o turno
		if (testeXequeMate(oponente(jogadorAtual))) {
			xequeMate = true;
		}
		// caso contrario a partida segue
		else {
			// chamada do m�todo trocar turno apos a partida
			proximoTurno();

		}
		// retorno da peca capturada por meio de um downCasting para pecaXadrez pois
		// essa peca capturada era do tipo peca
		return (PecaXadrez) pecaCapturada;

	}

	// implementa��o da operacao fazerMover (fazer movimento)
	private Peca fazerMover(Posicao origem, Posicao destino) {
		// sa�da da peca na posicao de origem
		Peca p = tabuleiro.removePeca(origem);
		// remover possivel peca que estiver na posicao de destino passando portanto a
		// ser a peca capturada
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		// entrada da peca de origem para peca de destino
		tabuleiro.localPeca(p, destino);
		// teste para saber se a peca � diferente de nulo e

		if (pecaCapturada != null) {
			pecasTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		// programa entao retorna a peca capturada
		return pecaCapturada;
	}

	// implementa��o da operacao desfazerMover (desfazer movimento)
	private void desfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
		// saida da pe�a do destino
		Peca p = tabuleiro.removePeca(destino);
		// retorno da peca na posicao de origem
		tabuleiro.localPeca(p, origem);

		// se a peca for capturada essa devera retornar para posicao de destino
		if (pecaCapturada != null) {
			tabuleiro.localPeca(pecaCapturada, destino);
			// tirar a peca da lista de pecas capturadas e devolver ao tabuleiro
			pecasCapturadas.remove(pecaCapturada);
			pecasTabuleiro.add(pecaCapturada);
		}

	}

	// implementa��o da operacao validacaoPosicaoOrigem recebendo uma posicao
	// esse m�todo portanto possui 2 verifica��es
	private void validacaoPosicaoOrigem(Posicao posicao) {
		// teste negado, ou seja se nao existir peca na posicao sera lancado a exce��o
		if (!tabuleiro.pecaNaPosicao(posicao)) {
			throw new ExcecaoXadrez("Ja existe uma peca na posicao de origem!!!");
		}
		// teste para saber se jogador esta movendo peca do advers�rio
		if (jogadorAtual != ((PecaXadrez) tabuleiro.peca(posicao)).getCor())
			// excecao em caso teste seja verdadeiro
			throw new ExcecaoXadrez("A pe�a escolhida nao te pertence!");

		// validar posicao de origem de uma peca, pois quando fizer o movimento dessa a
		// origem dever� ser validada
		// teste para saber se existe movimentos possiveis para a peca caso nao exista
		// essa pe�a nao podera ser utilizada como origem
		// se nao existir movimento possivel ser� lancada uma exce��o
		if (!tabuleiro.peca(posicao).umPossivelMovimento()) {
			// exce��o
			throw new ExcecaoXadrez("Nao existe movimentos possiveis para a peca escolhida!!!");

		}

	}

	private void validacaoPosicaoDestino(Posicao origem, Posicao destino) {
		// teste para valida��o atraves da posicao de destino (se � movimento poss�vel)
		// em rela��o a peca origem
		if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			// tratamento da exce��o
			throw new ExcecaoXadrez("A peca escolhida nao pode ser movida para a posicao de destino!!!");
		}

	}

	// M�todos para proximo Turno(partida)
	// esse m�todo ser� chamado apenas apos ser executada uma jogada
	private void proximoTurno() {
		// incremento do turno
		turno++;
		// express�o condicional tern�ria para determinar o jogador branco
		// se o jogador atual for igual(==) a cor branca entao (?) ser� cor preto caso
		// contr�rio ( : ) sera branco
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	// m�todo para devolver o oponente de uma cor
	private Cor oponente(Cor cor) {
		// metodo com teste para retornar preto se cor for branca e branca se a cor for
		// preto
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	// m�todo localiza rei de determinada cor
	private PecaXadrez rei(Cor cor) {
		// varredura para filtrar lista de pecas em jogo qual � o rei de determinada cor
		List<Peca> list = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == cor)
				.collect(Collectors.toList());

		for (Peca p : list) {
			if (p instanceof Rei) {
				return (PecaXadrez) p;

			}
		}
		// excecao que (nao deve ocorrer) caso a varredura nao encontre rei
		throw new IllegalStateException("Nao existe rei da cor " + cor + " no tabuleiro! ");
	}

	// para testar se o rei de determinada cor esta em xeque devera fazer varredura
	// nas pecas adversarias e analisar se existe um movimento sequer possivel que
	// venha a cair na casa do rei
	// caso ocorra o rei esta em xeque
	private boolean testeXeque(Cor cor) {
		// posicao do rei
		Posicao posicaoRei = rei(cor).getPosicaoXadrez().paraPosicao();
		List<Peca> pecasOponente = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == oponente(cor))
				.collect(Collectors.toList());
		// teste
		for (Peca p : pecasOponente) {
			boolean[][] mat = p.movimentosPossiveis();
			if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}
	
	//m�todo para determinar xequeMate
	private boolean testeXequeMate(Cor cor) {
		if (!testeXeque(cor)) {
			return false;
		}
		List<Peca> list = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == cor)
				.collect(Collectors.toList());
		for (Peca p : list) {
			boolean[][] mat = p.movimentosPossiveis();
			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getColunas(); j++) {
					if (mat[i][j]) {
						Posicao origem = ((PecaXadrez) p).getPosicaoXadrez().paraPosicao();
						Posicao destino = new Posicao(i, j);
						Peca pecaCapturada = fazerMover(origem, destino);
						// teste para saber se o rei da minha cor esta ainda em xeque
						boolean testeXeque = testeXeque(cor);
						// desfaz o movimento
						desfazerMovimento(origem, destino, pecaCapturada);
						// teste se nao estava em xeque
						if (!testeXeque) {
							return false;
						}

					}
				}
			}

		}
		return true;
	}

	// instancia�ao da opera��o paraPosicao informando as coordenadas do sistema do
	// xadrez e nao o sistema da matriz
	// esse m�todo � uma opera��o de colocar pecas passando as posicoes nas
	// coordenadas do xadrez
	private void novaPosicaoPeca(char coluna, int linha, PecaXadrez peca) {
		// (coloca pecas no tabuleiro), m�todo chamara o tabuleiro passando a peca por
		// uma instanciacao da posicao do xadrez pelos dados para uma posicao de matriz
		tabuleiro.localPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
		// (coloca pecas na lista de pecas no tabuleiro)
		pecasTabuleiro.add(peca);
	}

	// m�todo iniciar da partida de xadrez
	// respons�vel por iniciar a partida colocando as pe�as no tabuleiro
	private void iniciarPartida() {
		// colocar uma peca y da cor z na posicao x
		
		//torre branca
		novaPosicaoPeca('h', 7, new Torre(tabuleiro, Cor.BRANCO));
		novaPosicaoPeca('d', 1, new Torre(tabuleiro, Cor.BRANCO));
		//rei branco
		novaPosicaoPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
		
		//torre preto
		novaPosicaoPeca('b', 8, new Torre(tabuleiro, Cor.PRETO));
		//rei preto
		novaPosicaoPeca('a', 8, new Rei(tabuleiro, Cor.PRETO));
	}

}
