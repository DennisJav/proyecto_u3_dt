package com.uce.ec.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//PROCESAMIENTO SINCRONO ES UN SOLO HILO DE EJECUCION
		Long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		
		Cajero cajero1 = new Cajero("Dennis", Arrays.asList("Pepe","Juan","Daniela","Pedro"));
		Cajero cajero2 = new Cajero("Javier", Arrays.asList("Pepe2","Juan2","Daniela2"));
		Cajero cajero3 = new Cajero("Lizeth", Arrays.asList("Pepe3","Juan3"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		
		PCCajero gestorAtencion2 = new PCCajero();
		gestorAtencion2.procesar(cajero2);
		
		PCCajero gestorAtencion3 = new PCCajero();
		gestorAtencion3.procesar(cajero3);
		
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTotal = (tiempoFinal-tiempoInicial)/1000;
		System.out.println("Tiempo transcurrido: "+ tiempoTotal + "s");
		
		//
		
		
	}

}
