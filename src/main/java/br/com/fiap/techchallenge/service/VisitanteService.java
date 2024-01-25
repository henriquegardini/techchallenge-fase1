package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.visitante.VisitanteRequestDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteResponseDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteUpdateDTO;
import br.com.fiap.techchallenge.entities.Morador;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.ConflictException;
import br.com.fiap.techchallenge.exception.KeyMessages;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.mappers.visitante.VisitanteMapper;
import br.com.fiap.techchallenge.repository.MoradorRepository;
import br.com.fiap.techchallenge.repository.VisitanteRepository;
import br.com.fiap.techchallenge.util.Formatter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class VisitanteService {

    private final VisitanteRepository repository;
    private final MoradorRepository moradorRepository;
    private Formatter formatter = new Formatter();

    @Autowired
    public VisitanteService(final VisitanteRepository visitanteRepository, MoradorRepository moradorRepository) {
        this.repository = visitanteRepository;
        this.moradorRepository = moradorRepository;
    }

    public List<VisitanteResponseDTO> findAll() {
        final List<Visitante> visitantes = repository.findAll();
        return visitantes.stream()
                .map(VisitanteMapper::toVisitanteResponseDTO)
                .collect(Collectors.toList());

    }

    public VisitanteResponseDTO findByDocumento( String documento) {
        documento = formatter.formatarDocumento(documento);
        final Visitante visitante = getVisitante(documento);
        return VisitanteMapper.toVisitanteResponseDTO(visitante);
    }

    public Visitante getVisitante(String documento) {
        documento = formatter.formatarDocumento(documento);
        final Visitante visitante = repository.findByDocumento(documento).orElseThrow(()
                -> new NotFoundException(KeyMessages.VISITANTE_NOT_FOUND.getValue()));
        return visitante;
    }

    private void validateIfVisitanteExists(String documento) {
        if (nonNull(documento)) {
            documento = formatter.formatarDocumento(documento);
            if (repository.findByDocumento(documento).isPresent()) {
                throw new ConflictException(KeyMessages.DOCUMENT_ALREADY_REGISTERED.getValue());
            }
        }
    }

    public VisitanteResponseDTO save(VisitanteRequestDTO visitanteRequestDTO) {
        final Optional<Morador> morador = moradorRepository.findByDocumento(visitanteRequestDTO.documento());
        if(morador.isPresent()){
            throw new ConflictException(KeyMessages.DOCUMENT_REGISTERED_AS_MORADOR.getValue());
        }
        this.validateIfVisitanteExists(visitanteRequestDTO.documento());
        final Visitante visitante = VisitanteMapper.toVisitanteEntity(visitanteRequestDTO);
        final Visitante visitanteSalvo = repository.saveAndFlush(visitante);
        return VisitanteMapper.toVisitanteResponseDTO(visitanteSalvo);
    }

    public VisitanteResponseDTO updateByDocumento(String documento, VisitanteUpdateDTO visitanteUpdateDTO) {
        final Optional<Morador> morador = moradorRepository.findByDocumento(documento);
        if(morador.isPresent()){
            throw new ConflictException(KeyMessages.DOCUMENT_REGISTERED_AS_MORADOR.getValue());
        }
        final Visitante buscaVisitante = repository.findByDocumento(documento).orElseThrow(()
                -> new NotFoundException(KeyMessages.VISITANTE_NOT_FOUND.getValue()));
        this.validateIfVisitanteExists(visitanteUpdateDTO.documento());
        final Visitante visitanteSalvo = repository.save(VisitanteMapper.
                toUpdatedVisitanteEntity(visitanteUpdateDTO, buscaVisitante));
        return VisitanteMapper.toVisitanteResponseDTO(visitanteSalvo);
    }

    @Transactional
    public void deleteByDocumento(String documento) {
        Visitante visitante = getVisitante(documento);
        repository.deleteByDocumento(visitante.getDocumento());
    }

}
