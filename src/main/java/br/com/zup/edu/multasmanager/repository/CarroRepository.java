package br.com.zup.edu.multasmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.multasmanager.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
	
}
