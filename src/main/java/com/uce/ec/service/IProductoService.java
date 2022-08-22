package com.uce.ec.service;

import com.uce.ec.modelo.Producto;

public interface IProductoService {
	void crearProducto(Producto producto);
	Producto buscarProductoId(Integer id);
}
