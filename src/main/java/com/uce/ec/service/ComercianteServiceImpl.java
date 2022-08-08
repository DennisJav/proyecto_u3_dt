package com.uce.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Comerciante;
import com.uce.ec.repository.IComercianteRepo;

@Service
public class ComercianteServiceImpl implements IComercianteService{
	
	@Autowired
	private IComercianteRepo iComercianteRepo;

	@Override
	public List<Comerciante> buscarComercianteInnerJoin(String modelo) {
		// TODO Auto-generated method stub
		return this.iComercianteRepo.buscarComercianteInnerJoin(modelo);
	}

	@Override
	public List<Comerciante> buscarComercianteInnerJoin() {
		// TODO Auto-generated method stub
		return this.iComercianteRepo.buscarComercianteInnerJoin();
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinLeft(String modelo) {
		// TODO Auto-generated method stub
		return this.iComercianteRepo.buscarComercianteOuterJoinLeft(modelo);
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iComercianteRepo.buscarComercianteOuterJoinLeft();
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinRight(String modelo) {
		// TODO Auto-generated method stub
		return this.iComercianteRepo.buscarComercianteOuterJoinRight(modelo);
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinwhere(String modelo) {
		// TODO Auto-generated method stub
		return this.iComercianteRepo.buscarComercianteOuterJoinwhere(modelo);
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinFetch(String modelo) {
		// TODO Auto-generated method stub
		return this.iComercianteRepo.buscarComercianteOuterJoinFetch(modelo);
	}
	

}
