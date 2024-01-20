package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.VisitanteDTO;
import br.com.fiap.techchallenge.dto.VisitanteRequestDTO;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.repository.VisitanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class VisitanteService {

    private final VisitanteRepository visitanteRepository;
    private final VisitaService visitaService;

    @Autowired
    public VisitanteService(VisitanteRepository visitanteRepository, VisitaService visitaService) {
        this.visitanteRepository = visitanteRepository;
        this.visitaService = visitaService;
    }

    public Collection<VisitanteDTO> findAll() {
        var visitantes = visitanteRepository.findAll();
        return visitantes.stream()
                .map(this::toVisitanteDTO)
                .collect(Collectors.toList());
    }

    public VisitanteDTO findById(Long id) {
        var visitante = visitanteRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Visitante não encontrado."));
        return toVisitanteDTO(visitante);
    }

    public VisitanteDTO save(VisitanteRequestDTO visitanteRequestDTO) {
        Visitante visitante = toVisitanteEntity(visitanteRequestDTO);
        visitante = visitanteRepository.save(visitante);
        return toVisitanteDTO(visitante);
    }

    public VisitanteDTO updateById(Long id, VisitanteDTO visitanteDTO) {
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

    public void deleteById(Long id) {
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

    private Visitante toVisitanteEntity(VisitanteRequestDTO visitanteRequestDTO) {
        Visitante visitante = new Visitante(
                visitanteRequestDTO.getNome(),
                visitanteRequestDTO.getDocumento(),
                visitanteRequestDTO.getTelefone()
        );

        visitanteRequestDTO.getVisitas().forEach(visitante::addVisita);

        return visitante;
    }
}
