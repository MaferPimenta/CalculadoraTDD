import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

public class Calculadora {

	public int calcular(String expressao) {
		
		if (expressao == null || expressao.isEmpty()) {
			return 0;
		} 

		if (expressao == "1") {
			return 1;
		}
		
     int resultado = 0;
     
     String delimitador = delimitadorReturn(expressao);

     if (expressao.startsWith("//[")) {
    	 expressao = expressao.substring(delimitador.length() + 4);
     } else if (expressao.startsWith("//")) {
    	 expressao = expressao.substring(delimitador.length() + 2);
     }
     
	 String numbers[] = expressao.split(delimitador);
	 
	 for (String number : numbers) {
		 //resultado = resultado + Integer.parseInt(number);
		 resultado += Integer.parseInt(number);		 
		 
		 if (resultado < 0) {
			 throw new RuntimeException("O número não pode ser negativo");
		 }
		 
		 if (resultado > 1000) {
			 resultado = 0;
		 }
	 }
	 
	 /*
	 * String n1 = expr[0]; 
	 * String n2 = expr[1];
	 * 
	 * int intN1 = Integer.parseInt(n1); 
	 * int intN2 = Integer.parseInt(n2);
	 * 
	 * resultado = intN1 + intN2;
	 */	
	 
	 return resultado;

	}
	
	private String delimitadorReturn(String expressao) {
		
		if (expressao.contains("\n")) {
			return "\n";
		}
		
		if (expressao.contains("-")) {
			return "-";
		}
		
		if (expressao.contains("//[")) {
			String regex = "\\[(.*?)\\]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(expressao);
			
			m.find();
			
			String delimitador = m.group(1);
			return delimitador;
			
		} else if (expressao.contains("//")) {
			String delimitador = "";
			delimitador = expressao.substring(2,3);
			return delimitador;
		}

		return ",";
		
		}
	}
	


