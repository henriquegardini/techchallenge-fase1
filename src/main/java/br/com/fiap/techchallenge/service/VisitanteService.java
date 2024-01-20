package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.VisitanteRequestDTO;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.repository.VisitaRepository;
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

    public Collection<VisitanteRequestDTO> findAll() {
        var visitantes = visitanteRepository.findAll();
        return visitantes.stream()
                .map(this::toVisitanteRequestDTO)
                .collect(Collectors.toList());
    }

    public VisitanteRequestDTO findById(Long id) {
        var visitante = visitanteRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Visitante não encontrado."));
        return toVisitanteRequestDTO(visitante);
    }

    public VisitanteRequestDTO save(VisitanteRequestDTO visitanteRequestDTO) {
        Visitante visitante = toVisitanteEntity(visitanteRequestDTO);
        visitante = visitanteRepository.save(visitante);
        visitaService.saveVisitas(visitante.getVisitas());
        return toVisitanteRequestDTO(visitante);
    }

    public VisitanteRequestDTO updateById(Long id, VisitanteRequestDTO visitanteRequestDTO) {
        try {
            Visitante buscaVisitante = visitanteRepository.getReferenceById(id);
            buscaVisitante.setNome(visitanteRequestDTO.getNome());
            buscaVisitante.setDocumento(visitanteRequestDTO.getDocumento());
            buscaVisitante.setTelefone(visitanteRequestDTO.getTelefone());
            buscaVisitante.setVisitas(visitanteRequestDTO.getVisitas());
            buscaVisitante = visitanteRepository.save(buscaVisitante);
            return toVisitanteRequestDTO(buscaVisitante);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Visitante não encontrado.");
        }
    }

    public void deleteById(Long id) {
        visitanteRepository.deleteById(id);
    }

    private VisitanteRequestDTO toVisitanteRequestDTO(Visitante visitante) {
        return new VisitanteRequestDTO(
                visitante.getId(),
                visitante.getNome(),
                visitante.getDocumento(),
                visitante.getTelefone(),
                visitante.getVisitas()
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
