package principal;

//Para a realização de testes!
public class Main {

	public static void main(String[] args) {
		Conversao conversao = new Conversao();
		int numero = conversao.converterBaseParaDecimal("00110011", 2);
		System.out.println("Resultado em decimal: " + numero);
		
		//String numero = conversao.converterDecimalParaBase(51, 2);
		//System.out.println("Resultado: " + numero);
	}

}
