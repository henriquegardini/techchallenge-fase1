package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.VisitanteForm;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.dto.VisitanteDTO;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.repository.VisitanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository visitanteRepository;

    public Collection<VisitanteDTO> findAll() {
        var visitantes = visitanteRepository.findAll();
        return visitantes.stream()
                .map(this::toVisitanteDTO)
                .collect(Collectors.toList());
    }

    public VisitanteDTO findById(UUID id) {
        var visitante = visitanteRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Visitante não encontrado."));
        return toVisitanteDTO(visitante);
    }

    public VisitanteDTO save(VisitanteForm visitanteForm) {
        Visitante visitante = toVisitanteEntity(visitanteForm);
        visitante = visitanteRepository.save(visitante);
        return toVisitanteDTO(visitante);
    }

    public VisitanteDTO updateById(UUID id, VisitanteDTO visitanteDTO) {
        try {
            Visitante buscaVisitante = visitanteRepository.getReferenceById(id);
            buscaVisitante.setNome(visitanteDTO.nome());
            buscaVisitante.setDocumento(visitanteDTO.documento());
            buscaVisitante.setTelefone(visitanteDTO.telefone());
            buscaVisitante = visitanteRepository.save(buscaVisitante);
            return toVisitanteDTO(buscaVisitante);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Visitante não encontrado.");
        }
    }

    public void deleteById(UUID id) {
        visitanteRepository.deleteById(id);
    }

    private VisitanteDTO toVisitanteDTO(Visitante visitante) {
        return new VisitanteDTO(
                visitante.getId(),
                visitante.getNome(),
                visitante.getDocumento(),
                visitante.getTelefone()
        );
    }

    private Visitante toVisitanteEntity(VisitanteForm visitanteForm) {
        Visitante visitante = new Visitante(
                visitanteForm.getId(),
                visitanteForm.getNome(),
                visitanteForm.getDocumento(),
                visitanteForm.getTelefone()
        );
        visitante.setVisitas(visitanteForm.getVisitas());
        return visitante;
    }
}
