package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entities.Visita;
import br.com.fiap.techchallenge.entities.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {
    /*Optional<Visita> findByDocumento(String documento);
    void deleteByDocumento(String documento);*/
}
