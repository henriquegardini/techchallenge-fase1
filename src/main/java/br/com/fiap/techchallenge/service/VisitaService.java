package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.visita.VisitaRequestDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaUpdateDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteResponseDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteRequestDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteUpdateDTO;
import br.com.fiap.techchallenge.entities.Visita;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.ConflictException;
import br.com.fiap.techchallenge.exception.KeyMessages;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.mappers.visita.VisitaMapper;
import br.com.fiap.techchallenge.mappers.visitante.VisitanteMapper;
import br.com.fiap.techchallenge.repository.VisitaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class VisitaService {

    @Autowired
    public VisitaRepository repository;

    public void saveVisitas(List<Visita> visitas) {
        repository.saveAll(visitas);
    }

    public List<VisitaResponseDTO> findAll() {
        final List<Visita> visitas = repository.findAll();
        return visitas.stream()
                .map(VisitaMapper::toVisitaResponseDTO)
                .collect(Collectors.toList());
    }

    /*public VisitaResponseDTO findByDocumento(final String documento) {
        final Optional<Visita> visitas = repository.findByDocumento(documento);
        return VisitaMapper.toVisitaResponseDTO(visitas);
    }

    private Visita getVisita(String documento) {
        final Visita visita = repository.findByDocumento(documento).orElseThrow(()
                -> new NotFoundException(KeyMessages.VISITA_NOT_FOUND.getValue()));
        return visita;
    }

    private void validateIfVisitaExists(final Long id) {
        if (nonNull(id)) {
            if (repository.findById(id).isPresent()) {
                throw new ConflictException(KeyMessages.DOCUMENT_ALREADY_REGISTERED.getValue());
            }
        }
    }

    /*public VisitaResponseDTO save(VisitaRequestDTO visitaRequestDTO) {
        this.validateIfVisitaExists(visitaRequestDTO.apartamento());
        final Visita visita = VisitaMapper.toVisitaEntity(visitaRequestDTO);
        final Visita visitaSalvo = repository.saveAndFlush(visita);
        return VisitaMapper.toVisitaResponseDTO(visitaSalvo);
    }

    /*public VisitaResponseDTO updateByDocumento(Long id, VisitaUpdateDTO visitaUpdateDTO) {
        final Visita buscaVisita = repository.findById(id).orElseThrow(()
                -> new NotFoundException(KeyMessages.VISITA_NOT_FOUND.getValue()));
        this.validateIfVisitaExists(visitaUpdateDTO.apartamento());
        final Visita visitaSalvo = repository.save(VisitaMapper.
                toUpdatedVisitaEntity(visitaUpdateDTO, buscaVisita));
        return VisitaMapper.toVisitaResponseDTO(visitaSalvo);
    }

    @Transactional
    public void deleteByDocumento(Long id) {
        repository.deleteById(id);
    }*/

}
