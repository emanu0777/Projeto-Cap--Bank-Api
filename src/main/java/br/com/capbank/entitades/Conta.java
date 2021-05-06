package br.com.capbank.entitades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "tb_conta")
public class Conta {
	
	private Integer idConta; 
	private String numeroAgencia;
	private String numeroConta;
	private Date dataAbertura;
	private double saldo;
	private double limiteChequeEspecial;
	private Cliente cliente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_conta")
	public Integer getIdConta() {
		return idConta;
	}
	
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	
	@Column(name="numero_agencia")
	@Size(max= 4, min= 4)
	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
	@Column(name="numero_conta")
	@Size(max= 6, min= 6)
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_abertura", nullable = false)
	@NotNull
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Column(name = "limite_cheque_especial", nullable = false)
	@NotNull
	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_cliente", nullable = false)
	@NotNull
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
