package com.uce.ec.service.funcional.deber;

public class UnaryOperatorImpl implements IUnaryOperator<String>{

	@Override
	public String apply(String arg1) {
		// TODO Auto-generated method stub
		return arg1.concat("Ingreso al unaryOperator: ");
	}

	
}
