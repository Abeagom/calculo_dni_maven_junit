package com.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControladorDNITest {
	ControladorDNI controlador;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		controlador = new ControladorDNI();
	}

	@Test
	@DisplayName ("Validación correcta")
	void testEsValidoDNI() {
		//Caso de prueba válido
		String dniCorrecto = "11111111H";
		assertTrue(controlador.esValido(dniCorrecto));
	}
	
	@Test
	@DisplayName ("Validación incorrecta")
	void testEsFalsoDNI(){
		String dniFalso = "11111111R";
		assertFalse(controlador.esValido(dniFalso));
	}
	
	@Test
	@DisplayName ("Validación de entradas nulas")
	void testEsValido_DNIEntradasInvalidas(){
		assertFalse(controlador.esValido(null), "Un DNI nulo fue introducido");
	}
	
	@Test
	@DisplayName ("Validación de entradas nulas")
	void testEsValido_DNICorto(){
		assertFalse(controlador.esValido("11111H"), "El DNI es demasiado corto");
	}

}
