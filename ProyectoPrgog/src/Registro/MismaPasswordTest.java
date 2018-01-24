package Registro;

import static org.junit.Assert.*;

import org.junit.Test;

public class MismaPasswordTest {


	
	@Test
	public void testMismaPass(){
		
		char[] j1= new char[3];
		char[] j2= new char[3];
		
		j1[0]='a';
		j1[1]='b';
		j1[2]='c';
		
		j2[0]='a';
		j2[1]='b';
		j2[2]='c';
		
		boolean resultado= VentanaRegistro.isPasswordCorrect(j1, j2);
		boolean resultadoPrevisto= true;
		assertEquals(resultadoPrevisto, resultado);
		
	}
	
	
	
	
}
