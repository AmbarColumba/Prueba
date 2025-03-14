package com.oficinaJuridica.SGLPWEB.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;
import com.oficinaJuridica.SGLPWEB.repository.ICtl_TipoCasoRepository;
import com.oficinaJuridica.SGLPWEB.services.ICtl_TipoCasosServices;

@Service
@Component
public class Ctl_TipoCasosServicesImpl implements ICtl_TipoCasosServices {

	@Autowired
	private ICtl_TipoCasoRepository repo;
	@Override
	public void insertarCtl_TipoCasos(Ctl_TipoCasos nuevo) {
		// TODO Auto-generated method stub
		
		try {
			repo.save(nuevo);
			
		} catch(Exception exp){
			System.out.println("Error"+exp.getMessage());
			
		}
		
	}

	@Override
	public List<Ctl_TipoCasos> listarCtl_TipoCasos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void guardar(Ctl_TipoCasos nuevo) {
		// TODO Auto-generated method stub
		repo.save(nuevo);
		
	}
	
	@Override
	public void eliminar(int idTipoCasos) {
		// TODO Auto-generated method stub
		repo.deleteById(idTipoCasos);
	}

	@Override
	public Optional<Ctl_TipoCasos> obtenerPorId(int id) {
	    return repo.findById(id);
	}

	
}
