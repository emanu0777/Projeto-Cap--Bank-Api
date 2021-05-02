package br.com.capbank.services;

import java.util.List;

import br.com.capbank.dtos.ClienteDTO;

public interface ClienteService {

	public ClienteDTO salvaCliente(ClienteDTO cliente);
	
	public List<ClienteDTO> listarClientes();
	
	public ClienteDTO buscaClientePorId(Integer idCliente);
}
