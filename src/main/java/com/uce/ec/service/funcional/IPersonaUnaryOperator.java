package com.uce.ec.service.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {

	T apply(T arg1);
}
