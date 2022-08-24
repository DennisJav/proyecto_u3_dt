package com.uce.ec.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		
//		String valorCadena=funcion.getNombre();
//		Integer valor = Integer.parseInt(valorCadena);
//		return valor;
		return funcion.getNombre()+"ENTRO AL METODO HO";
	}
	
	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}
	
	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valorInteger)   {
		
		return funcion.aplicar(valorInteger);
		
	}
	
}
