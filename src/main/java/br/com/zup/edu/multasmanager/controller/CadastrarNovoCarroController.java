package br.com.zup.edu.multasmanager.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.multasmanager.model.Carro;
import br.com.zup.edu.multasmanager.model.Cliente;
import br.com.zup.edu.multasmanager.repository.CarroRepository;
import br.com.zup.edu.multasmanager.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes/{idCliente}/carros")
public class CadastrarNovoCarroController {
	private final ClienteRepository clienteRepository;
	private final CarroRepository repository;
	
	public CadastrarNovoCarroController(ClienteRepository clienteRepository, CarroRepository repository) {
		this.clienteRepository = clienteRepository;
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@PathVariable Long idCliente, @RequestBody @Valid CarroDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro de cliente para o id informado"));
		
		Carro novoCarro = request.paraCarro(cliente);
		repository.save(novoCarro);
		
		URI location = uriComponentsBuilder.path("/clientes/{idCliente}/carros/{id}").buildAndExpand(cliente.getId(),novoCarro.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
