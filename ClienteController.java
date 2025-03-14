package com.oficinaJuridica.SGLPWEB.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oficinaJuridica.SGLPWEB.model.Cliente;

import com.oficinaJuridica.SGLPWEB.services.IClienteServices;

@Controller
public class ClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IClienteServices servicio;

	@GetMapping("/ListarCliente")
	public String listarClientePage(Model model) {
	    List<Cliente> listarCliente = servicio.listarCliente();
	    if (listarCliente == null) {
	        listarCliente = new ArrayList<>(); // Evita que Thymeleaf reciba null
	    }
	    model.addAttribute("listarCliente", listarCliente);
	    return "/Clientes/ListarClientes";
	}
	
	@GetMapping("/nuevoCliente")
	public String crearCliente(Model model) {
		model.addAttribute("registroCliente", new Cliente()); // Asegurar que el objeto se agrega correctamente
	    return "/Clientes/NuevoCliente"; // Asegurar que la ruta es correcta
	}

	@PostMapping("/guardarClienteObj")
	public String guardarClienteObj(@ModelAttribute("registroCliente") Cliente cliente) {
	    Optional<Cliente> clienteExistente = servicio.findFirstByCIOrderByIdClienteAsc(cliente.getCI());

	    if (clienteExistente.isPresent()) {
	        cliente.setIdCliente(clienteExistente.get().getIdCliente());
	        servicio.actualizar(cliente);
	    } else {
	        cliente.setIdCliente(0);
	        servicio.guardar(cliente);
	    }
	    return "redirect:/ListarCliente";
	}

	@PostMapping("/Clientes/guardar")
	public String guardarCliente(@ModelAttribute("registroCliente") Cliente cliente) {

		cliente.setIdCliente(0);
		servicio.guardar(cliente); // Llamar al servicio para guardar
		return "redirect:/ListarCliente"; // Redirigir a la lista después de guardar
	}
	
	@GetMapping("/Cliente/editar/{id}")
	public String editarCliente(@PathVariable("id") int id, Model model) {
	    Cliente cliente = servicio.buscarPorId(id);
	    if (cliente == null) {
	        return "redirect:/ListarCliente";
	    }

	    String fechaFormateada = "";
	    if (cliente.getFechaNacimiento() != null) {
	        fechaFormateada = cliente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    }

	    model.addAttribute("fechaNacimiento", fechaFormateada);
	    model.addAttribute("registroCliente", cliente);

	    return "/Clientes/NuevoCliente";
	}
	@GetMapping("/Cliente/eliminar/{id}")
	public String eliminarCliente(@PathVariable("id") int id) {
		servicio.eliminar(id); // Llamar al servicio para eliminar
		return "redirect:/ListarCliente"; // Redirigir a la lista después de eliminar
	}
	
	
	
	

}
