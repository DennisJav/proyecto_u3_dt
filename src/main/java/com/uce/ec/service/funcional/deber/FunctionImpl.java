package com.uce.ec.service.funcional.deber;

public class FunctionImpl implements IFuntion<AlumnoTO, Alumno>{

	@Override
	public AlumnoTO aplicar(Alumno arg1) {
		// TODO Auto-generated method stub
		
		AlumnoTO a=new AlumnoTO();
		a.setEdad(arg1.getNombre());
		
		return a;
	}

	
	
}
