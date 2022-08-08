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

import br.com.zup.edu.multasmanager.model.Acidente;
import br.com.zup.edu.multasmanager.model.Carro;
import br.com.zup.edu.multasmanager.repository.AcidenteRepository;
import br.com.zup.edu.multasmanager.repository.CarroRepository;

@RestController
@RequestMapping("/carros/{id}/acidentes")
public class CadastrarNovoAcidenteController {
	
	private final CarroRepository carroRepository;
	private final AcidenteRepository repository;
	
	public CadastrarNovoAcidenteController(CarroRepository carroRepository, AcidenteRepository repository) {
		this.carroRepository = carroRepository;
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@PathVariable Long id, @RequestBody @Valid AcidenteDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Carro carro = carroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Carro não cadastrado no sistema"));
		
		Acidente novoAcidente = request.paraAcidente(carro);
		
		repository.save(novoAcidente);
		
		URI location = uriComponentsBuilder.path("/carros/{idCarro}/acidentes/{id}").buildAndExpand(carro.getId(), novoAcidente.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
