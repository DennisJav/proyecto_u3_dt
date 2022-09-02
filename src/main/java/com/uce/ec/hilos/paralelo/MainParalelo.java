
package com.uce.ec.hilos.paralelo;

import java.util.ArrayList;
import java.util.List;

public class MainParalelo {

	public static void main(String[] args) {


		long tiempoIni = System.currentTimeMillis();
		
		ProductoParalelo p1= new ProductoParalelo("Sal","1");
		ProductoParalelo p2= new ProductoParalelo("Azucar","2");
		ProductoParalelo p3= new ProductoParalelo("Morocho","3");
		ProductoParalelo p4= new ProductoParalelo("Atun","4");
		ProductoParalelo p5= new ProductoParalelo("Cafe","5");
		List<ProductoParalelo> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		lista.add(p5);

		for(int i=0;i<lista.size();i++) {
		   Inventario inve = new Inventario(lista.get(i));
		   inve.start();
		}
			
		long tiempoFin = System.currentTimeMillis();

		long tiempoDemora = (tiempoFin - tiempoIni) / 1000;

		System.out.println("Tiempo de demora en insercion de prod " + tiempoDemora + " segundos");
	}
		
}
