package br.com.capbank.dtos;

public class DepositoDTO {

	private ContaDTO contaOrigem;
	
	private ContaDTO contaDestino;
	
	private double valorDeposito;

	public ContaDTO getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(ContaDTO contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public ContaDTO getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(ContaDTO contaDestino) {
		this.contaDestino = contaDestino;
	}

	public double getValorDeposito() {
		return valorDeposito;
	}

	public void setValorDeposito(double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}
	
	
}
