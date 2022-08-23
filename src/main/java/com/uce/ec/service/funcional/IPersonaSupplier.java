package com.uce.ec.service.funcional;

@FunctionalInterface
public interface IPersonaSupplier <T>{
	//      generico, get para tipo suplier
	public T getNombre();
}
