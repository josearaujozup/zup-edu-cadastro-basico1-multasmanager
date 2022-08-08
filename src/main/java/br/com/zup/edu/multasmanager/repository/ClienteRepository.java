package br.com.zup.edu.multasmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.multasmanager.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    public boolean existsByHashDoCpf(String hashDoCpf);
}
