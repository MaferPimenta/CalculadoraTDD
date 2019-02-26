import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTests {

	
	@Test
	public void calcular_StringVazia_returnZero() {
		Calculadora calculadora = new Calculadora();
		int resultado = calculadora.calcular("");
		
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void calcular_SingleNumber_returnTheNumber() {
		Calculadora calculadora = new Calculadora();
		int resultado = calculadora.calcular("1");
		
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void calcular_TwoNumbersComma_returnTheSum() {
		Calculadora calculadora = new Calculadora();
		int resultado = calculadora.calcular("1,3");
		
		Assert.assertEquals(4, resultado);
	}
	
	@Test
	public void calcular_TwoNumbersNewLine_returnTheSum() {
		Calculadora calculadora = new Calculadora();
		int resultado = calculadora.calcular("2\n3");
		
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void calcular_ThreeNumbersEitherWay_returnTheSum() {
		Calculadora calculadora = new Calculadora();
		int resultado = calculadora.calcular("2-2-2");
		
		Assert.assertEquals(6, resultado);
	}
	
	@Test(expected=Exception.class)
	public void calcular_NegativeNumbers_throwException() {
		Calculadora calculadora = new Calculadora();	
		int resultado = calculadora.calcular("-1,3");
     }
	
	@Test
	public void calcular_NumbersGreaterThan1000_areIgnored() {
		Calculadora calculadora = new Calculadora();	
		int resultado = calculadora.calcular("1001");
		
		Assert.assertEquals(0, resultado);
     }
	
	@Test
	public void calcular_SingleCharDelimited_firstLine() {
		Calculadora calculadora = new Calculadora();	
		int resultado = calculadora.calcular("//#2#1#4");
		
		Assert.assertEquals(7, resultado);
     }
	
	@Test
	public void calcular_MultiCharDelimited_firstLine() {
		Calculadora calculadora = new Calculadora();	
		int resultado = calculadora.calcular("//[###]2###1###4");
		
		Assert.assertEquals(7, resultado);
     }
	
	@Test
	public void calcular_MultiOrSingleCharDelimiter_canBeDefined() {
		Calculadora calculadora = new Calculadora();	
		int resultado = calculadora.calcular("//[&&]2&&0&&4");
		
		Assert.assertEquals(6, resultado);
     }
}

