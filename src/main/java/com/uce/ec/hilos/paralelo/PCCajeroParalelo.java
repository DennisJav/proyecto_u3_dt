package com.uce.ec.hilos.paralelo;

import java.util.concurrent.TimeUnit;

import com.uce.ec.hilos.tradicional.Cajero;

public class PCCajeroParalelo extends Thread{

	//para enviar el cajero al run
	private CajeroParalelo cajero;
	//constructor para recibir parametros si esque necesito
	public PCCajeroParalelo(CajeroParalelo cajero) {
		super();
		this.cajero = cajero;
	}

	//Dispara el metodo a paralelizar
	@Override
	public void run() {
		
		this.procesar(this.cajero);
		
	}
	
	
	public void procesar(CajeroParalelo cajero) {
		
		Long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre hilo: " + Thread.currentThread().getName());
		
		System.out.println("Nombre hilo procesar: "+Thread.currentThread().getName());
		System.out.println("Procesando cajero: "+cajero.getNombre());
		for(String cliente:cajero.getClientes()) {
			this.atenderCliente(cliente);
		}

		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTotal = (tiempoFinal-tiempoInicial)/1000;
		System.out.println("Termino de procesar el cajero: "+cajero.getNombre()+" Tiempo transcurrido: "+ tiempoTotal + "s");

		
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
