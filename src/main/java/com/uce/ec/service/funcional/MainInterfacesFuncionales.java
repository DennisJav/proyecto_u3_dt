package com.uce.ec.service.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfacesFuncionales {

	public static final Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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

		// FUNCTION
		// CLASES

		// LAMBDAS

		// UNARY OPERATOR (FUNCTION)

	}

}
