package com.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {
	
	CuentaBancaria cuenta;
	@BeforeEach
	void setup() throws Exception{
		cuenta = new CuentaBancaria(1000);
	}

	@Test
	@DisplayName("Prueba donde el saldo crucial es correcto")
	void testConstructorValido() {
		double resultadoEsperado = 1000.0;
		assertEquals(resultadoEsperado, cuenta.getSaldo(), "No se corresponde el saldo obtenido con el pasado");
	}
	
	@Test
	@DisplayName("Prueba donde el saldo inicial es negativo.")
	void testConstructorNoValido() {
		String mensajeEsperado = "El saldo inicial no puede ser negativo.";
		Exception exception = assertThrows(IllegalArgumentException.class, ()-> new CuentaBancaria(-200));
		
		assertEquals(mensajeEsperado, exception.getMessage(), "Deben coincidir las respuestas al crear la cuenta");
	}
	
	@Test
	@DisplayName("Prueba donde el saldo a depositar es correcto")
	void testDepositarSaldoPositivo() {
		double saldoEsperado = 1100.0;
		cuenta.depositar(100);
		assertEquals(saldoEsperado, cuenta.getSaldo(), "No se corresponde el saldo obtenido con el esperado");
	}

	@Test
	@DisplayName("Prueba donde el saldo a depositar es negativo")
	void testDepositarSaldoNegativo() {
		String mensajeEsperado = "La cantidad a depositar debe ser positiva.";
		Exception exception = assertThrows(IllegalArgumentException.class, ()-> cuenta.depositar(-39));
		assertEquals(mensajeEsperado, exception.getMessage(), "No se corresponde el saldo obtenido con el esperado");
	}

	@Test
	@DisplayName("Prueba donde el saldo a retirar es mayor que el saldo de la cuenta")
	void testRetirarFondosInsuficientes() {
		String mensajeEsperado = "Fondos insuficientes para retirar.";
		Exception exception = assertThrows(IllegalArgumentException.class, ()-> cuenta.retirar(1500));
		assertEquals(mensajeEsperado, exception.getMessage(), "No se corresponden los mensajes");
	}
	
	@Test
	@DisplayName("Prueba donde retiramos fondos válidos")
		void testRetirarCorrecto() {
			double resultadoEsperado = 700;
			double resultado = cuenta.retirar(300);
			assertEquals(resultadoEsperado, resultado, "No se corresponde el saldo obtenido con el esperado" );
			
		}
	
	@Test
	@DisplayName("Prueba donde el saldo a retirar es negativo")
	void testRetirarSaldoNegativo() {
		String mensajeEsperado = "La cantidad a retirar debe ser positiva.";
		Exception exception = assertThrows(IllegalArgumentException.class, ()-> cuenta.retirar(-200));
		String mensajeRetornado = exception.getMessage();
		assertEquals(mensajeEsperado, mensajeRetornado, "No se corresponden los mensajes");
	}

	@Test
	@DisplayName("Prueba donde se retira todo el saldo")
	void testRetirarSaldoCompleto() {
		double resultadoEsperado = 0;
		double resultado = cuenta.retirar(1000);
		assertEquals(resultadoEsperado, resultado, "No se corresponde el saldo obtenido con el esperado");
	}

	@Test
	@DisplayName("El saldo no debe cambiar si ocurre una excepción")
	void testEstadoConsistente() {
		double resultadoEsperado = cuenta.getSaldo();
		try {
			cuenta.retirar(1500);
		}catch(Exception ex){
			
		}
		double valor = cuenta.getSaldo();
		assertEquals (resultadoEsperado, valor);
	}
}
