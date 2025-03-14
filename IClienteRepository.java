package com.oficinaJuridica.SGLPWEB.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficinaJuridica.SGLPWEB.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente,Integer>  {
	Optional<Cliente> findByCI(String ci); // Buscar cliente por cédula
	Optional<Cliente> findFirstByCIOrderByIdClienteAsc(String ci);

}
