package tabuleiroJogo;

//classe para tratamento das exce�oes extendida para exce�oes 
public class ExcecaoTabuleiro extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	//construtor que recebe mensagem string
	public ExcecaoTabuleiro(String msg) {
		//vai repassar essa mensagem para super classe
		super(msg);
	}
	
	
}

