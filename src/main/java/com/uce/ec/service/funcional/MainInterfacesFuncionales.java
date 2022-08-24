package com.uce.ec.service.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfacesFuncionales {

	public static final Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoMetodosHighOrder metHO = new ConsumoMetodosHighOrder();

		
		
		// SUPLIER
		// CLASES
		IPersonaSupplier<String> supplier = new PersonaSuplierImpl();
		LOG.info("Suplier Clase: "+supplier.getNombre());
		// LAMBDAS
		IPersonaSupplier<String> supplierLambda = () -> "Dennis 2";
		LOG.info("Suplier Lambda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierTE = new PersonaSuplierTEImpl();
		LOG.info("Suplier Clase: "+supplierTE.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = () -> "DanielTE 2";
		LOG.info("Suplier Lambda: "+supplierLambdaTE.getNombre());
		
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
						//parametro que recibe            simbolo       orden que rotorna
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate lambda: "+predicateLambda.evaluar("OrtiZ"));
		
		
		// FUNCTION
		// CLASES

		// LAMBDAS
						// recibe lo que esta en el diamante
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor -2;
			return valorFinal;
		};
		LOG.info("funcion lambda: "+functionLambda.aplicar("7"));
		
		// UNARY OPERATOR (FUNCTION)

		//lambda
		IPersonaUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal =	cadena.concat("sufijo"); 
			return valorFinal;
		};
		
		LOG.info("Unary lambda: "+unaryLambda.apply("Daniel "));
		
		
		//Metodos HIGH ORDER
		//suplier
		String valorHO = metHO.consumirSupplier(() -> {
			String valor = "Denis";
			return valor;
		});
		LOG.info("HO suplier "+valorHO);
		//consumer
		metHO.consumirConsumer(valor -> System.out.println(valor), 2);
	
		//predicate
		boolean respuesta = metHO.consumirPredicate(cadena -> cadena.contains("z"), "Ortiz");
		LOG.info("HO Predicate: "+respuesta);
		
		//funcion
		String valorfinal=metHO.consumirFunction(valor -> {
			String retorno = valor.toString()+"A";
			return "retorna String "+retorno;
		}, 1);
		
		LOG.info("HO funcion "+valorfinal);
		
		
		
		
	}

}
