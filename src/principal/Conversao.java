package principal;

public class Conversao {

	public int converterBaseParaDecimal(String digitos, int b) {
		if(digitos.length() != 8) {
			System.out.println("--- ERRO: A STRING PRECISA TER 32 BITS ---");
			return -51;
		}else if(b < 2 || b > 16) {
			//Fora de alcance
			System.out.println("--- ERRO: A BASE PRECISA SER ENTRE 2 E 16 --- ");
			return -51;
		}else if(b == 10) {
			return Integer.parseInt(digitos);
		}
		
		
		digitos = digitos.toUpperCase();
		int tamanho = digitos.length();
		
		int a = 0, n = 0;
		if(transformarCharParaInt(digitos.charAt(0)) == b-1) {
				String temp = "";
				for(int i = 0; i < digitos.length(); i++) {
					n = transformarCharParaInt(digitos.charAt(i));
					a = (b - 1) - (n);
					
					if(i == digitos.length()-1) {
						a++;
					}
					temp += transformarIntParaChar(a);
				}
				
				for(int i = digitos.length()-1; i >= 0; i--) {
					int atual = transformarCharParaInt(temp.charAt(i));
					if(atual >= b) {
						temp = temp.substring(0, i) + 0 + temp.substring(i+1);
						temp = temp.substring(0, i-1) + (transformarCharParaInt(temp.charAt(i-1))+1) + temp.substring(i);
					}
				}
				System.out.println(temp);
				//digitos = temp;
				
		}
		
		int resultado = 0;
		for(int i = tamanho-1; i >= 0; i--) {
			//os outros digitos normais
			int atual = transformarCharParaInt(digitos.charAt(i));
			int multiplicador = (int)Math.pow(b, (tamanho-1) - i);
			
			resultado += atual * multiplicador;
			
		}

		System.out.println(digitos);
		return resultado;
	}
	
	public int transformarCharParaInt(char c) {
		int numero = 0;
		
		switch(c) {
		case 'A' : 
			numero = 10;
			break;
		case 'B' :
			numero = 11;
			break;
		case 'C' : 
			numero = 12;
			break;
		case 'D' :
			numero = 13;
			break;
		case 'E' : 
			numero = 14;
			break;
		case 'F' :
			numero = 15;
			break;
		default :
			numero = c - '0';
			break;
		}
		
		return numero;
	}
	
	public String converterDecimalParaBase(int valor, int b) {
		if(b < 2 || b > 16) {
			//Fora de alcance
			return "--- ERRO: A BASE PRECISA SER ENTRE 2 E 16 --- ";
		}
		
		boolean isNegativo = false;
		if(valor < 0) {
			isNegativo = true;
			valor = valor * -1;
		}
		
		String resultado = "";
		if(valor < b) {
			int i = valor % b;
			for(int index = 0; index < 32; index++) {
				resultado += "0";
			}
			resultado = resultado.substring(1);
			resultado += transformarIntParaChar(i);
			return resultado;
		}
		
		resultado += converterDecimalParaBase(valor/b, b);
		resultado += transformarIntParaChar(valor % b);
		resultado = resultado.substring(1);
		
		int a = 0, n = 0;
		if(isNegativo) {
			String temp = "";
			for(int i = 0; i < resultado.length(); i++) {
				n = transformarCharParaInt(resultado.charAt(i));
				a = (b - 1) - (n);
				
				if(i == resultado.length()-1) {
					a++;
				}
				temp += transformarIntParaChar(a);
			}
			
			for(int i = resultado.length()-1; i >= 0; i--) {
				int atual = transformarCharParaInt(temp.charAt(i));
				if(atual >= b) {
					temp = temp.substring(0, i) + 0 + temp.substring(i+1);
					temp = temp.substring(0, i-1) + (transformarCharParaInt(temp.charAt(i-1))+1) + temp.substring(i);
				}
			}
			resultado = temp;
		}
		return resultado;
	}
	
	public String transformarIntParaChar(int numero) {
		String c = "";
		switch(numero) {
		case 10 : 
			c = "A";
			break;
		case 11 :
			c = "B";
			break;
		case 12 : 
			c = "C";
			break;
		case 13 :
			c = "D";
			break;
		case 14 : 
			c = "E";
			break;
		case 15 :
			c = "F";
			break;
		default :
			c +=  numero;
			break;
		}
		
		return c;
	}
}