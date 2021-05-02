package br.com.capbank.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.capbank.dtos.ContaDTO;
import br.com.capbank.entitades.Conta;

@Mapper(componentModel = "spring")
public interface ContaMapper {
	
	public Conta toEntity(ContaDTO dto);

	public ContaDTO toDTO(Conta Conta);
	
	public List<ContaDTO> toDTOList(List<Conta> list);


}
