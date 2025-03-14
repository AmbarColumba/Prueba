package com.oficinaJuridica.SGLPWEB.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oficinaJuridica.SGLPWEB.model.Cliente;
import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;
import com.oficinaJuridica.SGLPWEB.repository.IClienteRepository;
import com.oficinaJuridica.SGLPWEB.repository.ICtl_TipoCasoRepository;
import com.oficinaJuridica.SGLPWEB.services.IClienteServices;
import com.oficinaJuridica.SGLPWEB.services.ICtl_TipoCasosServices;

@Service
@Component
public class ClienteServicesImpl implements IClienteServices {

	@Autowired
	private IClienteRepository repo;


	@Override
	public void eliminar(int idCliente) {
		// TODO Auto-generated method stub
		repo.deleteById(idCliente);
	}

	@Override
	public Optional<Cliente> obtenerPorId(int id) {
	    return repo.findById(id);
	}

	@Override
	public void insertarCliente(Cliente nuevo) {
		// TODO Auto-generated method stub
		try {
			repo.save(nuevo);
			
		} catch(Exception exp){
			System.out.println("Error"+exp.getMessage());
			
		}
		
	}

	@Override
	public List<Cliente> listarCliente() {
		// TODO Auto-generated method stub
		 List<Cliente> clientes = repo.findAll();
	        return clientes != null ? clientes : new ArrayList<>(); 
	    }
	

	@Override
	public void guardar(Cliente nuevo) {
		// TODO Auto-generated method stub
		repo.save(nuevo);
		
	}
	 @Override
	    public Cliente buscarPorId(int id) {
	        return repo.findById(id).orElse(null);
	    }
	 @Override
	    public void actualizar(Cliente cliente) {
	        repo.save(cliente); // Save funciona para insertar y actualizar
	    }

	@Override
	public Cliente buscarPorCI(String ci) {
		// TODO Auto-generated method stub
		return repo.findByCI(ci).orElse(null); // Si no encuentra, devuelve null
	}

	@Override
	public Optional<Cliente> findFirstByCIOrderByIdClienteAsc(String ci) {
		// TODO Auto-generated method stub
		return repo.findFirstByCIOrderByIdClienteAsc(ci);
	}



	

	
}
