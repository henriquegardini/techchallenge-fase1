package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entities.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, UUID> {
}
