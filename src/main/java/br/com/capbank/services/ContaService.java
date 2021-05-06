package br.com.capbank.services;

import java.util.List;

import br.com.capbank.dtos.ContaDTO;
import br.com.capbank.dtos.DepositoDTO;
import br.com.capbank.dtos.SituacaSaldoContaDTO;

public interface ContaService {

	public ContaDTO abreConta(ContaDTO contaDTO);
	
	public List<ContaDTO> listaContas();
	
	public ContaDTO buscaContaPorId(Integer idConta);
	
	public ContaDTO buscaContaPorNumeroAngenciaNumeroConta(String numeroAgencia, String numeroConta);
	
	public ContaDTO realizaSaque(String numeroAgencia, String numeroConta, double valorSaque);
	
	public DepositoDTO realizaDeposito(DepositoDTO depositoDTO);
		
	//Tirar visibilidade public
	public ContaDTO creditaValor(ContaDTO contaDTO, double valorCredito);
	
	public ContaDTO debitaValor(ContaDTO contaDTO, double valorCredito);
	
	public SituacaSaldoContaDTO verificaSituacaoSaldoAposMovimentacao(String numeroAgencia, 
														     		  	String numeroConta, 
												     	    			double valorSaida);
	
	public SituacaSaldoContaDTO verificaSituacaoSaldoAposMovimentacao(ContaDTO contaDTO, double valorSaida);	
	
}
