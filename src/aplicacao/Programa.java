package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		PartidaXadrez partidaXadrez = new PartidaXadrez(); 
		
		while (true) {
			
			//bloco para tratamento de exceçoes 
			try {
				//chamada do método para limpar terminal
				UI.limpaTerminal();
				UI.imprimirTabuleiro(partidaXadrez.getPecas());
				System.out.println();
				System.out.print("Origem ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
				PecaXadrez capturaPeca = partidaXadrez.executarMovimentoXadrez(origem, destino);

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
		
	}

}
