package br.com.capbank.dtos;

public class ClienteContaDTO {

	private ClienteDTO clienteDTO;
	private ContaDTO contaDTO;
	
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}
	
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	
	public ContaDTO getContaDTO() {
		return contaDTO;
	}
	
	public void setContaDTO(ContaDTO contaDTO) {
		this.contaDTO = contaDTO;
	}
	
	
}
