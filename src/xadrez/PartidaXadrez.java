package xadrez;

import java.util.ArrayList;
import java.util.List;

import tabuleiroJogo.Peca;
import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

//ESSA CLASSE É O CORAÇÃO DO SISTEMA
//POIS É NELA QUE ESTARÃO AS REGRAS DO JOGO

public class PartidaXadrez {
	
	// no momento de criar a partida cria-se um tabuleiro 8x8 e chama iniciar partida
	
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	//declaracao das listas de pecas no tabuleiro e capturadas
	//chamada de pecas capturadas por meio de 2 listas quais estao no tabuleiro e quais sao as pecas capturadas
	//ps a lista poderia ser instanciada no construtor mas deixando na declaracao garante que vai ser iniciada na criacao da partida de xadrez(indiferente)
	private List<Peca> pecasTabuleiro = new ArrayList<>();
	//declaracao da lista de pecas capturadas
	private List<Peca> pecasCapturadas = new ArrayList<>();
	
	//Construtor
	//método para atribuir o tamanho do tabuleiro
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		//iniciar a partida no construtor
		iniciarPartida();
	}
	

	//métodos gethers turno e jogadorAtual
	public int getTurno() {
		return turno;
	}


	public Cor getJogadorAtual() {
		return jogadorAtual;
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
	


	//operação de movimentos possiveis dada uma posicao e poder imprimir as posiçoes possiveis apartir da posicao de origem
	//retornando uma matriz de boolean contendo as posiçoes possiveis para que a aplicação possa colorir o fundo de cada posicao
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem){
		//conversao dessa posicao de xadrez para uma posicao de matriz
		Posicao posicao = posicaoOrigem.paraPosicao();
		//validação da posicao de origem
		validacaoPosicaoOrigem(posicao);
		//retornar os movimentos possiveis da peca nessa posicao
		return tabuleiro.peca(posicao).movimentosPossiveis();
		
	}
	
	//método para executar o movimento do xadrez com posição de origem, posicao de destino retornando entao uma posicao capturada
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		//conversao das 02 posicoes para posicao da matriz
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		
		//validacao da posicao de origem, caso nao exista será lancado uma excessão atravez da implementacao da operaçao no metodo abaixo
		validacaoPosicaoOrigem(origem);
		
		//validacao da posicao de destino, caso nao exista será lancado uma excessão atravez da implementacao da operaçao no metodo abaixo
		validacaoPosicaoDestino(origem, destino);
		
		//caso nao ocorra exceção a variavel declarada com o nome capturaPeca receberá o resultado da operacao fazermover responsavel por realizar o movimento da peca
		Peca capturaPeca = fazerMover(origem, destino);
		//chamada do método trocar turno apos a partida
		proximoTurno();
		//retorno da peca capturada por meio de um downCasting para pecaXadrez pois essa peca capturada era do tipo peca
		return (PecaXadrez)capturaPeca;
		
	}
	
	//implementação da operacao fazerMover 
	private Peca fazerMover(Posicao origem, Posicao destino) {
		//saída da peca na posicao de origem
		Peca p = tabuleiro.removePeca(origem); 
		//remover possivel peca que estiver na posicao de destino passando portanto a ser a peca capturada
		Peca capturaPeca = tabuleiro.removePeca(destino);
		//entrada da peca de origem para peca de destino
		tabuleiro.localPeca(p, destino);
		//teste para saber se a peca é diferente de nulo e 
		//remover peca da lista de pecas no tabuleiro 
		pecasCapturadas.add(capturaPeca);
		
		//programa entao retorna a peca capturada
		return capturaPeca;
	}
	
	
	//implementação da operacao validacaoPosicaoOrigem recebendo uma posicao
	//esse método portanto possui 2 verificações 
	private void validacaoPosicaoOrigem(Posicao posicao) {
		//teste negado, ou seja se nao existir peca na posicao sera lancado a exceção
		if (!tabuleiro.pecaNaPosicao(posicao)) {
			throw new ExcecaoXadrez("Ja existe uma peca na posicao de origem!!!");
		}
		//teste para saber se jogador esta movendo peca do adversário
		if (jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor())
			//excecao em caso teste seja verdadeiro
			throw new ExcecaoXadrez("A peça escolhida nao te pertence!");
			
		//validar posicao de origem de uma peca, pois quando fizer o movimento dessa a origem deverá ser validada 
		//teste para saber se existe movimentos possiveis para a peca caso nao exista essa peça nao podera ser utilizada como origem
		//se nao existir movimento possivel será lancada uma exceção
		if (!tabuleiro.peca(posicao).umPossivelMovimento()) {
			//exceção
			throw new ExcecaoXadrez("Nao existe movimentos possiveis para a peca escolhida!!!");
		
		}
		
	}
	private void validacaoPosicaoDestino(Posicao origem, Posicao destino) {
		//teste para validação atraves da posicao de destino (se é movimento possível) em relação a peca origem
		if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			//tratamento da exceção
			throw new ExcecaoXadrez("A peca escolhida nao pode ser movida para a posicao de destino!!!");
		}
		
	}
	
	

	
	
	//Métodos para proximo Turno(partida)
	//esse método será chamado apenas apos ser executada uma jogada
	private void proximoTurno() {
		//incremento do turno
		turno++;
		//expressão condicional ternária para determinar o jogador branco
		//se o jogador atual for igual(==) a cor branca entao (?) será cor preto caso contrário ( : ) sera branco
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	
	
	//instanciaçao da operação paraPosicao informando as coordenadas do sistema do xadrez e nao o sistema da matriz
	//esse método é uma operação de colocar pecas passando as posicoes nas coordenadas do xadrez
	private void novaPosicaoPeca(char coluna, int linha, PecaXadrez peca) {
		//(coloca pecas no tabuleiro), método chamara o tabuleiro passando a peca por uma instanciacao da posicao do xadrez pelos dados para uma posicao de matriz
		tabuleiro.localPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
		//(coloca pecas na lista de pecas no tabuleiro)
		pecasTabuleiro.add(peca);
	}
	
	
	

	
	//método iniciar da partida de xadrez
	//responsável por iniciar a partida colocando as peças no tabuleiro
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
