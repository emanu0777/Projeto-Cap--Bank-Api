package br.com.capbank.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.capbank.dtos.ClienteDTO;
import br.com.capbank.entitades.Cliente;
import br.com.capbank.mapper.ClienteMapper;
import br.com.capbank.repositories.ClienteRepository;
import br.com.capbank.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteMapper mapper;
	

	@Override
	public ClienteDTO salvaCliente(ClienteDTO cliente) {
	return mapper.toDTO(clienteRepository.save(mapper.toEntity(cliente)));
	}

	@Override
	public List<ClienteDTO> listarClientes() {
		return mapper.toDTOList(clienteRepository.findAll());
	}

	@Override
	public ClienteDTO buscaClientePorId(Integer idCliente) {
		Optional<Cliente> clienteRetornado =  clienteRepository.findById(idCliente);
		
		if (!clienteRetornado.isPresent()) {
			return null;
		}
		
		return mapper.toDTO(clienteRetornado.get());
	}

}
