package br.com.capbank.services;

import java.util.List;

import br.com.capbank.dtos.ClienteContaDTO;
import br.com.capbank.dtos.ContaDTO;
import br.com.capbank.dtos.DepositoDTO;

public interface ContaService {

	public ContaDTO abreConta(ContaDTO contaDTO);
	
	public List<ContaDTO> listaContas();
	
	public ContaDTO buscaContaPorId(Integer idConta);
	
	public ContaDTO buscaContaPorNumeroAngenciaNumeroConta(String numeroAgencia, String numeroConta);
	
	public ContaDTO realizaSaque(String numeroAgencia, String numeroConta, double valorSaque);
	
	public DepositoDTO realizaDeposito(DepositoDTO depositoDTO);
	
}
