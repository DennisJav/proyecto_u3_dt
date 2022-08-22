package com.uce.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Producto;
import com.uce.ec.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public void crearProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.crearProducto(producto);
	}

	@Override
	public Producto buscarProductoId(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProductoId(id);
	}
	

}
