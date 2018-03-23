
public class Conversao {

	public int converterBaseParaDecimal(String digitos, int b) {
		if(b == 10) {
			return Integer.parseInt(digitos);
		}
		int tamanho = digitos.length();
		digitos.toUpperCase();
		
		if(tamanho==8) {
			if(digitos.charAt(0) >= b/2) {
				//negativo
				
				String temp = "";
				
				for(int i = digitos.length()-1; i >= 0; i--) {
					int n = transformarCharParaInt(digitos.charAt(i));
					int a = 0;
					
					if(i == digitos.length()-1) {
						a = n-1; // diminuir um
					}
					
					a = (b -1) - a;
					temp += transformarIntParaChar(a);
					
				}
				//System.out.println(temp);
			}
		}
		
		int resultado = 0;
		for(int i = tamanho-1; i >= 0; i--) {
			//quando i == 0, seria o digito mais significativo.
			//Coloquei -1 para nao rodar esse if que nao foi terminado (:
			if(i == -1) {
				if(digitos.charAt(i) - '0' == 0) {
					//PARRR
				}else if (digitos.charAt(i) - '0' == 1) {
					//IMPARRR
				}
			}else {
			//os outros digitos normais
			int atual = transformarCharParaInt(digitos.charAt(i));
			int multiplicador = (int)Math.pow(b, (tamanho-1) - i);
			
			resultado += atual * multiplicador;
			}
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
	
	public String converterDecimalParaBase(int valor, int b) {
		boolean isNegativo = false;
		if(valor < 0) {
			isNegativo = true;
			valor = valor * -1;
		}
		
		String resultado = "";
		if(valor < b) {
			int i = valor % b;
			resultado += transformarIntParaChar(i);
			return resultado;
		}
		
		resultado += converterDecimalParaBase(valor/b, b);
		resultado += transformarIntParaChar(valor % b);
		
		char[] vetorNBits = new char[32];
		for(int i = 32; i >= 0; i --) {
			if(i < resultado.length()) {
				System.out.println(resultado.charAt(i));
				vetorNBits[32 - i] = resultado.charAt(i);
			}else {
				vetorNBits[32 - i] = '0';
			}
		}
		resultado = "";
		for(int i  = 0; i < 32; i++) {
			resultado += vetorNBits[i];
		}
		
		if(isNegativo) {
			String temp = "";
			for(int i = 0; i < resultado.length(); i++) {
				int n = transformarCharParaInt(resultado.charAt(i));
				int a = (b - 1) - (n);
				
				if(i == resultado.length()-1) {
					a++;
					if(a >= b) {
						String[] numeros = new String[resultado.length()];
						for(int j = numeros.length; j >= 0; j--){
							numeros[j] = transformarIntParaChar((a % b));
							a = a/b;
							temp += numeros[j];
						}
					}
				}
				temp += transformarIntParaChar(a);
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
