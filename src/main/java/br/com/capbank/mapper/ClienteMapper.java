package br.com.capbank.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.capbank.dtos.ClienteDTO;
import br.com.capbank.entitades.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	public Cliente toEntity(ClienteDTO dto);

	public ClienteDTO toDTO(Cliente Cliente);
	
	public List<ClienteDTO> toDTOList(List<Cliente> list);

}
