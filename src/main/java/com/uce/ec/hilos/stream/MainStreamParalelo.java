package com.uce.ec.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre hilo: " + Thread.currentThread().getName());
		
		List<Integer> listaNumerosAlumnos = new ArrayList<>();

		for (int i = 1; i < 5000; i++) {
			listaNumerosAlumnos.add(i);

		}		
		
		//CAMBIO DE STREAM -----> PARALLELSTREAM() 
		                                                 // numero integer convertido a string con metodo que retprna un string
		List<String> listaProcesada = listaNumerosAlumnos.parallelStream().map(numero -> convertirIdAlumno(numero))
				.collect(Collectors.toList()); // convierte a una lista de string
		
		listaProcesada.forEach(cadena -> System.out.println(cadena));
		
		
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTotal = (tiempoFinal-tiempoInicial)/1000;
		System.out.println("Termino de procesar: "+ tiempoTotal + "s");
		
	}


	private static String convertirIdAlumno(Integer id) {

		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "ID: " + id.toString();
	}
	
}
