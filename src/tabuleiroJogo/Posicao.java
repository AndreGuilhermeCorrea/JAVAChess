package tabuleiroJogo;

//pacote corresponde a camada do tabuleiro
//Class posicao [public]
/*
o Encapsulation(encapsulamento)
o Constructors(construtores)
o ToString (Object / overriding)
*/

public class Posicao {

	
	//atributos para linha e coluna
	private int linha;
	private int coluna;
	
	
	//construtor com os aargumentos
	
	public Posicao(int linha, int coluna) {

		this.linha = linha;
		this.coluna = coluna;
	}

	//encapsulamento
	//gethers e sethers
	public int getLinha() {
		return linha;
	}


	public void setLinha(int linha) {
		this.linha = linha;
	}


	public int getColuna() {
		return coluna;
	}


	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	//método para atualizar os valores de uma posicao 
	public void setValores(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	//tostring para imprimir a posição na tela
	//afirmando que a classe objetivo é a superclasse de todas as classes
	//sobreposição ou seja subescrevendo o método toString  que pertence a classe objetivo
	@Override
	public String toString() {
		return linha + ", " + coluna;
		
	}
	
	
	
	
	
}
