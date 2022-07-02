package aplicacao;

import xadrez.Cor;
import xadrez.PecaXadrez;

public class UI {

	// c�digo java para impress�o colorida no terminal com algoritmo

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESETAR = "\u001B[0m";
	public static final String ANSI_PRETO = "\u001B[30m";
	public static final String ANSI_VERMELHO = "\u001B[31m";
	public static final String ANSI_VERDE = "\u001B[32m";
	public static final String ANSI_AMARELO = "\u001B[33m";
	public static final String ANSI_AZUL = "\u001B[34m";
	public static final String ANSI_ROSA = "\u001B[35m";
	public static final String ANSI_AZULCLARO = "\u001B[36m";
	public static final String ANSI_BRANCO = "\u001B[37m";

	public static final String ANSI_PRETO_FUNDO = "\u001B[40m";
	public static final String ANSI_VERMELHO_FUNDO = "\u001B[41m";
	public static final String ANSI_VERDE_FUNDO = "\u001B[42m";
	public static final String ANSI_AMARELO_FUNDO = "\u001B[43m";
	public static final String ANSI_AZUL_FUNDO = "\u001B[44m";
	public static final String ANSI_ROSA_FUNDO = "\u001B[45m";
	public static final String ANSI_AZULCLARO_FUNDO = "\u001B[46m";
	public static final String ANSI_BRANCO_FUNDO = "\u001B[47m";

	// cria��o do m�todo Imprimir tabuleiro

	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
		// l�gica para imprimir o tabuleiro no formato
		/*
		 * 8 - - - - - - - - 
		 * 7 - - - - - - - - 
		 * 6 - - - - - - - - 
		 * 5 - - - - - - - - 
		 * 4 - - - - - - - - 
		 * 3 - - - - - - - - 
		 * 2 - - - - - - - - 
		 * 1 - - - - - - - - 
		 * a b c d e f g h
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
			if (peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_BRANCO + peca + ANSI_RESETAR);
			} else {
				System.out.print(ANSI_AMARELO + peca + ANSI_RESETAR);
			}
		}
		// impressao do espa�o em branco para q as pecas nao fiquem grudadas
		System.out.print(" ");
	}
}
