

public class Main {

	public static void main(String[] args) {
		Conversao conversao = new Conversao();
		//int numero = conversao.converterBaseParaDecimal("FFFFFFCD", 16);
		//System.out.println(numero);
		
		String numero = conversao.converterDecimalParaBase(51, 2);
		System.out.println(numero + ", possui " + numero.length() + " bits.");
	}

}
