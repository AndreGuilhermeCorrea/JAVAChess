package xadrez.pecas;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

//regra da rainha são movimentos conforme torre e bispo
public class Rainha extends PecaXadrez {

	// construtor para repassar a chamada para superclasse
	public Rainha(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);

	}

	// toString da classe
	// coversao da torre para string
	@Override
	public String toString() {
		return "Q";// essa letra entrará na impressao do tabuleiro, ou seja no local da peça
					// aparecerá a letra
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		// matriz de boolean na mesma dimensão do tabuleiro
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		// posicao auxiliar p
		Posicao p = new Posicao(0, 0);

		// ACIMA
		// verificar possiveis movimentos acima enquanto for válida com decremento
		p.setValores(posicao.getLinha() - 1, posicao.getColuna());
		// teste enquanto uma posicao existir e nao tiver uma peca presente será marcada
		// a posicao como verdadeira
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;
			// sendo verdadeiro o teste sera verificado linha -1 enquanto existir posicoes
			// vazias
			p.setLinha(p.getLinha() - 1);
		}
		// teste para verificar se a peca na posicao é adversaria e marca-la como
		// verdadeira
		if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;

		}

		// ESQUERDA
		// verificar possiveis movimentos a esquerda enquanto for válida com decremento
		p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
		// teste enquanto uma posicao existir e nao tiver uma peca presente será marcada
		// a posicao como verdadeira
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;
			// sendo verdadeiro o teste sera verificado coluna -1 enquanto existir posicoes
			// vazias
			p.setColuna(p.getColuna() - 1);
		}
		// teste para verificar se a peca na posicao é adversaria e marca-la como
		// verdadeira
		if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;

		}

		// DIREITA
		// verificar possiveis movimentos a direita enquanto for válida com incremento
		p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
		// teste enquanto uma posicao existir e nao tiver uma peca presente será marcada
		// a posicao como verdadeira
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;
			// sendo verdadeiro o teste sera verificado coluna +1 enquanto existir posicoes
			// vazias
			p.setColuna(p.getColuna() + 1);
		}
		// teste para verificar se a peca na posicao é adversaria e marca-la como
		// verdadeira
		if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;

		}
		// ABAIXO
		// verificar possiveis movimentos abaixo enquanto for válida com incremento
		p.setValores(posicao.getLinha() + 1, posicao.getColuna());
		// teste enquanto uma posicao existir e nao tiver uma peca presente será marcada
		// a posicao como verdadeira
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;
			// sendo verdadeiro o teste sera verificado linha +1 enquanto existir posicoes
			// vazias
			p.setLinha(p.getLinha() + 1);
		}
		// teste para verificar se a peca na posicao é adversaria e marca-la como
		// verdadeira
		if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;

		}

		// NOROESTE
		// verificar possiveis movimentos acima enquanto for válida com decremento
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		// teste enquanto uma posicao existir e nao tiver uma peca presente será marcada
		// a posicao como verdadeira
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;
			// sendo verdadeiro o teste sera verificado linha -1 enquanto existir posicoes
			// vazias
			p.setValores(p.getLinha() - 1, p.getColuna() - 1);
		}
		// teste para verificar se a peca na posicao é adversaria e marca-la como
		// verdadeira
		if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;

		}

		// NORDESTE
		// verificar possiveis movimentos a esquerda enquanto for válida com decremento
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		// teste enquanto uma posicao existir e nao tiver uma peca presente será marcada
		// a posicao como verdadeira
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;
			// sendo verdadeiro o teste sera verificado coluna -1 enquanto existir posicoes
			// vazias
			p.setValores(p.getLinha() - 1, p.getColuna() + 1);
		}
		// teste para verificar se a peca na posicao é adversaria e marca-la como
		// verdadeira
		if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;

		}

		// SULDESTE
		// verificar possiveis movimentos a direita enquanto for válida com incremento
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		// teste enquanto uma posicao existir e nao tiver uma peca presente será marcada
		// a posicao como verdadeira
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;
			// sendo verdadeiro o teste sera verificado coluna +1 enquanto existir posicoes
			// vazias
			p.setValores(p.getLinha() + 1, p.getColuna() + 1);
		}
		// teste para verificar se a peca na posicao é adversaria e marca-la como
		// verdadeira
		if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;

		}
		// SULDOESTE
		// verificar possiveis movimentos abaixo enquanto for válida com incremento
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		// teste enquanto uma posicao existir e nao tiver uma peca presente será marcada
		// a posicao como verdadeira
		while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;
			// sendo verdadeiro o teste sera verificado linha +1 enquanto existir posicoes
			// vazias
			p.setValores(p.getLinha() + 1, p.getColuna() - 1);
		}
		// teste para verificar se a peca na posicao é adversaria e marca-la como
		// verdadeira
		if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
			// acessar e marcar como verdadeira a posicao da matriz mat na linha x e coluna
			// y
			mat[p.getLinha()][p.getColuna()] = true;

		}

		return mat;
	}
}
