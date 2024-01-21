package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.visitante.VisitanteRequestDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteResponseDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteUpdateRequestDTO;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.ConflictException;
import br.com.fiap.techchallenge.exception.KeyMessages;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.mappers.visitante.VisitanteMapper;
import br.com.fiap.techchallenge.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class VisitanteService {

    private final VisitanteRepository repository;
    private final VisitaService visitaService;

    @Autowired
    public VisitanteService(final VisitanteRepository visitanteRepository, final VisitaService visitaService) {
        this.repository = visitanteRepository;
        this.visitaService = visitaService;
    }

    public List<VisitanteResponseDTO> findAll() {
        final List<Visitante> visitantes = repository.findAll();
        return visitantes.stream()
                .map(VisitanteMapper::toVisitanteResponseDTO)
                .collect(Collectors.toList());

    }

    public VisitanteResponseDTO findByDocumento(final String documento) {
        final Visitante visitante = repository.findByDocumento(documento).orElseThrow(()
                -> new NotFoundException(KeyMessages.VISITANTE_NOT_FOUND.getValue()));
        return VisitanteMapper.toVisitanteResponseDTO(visitante);
    }

    private Visitante getById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(KeyMessages.VISITANTE_NOT_FOUND.getValue()));
    }

    private void validateIfVisitanteExists(final String documento) {
        if(nonNull(documento)) {
            if (repository.findByDocumento(documento).isPresent()) {
                throw new ConflictException(KeyMessages.DOCUMENT_ALREADY_REGISTERED.getValue());
            }
        }
    }

    public VisitanteResponseDTO save(VisitanteRequestDTO visitanteRequestDTO) {
        this.validateIfVisitanteExists(visitanteRequestDTO.documento());
        final Visitante visitante = VisitanteMapper.toVisitanteEntity(visitanteRequestDTO);
        final Visitante visitanteSalvo = repository.saveAndFlush(visitante);
        return VisitanteMapper.toVisitanteResponseDTO(visitanteSalvo);
    }

    public VisitanteResponseDTO updateById(Long id, VisitanteUpdateRequestDTO visitanteUpdateRequestDTO) {
        final Visitante buscaVisitante = this.getById(id);
        this.validateIfVisitanteExists(visitanteUpdateRequestDTO.documento());
        final Visitante visitanteSalvo = repository.save(VisitanteMapper.
                toUpdatedVisitanteEntity(visitanteUpdateRequestDTO, buscaVisitante));
        return VisitanteMapper.toVisitanteResponseDTO(visitanteSalvo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }



}
