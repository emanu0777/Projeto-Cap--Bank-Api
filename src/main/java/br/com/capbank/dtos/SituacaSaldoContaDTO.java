package br.com.capbank.dtos;

public class SituacaSaldoContaDTO {
	
	private Boolean saldoNegativado;
	
	private Boolean permiteUsarChequeEspecial;

	public Boolean getSaldoNegativado() {
		return saldoNegativado;
	}

	public void setSaldoNegativado(Boolean saldoNegativado) {
		this.saldoNegativado = saldoNegativado;
	}

	public Boolean getPermiteUsarChequeEspecial() {
		return permiteUsarChequeEspecial;
	}

	public void setPermiteUsarChequeEspecial(Boolean permiteUsarChequeEspecial) {
		this.permiteUsarChequeEspecial = permiteUsarChequeEspecial;
	}
	
}
