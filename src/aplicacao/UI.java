package aplicacao;

import xadrez.PecaXadrez;

public class UI {

	// cria��o do m�todo Imprimir tabuleiro

	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
		// l�gica para imprimir o tabuleiro no formato
		/*
		 * 8 - - - - - - - - 7 - - - - - - - - 6 - - - - - - - - 5 - - - - - - - - 4 - -
		 * - - - - - - 3 - - - - - - - - 2 - - - - - - - - 1 - - - - - - - - a b c d e f
		 * g h
		 */

		// .length considerando uma matriz quadrada
		for (int i = 0; i < pecas.length; i++) {
			// .length considerando uma matriz quadrada
			System.out.print((8 - i) + " ");

			for (int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j]);
			}
			// quebra de linha
			System.out.println();
		}
		// impressao das letras
		System.out.println("  a b c d e f g h");

	}

	// m�todo auxiliar para imprimir uma unica peca

	private static void imprimirPeca(PecaXadrez peca) {
		// condi��o para testar se essqa pe�a for igual a nulo significa que nao tinha
		// peca nessa posi��o do tabuleiro

		if (peca == null) {
			// imprimindo portanto na tela o (-)
			System.out.print("-");
			// caso contrario ser� impresso a peca
		} else {
			System.out.print(peca);
		}
		// impressao do espa�o em branco para q as pecas nao fiquem grudadas
		System.out.print(" ");

	}
}
