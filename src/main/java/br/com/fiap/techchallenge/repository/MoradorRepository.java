package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entities.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {
    Optional<Morador> findByDocumento(String documento);
}
