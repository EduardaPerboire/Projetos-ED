
public class Main {

	public static void main(String[] args) {
		Conversao conversao = new Conversao();
		//int numero = conversao.converterBaseParaDecimal("110001100111000", 2);
		//System.out.println(numero);
		
		String numero = conversao.converterDecimalParaBase(25400, 2);
		System.out.println(numero);
	}

}
