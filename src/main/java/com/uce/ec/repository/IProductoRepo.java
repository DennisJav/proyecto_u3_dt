package com.uce.ec.repository;

import com.uce.ec.modelo.Producto;

public interface IProductoRepo {

	void crearProducto(Producto producto);
	Producto buscarProductoId(Integer id);
	Producto buscarProductoCodigoBarras(String codigoBarras);
	void actualizarProducto(Producto p);
	
}
