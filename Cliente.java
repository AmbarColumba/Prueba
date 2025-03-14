package com.oficinaJuridica.SGLPWEB.model;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(unique = true)
    private String CI;
    private String Nombres;
    private String Apellidos;
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("cliente-caso")
    private List<Caso> casos;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL) // 🔹 `mappedBy` ya que Usuarios tiene la clave foránea
    @JsonManagedReference("cliente-usuario")
    private Usuarios usuario;

    @ManyToMany
    @JoinTable(
        name = "cliente_asesor",
        joinColumns = @JoinColumn(name = "cliente_id"),
        inverseJoinColumns = @JoinColumn(name = "asesor_id")
    )
    @JsonManagedReference("cliente-asesor")
    private List<Asesor> asesores;
}
