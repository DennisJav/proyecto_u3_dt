package com.uce.ec.service.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T> {

	
	public void accept(T arg1);
}
