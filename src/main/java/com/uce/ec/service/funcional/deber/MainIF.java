package com.uce.ec.service.funcional.deber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainIF {
	public static final Logger LOG = LogManager.getLogger(MainIF.class);

	public static void main(String[] args) {

		MetodosHO consumoHO = new MetodosHO();

		// suplier
		ISupplier<String> sup = new SupplierImpl();
		LOG.info("Ejecuntando supplier: " + sup.devolver());

		ISupplier<String> suplier = () -> "ejecutar supplier";
		LOG.info(suplier.devolver());

		LOG.info(consumoHO.consumirSupplier(suplier));

		// consumer
		Alumno a = new Alumno();
		a.setApellido("Tapia");
		a.setNombre("Dennis");
		IConsumer<Alumno> consumer = new ConsumerImpl();
		consumer.accept(a);

		IConsumer<Alumno> lambdaConsummer = alumno -> LOG.info("alumno: " + alumno);
		lambdaConsummer.accept(a);

		consumoHO.consumirConsumer(alumno -> LOG.info(alumno), a);

		// Predicate
		IPredicate<Alumno> predicate = new PredicateImpl();
		LOG.info("predicate: " + predicate.evaluate(a));

		IPredicate<Alumno> predicateLambda = alumno -> (alumno.getNombre().equalsIgnoreCase("Javier")
				|| alumno.getApellido().equals("Ortiz"));
		LOG.info("predicate lambda: " + predicateLambda.evaluate(a));

		LOG.info(consumoHO.consumirPredicate(alumnoHO -> (alumnoHO.getNombre().contains("a")), a));

		// function

		IFuntion<AlumnoTO, Alumno> funcion = new FunctionImpl();
		LOG.info("funcion: " + funcion.aplicar(a));

		IFuntion<AlumnoTO, Alumno> funcionLambda = alumno -> {
			AlumnoTO alumnoTO = new AlumnoTO();
			alumnoTO.setEdad("21");
			return alumnoTO;
		};

		LOG.info("funtion lambda: " + funcionLambda.aplicar(a));

		LOG.info(consumoHO.consumirFunction(alumno -> {
			AlumnoTO alumnoTO = new AlumnoTO();
			alumnoTO.setEdad("19");
			return alumnoTO;
		}, a));
	

		IUnaryOperator<String> unary=new UnaryOperatorImpl();
		LOG.info(unary.apply(a.toString()));
		
		IUnaryOperator<AlumnoTO> unaryLambda = alumno -> alumno;
		LOG.info("unary : "+unary.apply(a.getApellido().concat(" unary")));
		
		LOG.info("unary HO: " + consumoHO.consumirUnaryOperator(alumno -> alumno, funcionLambda.aplicar(a)));
		
		
		
	}

}
