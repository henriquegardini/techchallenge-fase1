package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.visita.VisitaRequestDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaUpdateDTO;
import br.com.fiap.techchallenge.entities.Visita;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.exception.ConflictException;
import br.com.fiap.techchallenge.exception.KeyMessages;
import br.com.fiap.techchallenge.exception.NotFoundException;
import br.com.fiap.techchallenge.exception.OutdatedException;
import br.com.fiap.techchallenge.mappers.visita.VisitaMapper;
import br.com.fiap.techchallenge.repository.VisitaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository repository;

    @Autowired
    private VisitanteService visitanteService;

    public void saveVisitas(List<Visita> visitas) {
        repository.saveAll(visitas);
    }

    public List<VisitaResponseDTO> findAll() {
        final List<Visita> visitas = repository.findAll();
        return visitas.stream()
                .map(VisitaMapper::toVisitaResponseDTO)
                .collect(Collectors.toList());
    }

    public List<VisitaResponseDTO> findByDocumento(final String documento) {
        List<Visita> visitas = getVisitaByNome(documento);
        List<VisitaResponseDTO> responseDTOS = new ArrayList<>();
       for (Visita v : visitas) {
           responseDTOS.add(VisitaMapper.toVisitaResponseDTO(v));
       }
       return responseDTOS;
    }
    public VisitaResponseDTO findById(final Long id) {
        Visita visitas = getVisitaById(id);
        return VisitaMapper.toVisitaResponseDTO(visitas);
    }

    private List<Visita> getVisitaByNome(String documento) {
       Visitante visitante = visitanteService.getVisitante(documento);
       List<Visita> visitas = new ArrayList<>();
      if(!visitante.getVisitas().isEmpty()){
          for (Visita v : visitante.getVisitas()){
              visitas.add(v);
          }
      }
        return visitas;
    }
    private Visita getVisitaById(Long id) {
        final Visita visita = repository.findById(id).orElseThrow(()
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

    public VisitaResponseDTO save(VisitaRequestDTO visitaRequestDTO) {
        final Visita visita = VisitaMapper.toVisitaEntity(visitaRequestDTO);
        verificaSeVisitaEFutura(visitaRequestDTO.expiracao());
        Visitante visitante = visitanteService.getVisitante(visitaRequestDTO.documento());
        visita.setVisitante(visitante);
        final Visita visitaSalvo = repository.saveAndFlush(visita);
        return VisitaMapper.toVisitaResponseDTO(visitaSalvo);
    }

    private void verificaSeVisitaEFutura(LocalDate localDate) {
        if(localDate.isBefore(LocalDate.now())){
            throw new OutdatedException(KeyMessages.DATE_VISITA_IN_THE_PAST.getValue());
        }
    }

    public VisitaResponseDTO updateByDocumento(Long id, VisitaUpdateDTO visitaUpdateDTO) {
        final Visita buscaVisita = getVisitaById(id);
        verificaSeVisitaEFutura(visitaUpdateDTO.expiracao());
        final Visita visitaSalvo = repository.save(VisitaMapper.
                toUpdatedVisitaEntity(visitaUpdateDTO, buscaVisita));
        return VisitaMapper.toVisitaResponseDTO(visitaSalvo);
    }

    @Transactional
    public void deleteById(Long id) {
        Visita visita = getVisitaById(id);
        repository.deleteById(visita.getId());
    }

}
