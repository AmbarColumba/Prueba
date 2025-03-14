package com.oficinaJuridica.SGLPWEB.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import lombok.Data;
@Entity
@Data
public class Asesor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsesor;

    private String especialidad;

    @ManyToMany(mappedBy = "asesores")
    @JsonBackReference("cliente-asesor")
    private List<Cliente> clientes;
}
