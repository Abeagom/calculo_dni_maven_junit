package com.endes;

public class ControladorDNI {
	private final char LETRAS[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	private final int DIVISOR_DNI = 23;
	private final int LONGITUD_NUMERO_DNI = 8;
	private final int LONGITUD_DNI_COMPLETO = 9;
	
	/**
	 * Calcula la letra correspondiente a un número de DNI
	 * @param numeroDNI Cadena con el número de 8 dígitos
	 * @return Devuelve la letra correspondiente al DNI
	 */
	private char calcularLetra (String numeroDNI) {
		if (numeroDNI.length()!=LONGITUD_NUMERO_DNI || numeroDNI ==null || !numeroDNI.matches("\\d+")) {
			throw new IllegalArgumentException("El número del DNI no es válido");
		}
		int numero = Integer.parseInt(numeroDNI);
		int posicionLetra = numero % DIVISOR_DNI;
		return LETRAS[posicionLetra];
	}
	/**
	 * Verifica si un DNI completo es válido
	 * @param dniCompleto DNI completo con 8 dígitos y una letra
	 * @return Devuelve true si es válido y false si no
	 */
	public boolean esValido (String dniCompleto) {
		if (dniCompleto==null || dniCompleto.length() != LONGITUD_DNI_COMPLETO) {
			return false;
		}
		try {
			String numero = dniCompleto.substring(0, LONGITUD_NUMERO_DNI);
			char letraProporcionada = Character.toUpperCase(dniCompleto.charAt(8));
			return letraProporcionada == calcularLetra(numero);
		}catch(IllegalArgumentException exception) {
			return false;
		}
	}
	/**
	 * Genera un DNI aleatorio
	 * @return Devuelve 8 dígitos y una letra
	 */
	public String generarAleatorioDNI() {
        int numeroAleatorio = (int) (Math.random() * 100000000);
        String numeroDni = String.format("%08d", numeroAleatorio);
        char letra = calcularLetra(numeroDni);
        return numeroDni + letra;
	}
}
