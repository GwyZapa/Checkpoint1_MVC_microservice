package br.com.fiap.ckp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.ckp1.models.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}