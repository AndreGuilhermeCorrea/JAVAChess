package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Cor;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class UI {

	// código java para impressão colorida no terminal com algoritmo
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
	
	//método para limpar terminal ao realizar jogada
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	
	public static void limpaTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	//método para ler a posicao do usuario atravéz do scanner do programa principal
	//scanner instanciado no programa principal passando como argumento nesse método
		public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) {
			//a operação do método é inserido em um bloco try para que se ocorra algum runtime que vier a ocorrer é lancado uma exceção (throw new InputMismatchException)
		try {
			//leitura da posicao pelo mesmo scanner
			String s = sc.nextLine();
			//variavel coluna tipo char recebendo char at0 pois a coluna de caractere é o 1º caractere do string 
			char coluna = s.charAt(0);
			//leitura da linha pela variavel linha tipo int recebendo a posicao 1 da string
			//ou seja é feito um recorte da string na posicao 1 (s.substring(1)) e fazendo a conversao do resultado para inteiro(Integer.parseInt)
			int linha = Integer.parseInt(s.substring(1));
			//o metodo portanto retorna uma nova posicao de xadrez com essa coluna e essa linha
			return new PosicaoXadrez(coluna, linha);
		
		}
		//
		catch (RuntimeException e) {
			//exceção instanciada com a frase e lançada caso ocorra erros na entrada de dados
			throw new InputMismatchException("Erro na leitura da posição do xadrez!!!");
			
		}
		
	}

	
	// criação do método Imprimir tabuleiro
	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
		// lógica para imprimir o tabuleiro no formato
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

	
	// método auxiliar para imprimir uma unica peca
	private static void imprimirPeca(PecaXadrez peca) {
		// condição para testar se essqa peça for igual a nulo significa que nao tinha
		// peca nessa posição do tabuleiro

		if (peca == null) {
			// imprimindo portanto na tela o (-)
			System.out.print("-");
			// caso contrario será impresso a peca
		} else {
			if (peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_BRANCO + peca + ANSI_RESETAR);
			} else {
				System.out.print(ANSI_AMARELO + peca + ANSI_RESETAR);
			}
		}
		// impressao do espaço em branco para q as pecas nao fiquem grudadas
		System.out.print(" ");
	}
	

}
