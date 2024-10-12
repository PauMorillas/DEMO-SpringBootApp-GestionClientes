package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

@Controller
public class ClienteController {

	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private ClienteService clienteService;

	// Listar los clientes
	@GetMapping("/clientes")
	public ModelAndView findAll() {

		log.info("ClienteController - findAll: Mostramos todos los clientes");

		ModelAndView mav = new ModelAndView("clientes");
		List<ClienteDTO> listaClientesDTO = clienteService.findAll();
		mav.addObject("listaClientesDTO", listaClientesDTO);

		return mav;
	}

	// Visualizar la informacion de un cliente
	@GetMapping("/clientes/{idCliente}")
	public ModelAndView findByID(@PathVariable("idCliente") Long idCliente) {

		log.info("ClienteController - findByID: Mostramos la informacion del cliente: " + idCliente);

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);

		ModelAndView mav = new ModelAndView("clienteShow");
		mav.addObject("clienteDTO", clienteDTO);

		return mav;
	}

	// Alta de clientes
	@GetMapping("/clientes/add")
	public ModelAndView add() {

		log.info("ClienteController - add: Añadimos un nuevo cliente");

		ModelAndView mav = new ModelAndView("clienteform");
		mav.addObject("clienteDTO", new ClienteDTO());
		mav.addObject("add", true);
		return mav;
	}

	// Guardar clientes
	@PostMapping("/clientes/save")
	public ModelAndView save(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO) {
		log.info("ClienteController - save: Guardando datos del cliente" + clienteDTO.toString());

		clienteService.save(clienteDTO);

		ModelAndView mav = new ModelAndView("redirect:/clientes");

		return mav;
	}

	// Actualizar la informacion de un cliente
	@GetMapping("/clientes/update/{idCliente}")
	public ModelAndView update(@PathVariable("idCliente") Long idCliente) {

		log.info("ClienteController - update: Actualizamos la info de un cliente ya existente" + idCliente);

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);

		ModelAndView mav = new ModelAndView("clienteform");
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("add", false);

		return mav;
	}

	// Borrar un cliente
	@GetMapping("/clientes/delete/{idCliente}")
	public ModelAndView delete(@PathVariable("idCliente") Long idCliente) {

		log.info("ClienteController - delete: Borramos un cliente ya existente" + idCliente);

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteService.delete(clienteDTO);

		ModelAndView mav = new ModelAndView("redirect:/clientes");

		return mav;
	}
}
