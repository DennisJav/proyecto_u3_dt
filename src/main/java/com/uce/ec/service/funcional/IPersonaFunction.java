package com.uce.ec.service.funcional;

@FunctionalInterface
public interface IPersonaFunction<R,T> {

	R aplicar(T arg1);
	
}
