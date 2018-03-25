package principal;

public class Conversao {
           //Metodo Iterativo
	public int converterBaseParaDecimal(String digitos, int b) {
		if(digitos.length() != 8) {    //O tamanho da string não pode ser diferente de 32 digitos
			System.out.println("--- ERRO: A STRING PRECISA TER 32 BITS ---");
			return -000;
		}else if(b < 2 || b > 16) {    //A base escolhida não pode ser menor que 2 e nem maior que 16
			//Fora de alcance
			System.out.println("--- ERRO: A BASE PRECISA SER ENTRE 2 E 16 --- ");
			return -000;
		}else if(b == 10) { //Se a base for 10 ela vai retornar o próprio numero,pois ele já vai estar em decimal
			return Integer.parseInt(digitos);
		}else {    //Verifica se o numero corresponde a base em que está inserida
			for(int i = 0; i < digitos.length(); i++) {
				if(transformarCharParaInt(digitos.charAt(i)) >= b) {
					System.out.println("--- ERRO: DIGITOS DE BASE DIFERENTE DA ESPECIFICADA ---");
					return -000;
				}
			}
		}
		
		digitos = digitos.toUpperCase();  //Transforma todas as letras presentes na string em maiuscula
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
		for(int i = tamanho-1; i >= 0; i--) {  //for para percorrer a string
			//os outros digitos normais
			int atual = transformarCharParaInt(digitos.charAt(i));
			int multiplicador = (int)Math.pow(b, (tamanho-1) - i); //Função que eleva a base a b ao [(tamanho da string menos 1)- a posição atual do i
			
			resultado += atual * multiplicador; //o resultado vai somando o valor da multiplicaçao de cada digito
			
		}
		
		if(isNegativo) {  //Se o numero for negativo,multiplica-se o resultado por -1 para torna-lo negativo
			resultado = resultado * -1;
		}
		return resultado;
	}
	    //Metodo recursivo
	public String converterDecimalParaBase(int valor, int b) {  //Recebe o  valor decimal e a base para qual o numero vai ser transformado
		if(b < 2 || b > 16) {
			//Fora de alcance
			return "--- ERRO: A BASE PRECISA SER ENTRE 2 E 16 --- ";
		}else if(b == 10){
			return "" + valor; //Retorna  o proprio valor
		}
		
		boolean isNegativo = false;
		if(valor < 0) {
			isNegativo = true;
			valor = valor * -1; //Para torna-lo positivo
		}
		
		String resultado = ""; //String que vai armazenar o resultado
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