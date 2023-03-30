package br.com.fiap.ckp1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.ckp1.models.Fornecedores;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long> {
}
