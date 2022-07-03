package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		PartidaXadrez partidaXadrez = new PartidaXadrez(); 
		//declaracao da lista de pecas
		List<PecaXadrez> pecaCapturada = new ArrayList<>();
		
		while (!partidaXadrez.getXequeMate()) {
			
			//bloco para tratamento de exceçoes 
			try {
				//chamada do método para limpar terminal
				UI.limpaTerminal();
				UI.imprimirPartida(partidaXadrez, pecaCapturada);
				System.out.println();
				System.out.print("Origem ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
				UI.limpaTerminal();
				UI.imprimirTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);
								
				System.out.println();
				System.out.print("Destino ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
				
				//sempre que o movimento for executado essa peça será adicionado a lista de pecas capturadas por meio da condição abaixo
				PecaXadrez capturaPeca = partidaXadrez.executarMovimentoXadrez(origem, destino);
				
				if (capturaPeca != null) {
					pecaCapturada.add(capturaPeca);

				}
				

			}
			//tratamento da excecao no xadrez
			catch (ExcecaoXadrez e) {
				//caso ocorra excecao imprime na tela a mensagem
				System.out.println(e.getMessage());
				//sc para programa aguardar apertar o enter
				sc.nextLine();
				
			}
			
			//tratamento da excecao no xadrez
			catch (InputMismatchException e) {
				//caso ocorra excecao imprime na tela a mensagem
				System.out.println(e.getMessage());
				//sc para programa aguardar apertar o enter
				sc.nextLine();
				
			}
		}
		UI.limpaTerminal();
		UI.imprimirPartida(partidaXadrez, pecaCapturada);
		
	}

}
