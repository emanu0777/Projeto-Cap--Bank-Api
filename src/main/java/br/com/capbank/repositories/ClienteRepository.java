package br.com.capbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.capbank.entitades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
