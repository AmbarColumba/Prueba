package com.oficinaJuridica.SGLPWEB.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
@Data
public class Usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email(message = "El email debe ser válido")
	@NotBlank(message = "El email es obligatorio")
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank(message = "La contraseña es obligatoria")
	@Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Rol rol;

	public enum Rol {
		PERSONA, ASESOR, ADMIN
	}

	
	
	   @OneToOne
	    @JoinColumn(name = "idCliente", unique = true) // 🔹 Clave foránea en Usuarios
	    @JsonBackReference("cliente-usuario") 
	    private Cliente cliente;
	
	
	
}
