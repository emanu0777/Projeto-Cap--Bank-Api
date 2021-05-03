package br.com.capbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.capbank.entitades.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	public Conta findByNumeroAgenciaAndNumeroConta(String numeroAgencia, String numeroConta);
	
	public boolean existsByNumeroAgenciaAndNumeroConta(String numeroAgencia, String numeroConta);

}
