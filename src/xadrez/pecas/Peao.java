package xadrez.pecas;

import tabuleiroJogo.Posicao;
import tabuleiroJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
	
	//dependencia para partida
	private PartidaXadrez partidaXadrez;
	
	public Peao(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partidaXadrez) {
		super(tabuleiro, cor);
		this.partidaXadrez = partidaXadrez;
	}

	@Override
	public boolean[][] movimentosPossiveis() {


	
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		

		// posicao auxiliar p
		Posicao p = new Posicao(0, 0);
		
		
		// lógica para movimentos possiveis de um peao
		// regra basica o peao
		// so pode se movimentar uma casa por vez, salvo quanto for seu primeiro
		// movimento
		// tambem em diagonal uma casa quando existir peça adversaria
		if (getCor() == Cor.BRANCO) {
			//acima
			p.setValores(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			//2 casas acima
			p.setValores(posicao.getLinha() - 2, posicao.getColuna());
			//teste para saber se a casa esta livre 
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p) && getTabuleiro().posicaoExistente(p2) && !getTabuleiro().pecaNaPosicao(p2) && getContarMovimentos() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}			
			//casas na diagonal caso tenha peça do adversario
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			//casas na diagonal caso tenha peça do adversario
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			//tratamento para passant brancas
			if (posicao.getLinha() == 3) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() -1);
				if (getTabuleiro().posicaoExistente(esquerda)//teste se posicao existe
						&& existePecaOponente(esquerda) //se tem peca oponente
						&& getTabuleiro().peca(esquerda) == partidaXadrez.getPassantVulneravel()) {//e se essa peca esta vulneravel ao passant
					//possivel posicao para peao no passant	
					mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
				}
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() +1);
				if (getTabuleiro().posicaoExistente(direita)//teste se posicao existe
						&& existePecaOponente(direita) //se tem peca oponente
						&& getTabuleiro().peca(direita) == partidaXadrez.getPassantVulneravel()) {//e se essa peca esta vulneravel ao passant
					//possivel posicao para peao no passant	
					mat[direita.getLinha() - 1][direita.getColuna()] = true;
				}
			}
			
		}
		else {
			//movimentos do paeo com peças pretas
			//acima
			p.setValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			//2 casas acima
			p.setValores(posicao.getLinha() + 2, posicao.getColuna());
			//teste para saber se a casa esta livre 
			Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().pecaNaPosicao(p) && getTabuleiro().posicaoExistente(p2) && !getTabuleiro().pecaNaPosicao(p2) && getContarMovimentos() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}			
			//casas na diagonal caso tenha peça do adversario
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			//casas na diagonal caso tenha peça do adversario
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExistente(p) && existePecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}	
			//tratamento para passant pretas
			if (posicao.getLinha() == 4) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() -1);
				if (getTabuleiro().posicaoExistente(esquerda)//teste se posicao existe
						&& existePecaOponente(esquerda) //se tem peca oponente
						&& getTabuleiro().peca(esquerda) == partidaXadrez.getPassantVulneravel()) {//e se essa peca esta vulneravel ao passant
					//possivel posicao para peao no passant	
					mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
				}
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() +1);
				if (getTabuleiro().posicaoExistente(direita)//teste se posicao existe
						&& existePecaOponente(direita) //se tem peca oponente
						&& getTabuleiro().peca(direita) == partidaXadrez.getPassantVulneravel()) {//e se essa peca esta vulneravel ao passant
					//possivel posicao para peao no passant	
					mat[direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}
		}
		
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
	
	
	
}

