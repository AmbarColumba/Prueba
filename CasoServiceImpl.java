package com.oficinaJuridica.SGLPWEB.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oficinaJuridica.SGLPWEB.model.Caso;
import com.oficinaJuridica.SGLPWEB.model.Cliente;
import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;
import com.oficinaJuridica.SGLPWEB.model.EstadoCaso;
import com.oficinaJuridica.SGLPWEB.repository.ICasoRepository;
import com.oficinaJuridica.SGLPWEB.repository.IClienteRepository;
import com.oficinaJuridica.SGLPWEB.repository.ICtl_TipoCasoRepository;
import com.oficinaJuridica.SGLPWEB.repository.IEstadoCasoRepository;
import com.oficinaJuridica.SGLPWEB.services.ICasoServices;

@Service
@Component
public class CasoServiceImpl implements ICasoServices {
	
	@Autowired
	private ICasoRepository repo;
	
	
	
	@Autowired
	private IEstadoCasoRepository repoEstadoCaso; 
	
	@Autowired
	private IClienteRepository repoCliente;
	
	@Autowired
	private ICtl_TipoCasoRepository repoTipocaso;

	@Override
	public void insertarCaso(Caso nuevo) {
		// TODO Auto-generated method stub
		repo.save(nuevo);
		
	}

	@Override
	public List<Caso> listarCaso() {
		// TODO Auto-generated method stub
		
		List<Caso> caso= repo.findAll();
		
		return caso!= null ? caso : new ArrayList<>();
	}

	@Override
	public void guardar(Caso nuevo) {
		// TODO Auto-generated method stub
		repo.save(nuevo);
		
	}

	@Override
	public void eliminar(int idTipoCasos) {
		// TODO Auto-generated method stub
		repo.deleteById(idTipoCasos);
	}

	@Override
	public Optional<Caso> obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Caso buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void actualizar(Caso caso) {
		// TODO Auto-generated method stub
		repo.save(caso);
	}

	@Override
	public Caso buscarPorCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		return repo.findBycodigo(codigo).orElse(null);
	}

	@Override
	public Optional<Caso> findFirstByIdCaso(Integer codigo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Ctl_TipoCasos> listarCtl_TipoCasos() {
		// TODO Auto-generated method stub
		return repoTipocaso.findAll() ;
	}

	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return repoCliente.findAll();
	}



	@Override
	public List<EstadoCaso> listarEstadoCasos() {
		// TODO Auto-generated method stub
		return repoEstadoCaso.findAll();
	}
	
	
	
	
	
	

}
