

public class Main {

	public static void main(String[] args) {
		Conversao conversao = new Conversao();
		int numero = conversao.converterBaseParaDecimal("AFF", 16);
		System.out.println(numero);
		
		//String numero = conversao.converterDecimalParaBase(5999, 16);
		//System.out.println(numero + ", possui " + numero.length() + " bits.");
	}

}
