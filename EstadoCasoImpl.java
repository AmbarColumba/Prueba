package com.oficinaJuridica.SGLPWEB.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oficinaJuridica.SGLPWEB.model.EstadoCaso;

import com.oficinaJuridica.SGLPWEB.repository.IEstadoCasoRepository;
import com.oficinaJuridica.SGLPWEB.services.IEstadoCasoServices;


@Service
@Component
public class EstadoCasoImpl implements IEstadoCasoServices {

	@Autowired
	private IEstadoCasoRepository repo;
	@Override
	public void insertarEstadoCaso(EstadoCaso nuevo) {
		// TODO Auto-generated method stub
		
		try {
			repo.save(nuevo);
			
		} catch(Exception exp){
			System.out.println("Error"+exp.getMessage());
			
		}
		
	}

	@Override
	public List<EstadoCaso> listarEstadoCaso() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void guardar(EstadoCaso nuevo) {
		// TODO Auto-generated method stub
		repo.save(nuevo);
		
	}
	
	@Override
	public void eliminar(int idTipoCasos) {
		// TODO Auto-generated method stub
		repo.deleteById(idTipoCasos);
	}

	@Override
	public Optional<EstadoCaso> obtenerPorId(int id) {
	    return repo.findById(id);
	}

	
	
}
