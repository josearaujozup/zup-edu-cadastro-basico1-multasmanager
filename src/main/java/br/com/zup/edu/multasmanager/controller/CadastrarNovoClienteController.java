package br.com.zup.edu.multasmanager.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.Valid;

import br.com.zup.edu.multasmanager.utils.CpfUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.multasmanager.model.Cliente;
import br.com.zup.edu.multasmanager.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class CadastrarNovoClienteController {
	private final ClienteRepository repository;
	
	public CadastrarNovoClienteController(ClienteRepository repository) {
		this.repository=repository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClienteDTO request, UriComponentsBuilder uriComponentsBuilder){

		String hashDoCpf = CpfUtils.hash(request.getCpf()); // encripta cpf informado
		if(repository.existsByHashDoCpf(hashDoCpf)) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Cpf já existe no sistema");
		}

		Cliente novoCliente =  request.paraCliente();
		
		repository.save(novoCliente);
		
		URI location = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(novoCliente.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	@ExceptionHandler
	public ResponseEntity<?> handleUniqueConstraintErrors(ConstraintViolationException e){

		Map<String, Object> body = Map.of(
				"message", "cpf já existente no sistema",
				"timestamp", LocalDateTime.now()
		);

		return ResponseEntity.unprocessableEntity().body(body);
	}
	
}
