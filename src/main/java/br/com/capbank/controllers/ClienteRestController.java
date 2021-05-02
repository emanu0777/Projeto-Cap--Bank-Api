package br.com.capbank.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.capbank.dtos.ClienteDTO;
import br.com.capbank.services.ClienteService;

@RestController
@RequestMapping(path = "/capbank/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> listarClientes() {
		List<ClienteDTO> listClientes = clienteService.listarClientes();
		if (!CollectionUtils.isEmpty(listClientes)) {			
			return ResponseEntity.ok(listClientes);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = "/{idCliente}/buscar")
	public ResponseEntity<ClienteDTO> buscaClientePorId(@PathVariable("idCliente") Integer idCliente){
		ClienteDTO dto = clienteService.buscaClientePorId(idCliente);
		if (Objects.nonNull(dto)) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.noContent().build();
	}
	
}
