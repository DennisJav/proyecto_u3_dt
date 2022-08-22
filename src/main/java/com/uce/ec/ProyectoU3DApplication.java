package com.uce.ec;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.ec.modelo.Producto;
import com.uce.ec.service.IClienteService;
import com.uce.ec.service.IComercianteService;
import com.uce.ec.service.IHotelService;
import com.uce.ec.service.IProductoService;
import com.uce.ec.service.ISupermaxiGestorService;
import com.uce.ec.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3DApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IComercianteService iComercianteService;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private ISupermaxiGestorService supermaxiGestorService;
	
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3DApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		Producto prod1 = new Producto();
		prod1.setCodigoBarras("1");
		prod1.setNombre("Doritos");
		prod1.setPrecio(new BigDecimal(0.60));
		prod1.setStock(50);
		
		Producto prod2 = new Producto();
		prod2.setCodigoBarras("2");
		prod2.setNombre("Atun");
		prod2.setPrecio(new BigDecimal(0.90));
		prod2.setStock(100);
		
		
		Producto prod3 = new Producto();
		prod3.setCodigoBarras("3");
		prod3.setNombre("Papel");
		prod3.setPrecio(new BigDecimal(6.00));
		prod3.setStock(250);
		
		Producto prod4 = new Producto();
		prod4.setCodigoBarras("4");
		prod4.setNombre("Maicena");
		prod4.setPrecio(new BigDecimal(3.00));
		prod4.setStock(60);
		
//		this.productoService.crearProducto(prod1);
//		this.productoService.crearProducto(prod2);
//		this.productoService.crearProducto(prod3);
//		this.productoService.crearProducto(prod4);
		
		List<String>codigosBarra = new ArrayList<>();
		
		codigosBarra.add("1");
		codigosBarra.add("1");
		codigosBarra.add("2");
		codigosBarra.add("3");
		
		this.supermaxiGestorService.crearFactura("1721334686", "006",codigosBarra );
		
	}

}
