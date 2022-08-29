package com.uce.ec.service.funcional.deber;

public class MetodosHO {

	public String consumirSupplier(ISupplier<String> funcion) {
		return funcion.devolver();
	}
	
	
	public void consumirConsumer(IConsumer<Alumno> funcion,Alumno alumno) {
		funcion.accept(alumno);
	}
	
	
	public boolean consumirPredicate(IPredicate<Alumno> funcion, Alumno alumno) {
		return funcion.evaluate(alumno);
	}
	
	
	public AlumnoTO consumirFunction(IFuntion<AlumnoTO, Alumno> funcion,Alumno alumno) {
		return funcion.aplicar(alumno);
	}
	
	public AlumnoTO consumirUnaryOperator(IUnaryOperator<AlumnoTO> funcion, AlumnoTO alumnoTO) {
		return funcion.apply(alumnoTO);
	}
	
}
