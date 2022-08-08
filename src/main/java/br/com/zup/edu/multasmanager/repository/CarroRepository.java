package br.com.zup.edu.multasmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.multasmanager.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

    public boolean existsByPlaca(String placa);

    public boolean existsByChassi(String chassi);
}
