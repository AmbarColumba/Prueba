package com.oficinaJuridica.SGLPWEB.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficinaJuridica.SGLPWEB.model.Caso;
import com.oficinaJuridica.SGLPWEB.model.Cliente;

public interface ICasoRepository extends JpaRepository<Caso, Integer> {
	Optional<Caso> findFirstByIdCaso(Integer codigo);
	Optional<Caso> findBycodigo(Integer codigo); // Buscar cliente por cédula

}
