package com.uce.ec.service.funcional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfacesFuncionales {

	public static final Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero >=3;
	}
	
	public static void imprimir(String cadena) {
		LOG.info("impresion: "+cadena);
	}
	public static void guardar(String cadena) {
		//consumo para el repositoio de guardar
		LOG.info("guardado valor: "+cadena);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metHO = new ConsumoMetodosHighOrder();

		// SUPLIER
		// CLASES
		IPersonaSupplier<String> supplier = new PersonaSuplierImpl();
		LOG.info("Suplier Clase: " + supplier.getNombre());
		// LAMBDAS
		IPersonaSupplier<String> supplierLambda = () -> "Dennis 2";
		LOG.info("Suplier Lambda: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSuplierTEImpl();
		LOG.info("Suplier Clase: " + supplierTE.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "DanielTE 2";
		LOG.info("Suplier Lambda: " + supplierLambdaTE.getNombre());

		// CONSUMER
		// CLASES
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("holi");
		// LAMBDAS

		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("esta es la cadena");

		// PREDICATE
		// CLASES

		// LAMBDAS
		// parametro que recibe simbolo orden que rotorna
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate lambda: " + predicateLambda.evaluar("OrtiZ"));

		// FUNCTION
		// CLASES

		// LAMBDAS
		// recibe lo que esta en el diamante
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("funcion lambda: " + functionLambda.aplicar("7"));

		// UNARY OPERATOR (FUNCTION)

		// lambda
		IPersonaUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("sufijo");
			return valorFinal;
		};

		LOG.info("Unary lambda: " + unaryLambda.apply("Daniel "));

		// Metodos HIGH ORDER
		// suplier
		String valorHO = metHO.consumirSupplier(() -> {
			String valor = "Denis";
			return valor;
		});
		LOG.info("HO suplier " + valorHO);
		// consumer
		metHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// predicate
		boolean respuesta = metHO.consumirPredicate(cadena -> cadena.contains("z"), "Ortiz");
		LOG.info("HO Predicate: " + respuesta);

		// funcion
		String valorfinal = metHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return "retorna String " + retorno;
		}, 1);

		LOG.info("HO funcion " + valorfinal);

		// METODOS JAVA High order
		// suplier
		LOG.info("Metodos HO JAVA Stream");
		LOG.info("SUPPLIER JAVA");
		Stream<String> test = Stream.generate(() -> "Dennis JAVA").limit(5);// este es el supplier
		test.forEach(cadena -> System.out.println(cadena));// para imprimir uso foreach que es consumer
		// consumer
		LOG.info("CONSUMER JAVA");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listaNumeros.forEach(numero -> System.out.println(numero));// Metodos High Order este recibe un consumer, el
																	// consumer recibe un argumento pero no hace ningun
																	// retorno
		// predicate
		LOG.info("PREDICATE JAVA");
		Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> prueba(numero));// filtro numeros mayores a
																							// 3 el predicate recibe
																							// argumento y devuelve
																							// boolean
		listaFiltrada.forEach(numero -> System.out.println(numero));
		
		//function
		LOG.info("FUNCTION JAVA");
		//cast coversion  empleado -> empleadoTO(ligero)
		Stream<String> listaCambiada = listaNumeros.stream().map(numeros -> {
			Integer valor = numeros+1;
			String cadena= "num: "+valor.toString();
		return cadena;
		});
		//listaCambiada.forEach(valor -> imprimir(valor));
		listaCambiada.forEach(valor -> guardar(valor));
		
		List<String> lista1=new ArrayList<>();
		Map<String, String> mp1=new HashMap<String, String>();
		
		
		
		//unary
		
		
	}

}
