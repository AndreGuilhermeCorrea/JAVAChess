package aplicacao;

import xadrez.PecaXadrez;

public class UI {

	// criação do método Imprimir tabuleiro

	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
		// lógica para imprimir o tabuleiro no formato
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

	// método auxiliar para imprimir uma unica peca

	private static void imprimirPeca(PecaXadrez peca) {
		// condição para testar se essqa peça for igual a nulo significa que nao tinha
		// peca nessa posição do tabuleiro

		if (peca == null) {
			// imprimindo portanto na tela o (-)
			System.out.print("-");
			// caso contrario será impresso a peca
		} else {
			System.out.print(peca);
		}
		// impressao do espaço em branco para q as pecas nao fiquem grudadas
		System.out.print(" ");

	}
}
