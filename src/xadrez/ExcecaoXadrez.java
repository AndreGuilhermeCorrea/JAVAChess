package xadrez;

public class ExcecaoXadrez extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	//construtor que recebe o string
	public ExcecaoXadrez(String msg) {
		//repassar para o construtor da super classe a mensagem msg
		super(msg);
		
	}
}
