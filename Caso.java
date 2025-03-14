package com.oficinaJuridica.SGLPWEB.model;

import java.io.Serializable;
import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
public class Caso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCaso;
	
	@Column(unique = true, nullable = false, length = 50)
	private Integer codigo;
	private String nombreCaso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio; 
	private boolean estado;	
	
	
	 	@ManyToOne
	    @JoinColumn(name = "idTipoCasos")
	    @JsonBackReference("tipoCaso-caso") // 🔹 Se asigna un nombre único a la referencia
	    private Ctl_TipoCasos ctl_TipoCasos;

	    @ManyToOne	
	    @JoinColumn(name = "idCliente",nullable = false )
	    @NotNull(message = "El Cliente es obligatorio")  // 🔹 Validación en JPA
	    @JsonBackReference("cliente-caso") // 🔹 Se asigna un nombre único a la referencia
	    private Cliente cliente;
	    
	    @ManyToOne
	    @JoinColumn(name = "idEstadoCaso", nullable = false)
	    @JsonBackReference("estadoCaso-Caso")
	    private EstadoCaso estadoCaso;
	    
	    @OneToOne(mappedBy = "caso")
	    @JsonManagedReference("Caso-Calendario")
	    private Calendario calendario;
	    
	
	    
	    
	    
}
