package com.uce.ec.service.funcional.deber;

public class PredicateImpl implements IPredicate<Alumno>{

	@Override
	public boolean evaluate(Alumno arg1) {
		// TODO Auto-generated method stub
		if(arg1.getApellido().equals("Ortiz")) {
			return false;
		}else {
			return true;
		}
		
	}

	
	
}
