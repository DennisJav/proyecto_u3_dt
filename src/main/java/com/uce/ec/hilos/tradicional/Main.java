package com.uce.ec.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Dennis", Arrays.asList("Pepe","Juan","Daniela","Pedro"));
		Cajero cajero2 = new Cajero("Javier", Arrays.asList("Pepe2","Juan2","Daniela2"));
		Cajero cajero3 = new Cajero("Lizeth", Arrays.asList("Pepe3","Juan3"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTotal = (tiempoFinal-tiempoInicial)/1000;
		System.out.println("Tiempo transcurrido: "+ tiempoTotal + "s");
		
		
	}

}
