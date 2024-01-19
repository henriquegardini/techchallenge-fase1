package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, UUID> {
}
