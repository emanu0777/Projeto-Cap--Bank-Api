package br.com.capbank.controllers;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.capbank.dtos.ContaDTO;
import br.com.capbank.dtos.DepositoDTO;
import br.com.capbank.dtos.SituacaSaldoContaDTO;
import br.com.capbank.services.ContaService;

@RestController
@RequestMapping(path = "/capbank/api/conta")
@CrossOrigin(origins = "*")
public class ContaRestController {
	
	@Autowired
	private ContaService contaService;
	
	
	@PostMapping("/salvar")
	public ResponseEntity<ContaDTO> abreConta(@RequestBody ContaDTO contaDTO, UriComponentsBuilder uriBuilder) {
		ContaDTO dto =  contaService.abreConta(contaDTO);
		URI uri = uriBuilder.path("/conta/{id}").buildAndExpand(dto.getIdConta()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<ContaDTO>> listarContas() {
		List<ContaDTO> listContas = contaService.listaContas();
		if (!CollectionUtils.isEmpty(listContas)) {			
			return ResponseEntity.ok(listContas);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = "agencia/{numeroAgencia}/conta/{numeroConta}/buscar")
	public ResponseEntity<ContaDTO> buscaContaPorId(@PathVariable("numeroAgencia") String numeroAgencia, @PathVariable("numeroConta") String numeroConta){
		ContaDTO dto = contaService.buscaContaPorNumeroAngenciaNumeroConta(numeroAgencia, numeroConta);
		if (Objects.nonNull(dto)) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping(path = "/depositar")
	public ResponseEntity<DepositoDTO> realizaDeposito(@RequestBody DepositoDTO depositoDTO){
		DepositoDTO objAtualizado = contaService.realizaDeposito(depositoDTO);
		
		if (Objects.nonNull(objAtualizado)) {
			return ResponseEntity.ok(objAtualizado);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	@GetMapping(path = "agencia/{numeroAgencia}/conta/{numeroConta}/saldo/{valorSaida}/verificar")
	public ResponseEntity<SituacaSaldoContaDTO> getSituacaoSaldoConta(@PathVariable("numeroAgencia") String numeroAgencia, 
			@PathVariable("numeroConta") String numeroConta, @PathVariable("valorSaida") double valorSaida) {
		SituacaSaldoContaDTO situacaSaldoContaDTO = contaService.verificaSituacaoSaldoAposMovimentacao(numeroAgencia, numeroConta, valorSaida);
 		if (Objects.nonNull(situacaSaldoContaDTO)) {		
			return ResponseEntity.ok(situacaSaldoContaDTO);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping(path = "agencia/{numeroAgencia}/conta/{numeroConta}/saque/{valorSaque}/sacar")
	public ResponseEntity<ContaDTO> realizaSaque(@PathVariable("numeroAgencia") String numeroAgencia, 
			@PathVariable("numeroConta") String numeroConta, @PathVariable("valorSaque") double valorSaque) {
		ContaDTO dto = contaService.realizaSaque(numeroAgencia, numeroConta, valorSaque);
		if (Objects.nonNull(dto)) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();
	}

}
