package com.endes;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ControladorDNI controlador = new ControladorDNI();
    	
    	boolean esValido1 = controlador.esValido("81440286T");
    	System.out.println(esValido1);
    	
    	boolean esValido2 = controlador.esValido("814400286R");
    	System.out.println(esValido2);
    }
}
