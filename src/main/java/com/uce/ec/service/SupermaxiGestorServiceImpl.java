package com.uce.ec.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Cliente;
import com.uce.ec.modelo.DetalleFactura;
import com.uce.ec.modelo.Factura;
import com.uce.ec.modelo.FacturaElectronica;
import com.uce.ec.modelo.Producto;
import com.uce.ec.repository.IClienteRepo;
import com.uce.ec.repository.IFacturaElectronicaRepo;
import com.uce.ec.repository.IFacturaRepository;
import com.uce.ec.repository.IProductoRepo;

@Transactional
@Service
public class SupermaxiGestorServiceImpl implements ISupermaxiGestorService{

	@Autowired
	private IProductoRepo productoRepo;
	@Autowired
	private IClienteRepo clienteRepo;
	@Autowired
	private IFacturaRepository facturaRepository;
	@Autowired
	private IFacturaElectronicaRepo facturaElectronicaRepo;
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crearFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		Cliente cliente=this.clienteRepo.buscarClienteCedula(cedulaCliente);
		Factura factura=new Factura();
		factura.setCliente(cliente);
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);	
		List<DetalleFactura> listaDeta = new ArrayList<>();
		DetalleFactura deta= new DetalleFactura();
		BigDecimal valorTotal = BigDecimal.ZERO;
		
		for(String codigos:codigoBarras) {
			Producto p=this.productoRepo.buscarProductoCodigoBarras(codigos);
			deta.setProducto(p);
			deta.setCantidad(1);
			deta.setFactura(factura);
			deta.setSubtotal(p.getPrecio().multiply(new BigDecimal(deta.getCantidad())));
			
			valorTotal = valorTotal.add(p.getPrecio());
			listaDeta.add(deta);
			
		}	
		factura.setDetalles(listaDeta);	
		
		factura.setTotal(valorTotal);
		
		this.facturaRepository.insertar(factura);
		
		this.actualizarStock(numeroFactura);
		
		this.crearFacturaElectronica(numeroFactura);
		
	}


	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFacturaElectronica(String numeroFactura) {
		// TODO Auto-generated method stub
		Factura f=this.facturaRepository.buscarPorNumero(numeroFactura);
		FacturaElectronica factElect=new FacturaElectronica();
		factElect.setFechaCreacion(LocalDateTime.now());
		factElect.setMonto(f.getTotal());
		factElect.setNumero(numeroFactura);
		factElect.setNumeroItems(f.getDetalles().size());

		this.facturaElectronicaRepo.crearFacturaElectronica(factElect);
	}


	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizarStock(String numeroFactura) {
		// TODO Auto-generated method stub
		Factura f=this.facturaRepository.buscarPorNumero(numeroFactura);
		
		for(DetalleFactura deta:f.getDetalles()) {
			deta.getProducto().setStock(deta.getProducto().getStock() - deta.getCantidad());
		}
		
		this.facturaRepository.actualizar(f);
	}
	
	
	
	
	
}
