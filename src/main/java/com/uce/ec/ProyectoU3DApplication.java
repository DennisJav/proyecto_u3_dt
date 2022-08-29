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
		prod1.setPrecio(new BigDecimal(0.50));
		prod1.setStock(50);
		
		Producto prod2 = new Producto();
		prod2.setCodigoBarras("2");
		prod2.setNombre("Atun");
		prod2.setPrecio(new BigDecimal(1.20));
		prod2.setStock(100);
		

		
//		this.productoService.crearProducto(prod1);
//		this.productoService.crearProducto(prod2);

		
		List<String>codigosBarra = new ArrayList<>();
		
		codigosBarra.add("1");
		codigosBarra.add("2");

		
		//this.supermaxiGestorService.crearFactura("1721334686", "022",codigosBarra );
		
	}

}
