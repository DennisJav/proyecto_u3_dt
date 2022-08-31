
package com.uce.ec.hilos.paralelo;

import java.util.Arrays;

import com.uce.ec.hilos.tradicional.Cajero;
import com.uce.ec.hilos.tradicional.PCCajero;

public class MainParalelo {

	public static void main(String[] args) {



		CajeroParalelo cajero1 = new CajeroParalelo("Dennis", Arrays.asList("Pepe"));
		CajeroParalelo cajero2 = new CajeroParalelo("Javier", Arrays.asList("Pepe2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Lizeth", Arrays.asList("Pepe3"));
		CajeroParalelo cajero4 = new CajeroParalelo("Dennis2", Arrays.asList("Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("Javier2", Arrays.asList("Juan2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Lizeth2", Arrays.asList("Juan3"));
		
		
		
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start(); //el metodo star llama al metodo run
		
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();
		
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();
		
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start();
		
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();
		
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();
		
		
		
		
		
		
	}

}
