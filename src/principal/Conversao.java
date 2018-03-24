package principal;

public class Conversao {

	public int converterBaseParaDecimal(String digitos, int b) {
		if(digitos.length() != 8) {
			System.out.println("--- ERRO: A STRING PRECISA TER 32 BITS ---");
			return -000;
		}else if(b < 2 || b > 16) {
			//Fora de alcance
			System.out.println("--- ERRO: A BASE PRECISA SER ENTRE 2 E 16 --- ");
			return -000;
		}else if(b == 10) {
			return Integer.parseInt(digitos);
		}else {
			for(int i = 0; i < digitos.length(); i++) {
				if(transformarCharParaInt(digitos.charAt(i)) >= b) {
					System.out.println("--- ERRO: DIGITOS DE BASE DIFERENTE DA ESPECIFICADA ---");
					return -000;
				}
			}
		}
		
		digitos = digitos.toUpperCase();
		boolean isNegativo = false;
		int tamanho = digitos.length();
		
		if(transformarCharParaInt(digitos.charAt(0)) == b-1) {
			int digitoConvertido = 0, digitoAtual = 0;
			isNegativo = true;
			String temp = "";
			
			for(int i = 0; i < digitos.length(); i++) {
				digitoAtual = transformarCharParaInt(digitos.charAt(i));
				digitoConvertido = (b - 1) - (digitoAtual);
					
				if(i == digitos.length()-1) {
					digitoConvertido++;
				}
				temp += transformarIntParaChar(digitoConvertido);
			}
			
			for(int i = digitos.length()-1; i >= 0; i--) {
				int atual = transformarCharParaInt(temp.charAt(i));
				if(atual >= b) {
					temp = temp.substring(0, i) + 0 + temp.substring(i+1);
					
					temp = temp.substring(0, i-1)
							+ (transformarCharParaInt(temp.charAt(i-1))+1)
							+ temp.substring(i);
				}
			}
			digitos = temp;
		}
		
		int resultado = 0;
		for(int i = tamanho-1; i >= 0; i--) {
			//os outros digitos normais
			int atual = transformarCharParaInt(digitos.charAt(i));
			int multiplicador = (int)Math.pow(b, (tamanho-1) - i);
			
			resultado += atual * multiplicador;
			
		}
		
		if(isNegativo) {
			resultado = resultado * -1;
		}
		return resultado;
	}
	
	public String converterDecimalParaBase(int valor, int b) {
		if(b < 2 || b > 16) {
			//Fora de alcance
			return "--- ERRO: A BASE PRECISA SER ENTRE 2 E 16 --- ";
		}else if(b == 10){
			return "" + valor;
		}
		
		boolean isNegativo = false;
		if(valor < 0) {
			isNegativo = true;
			valor = valor * -1;
		}
		
		String resultado = "";
		if(valor < b) {
			for(int index = 0; index < 32; index++) {
				if(isNegativo) {
					resultado += transformarIntParaChar(b-1);
				}else {
					resultado += "0";
				}
			}
			
			if(isNegativo) {
				resultado += transformarIntParaChar(b-valor);
			}else {
				resultado += transformarIntParaChar(valor);
			}
			
			resultado = resultado.substring(1);
			return resultado;
		}
		resultado += converterDecimalParaBase(valor/b, b) 
				   + transformarIntParaChar(valor % b);
		resultado = resultado.substring(1);
		
		if(isNegativo) {
			int digitoConvertido = 0, digitoAtual = 0;
			String temp = "";
			for(int i = 0; i < resultado.length(); i++) {
				digitoAtual = transformarCharParaInt(resultado.charAt(i));
				digitoConvertido = (b - 1) - (digitoAtual);
				
				if(i == resultado.length()-1) {
					digitoConvertido++;
				}
				temp += transformarIntParaChar(digitoConvertido);
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