package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entities.VisitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VisitaRepository extends JpaRepository<VisitaEntity, UUID> {
}
