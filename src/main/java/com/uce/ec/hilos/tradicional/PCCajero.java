package com.uce.ec.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {

	public void procesar(Cajero cajero) {
		
		System.out.println("Procesando cajero: "+cajero.getNombre());
		for(String cliente:cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
		
	}
	
	public void atenderCliente(String cliente) {
		System.out.println("Atendiendo a:"+cliente);
		//demora 10 segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
