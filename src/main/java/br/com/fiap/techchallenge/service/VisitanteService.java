package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.controller.exception.ControllerNotFoundException;
import br.com.fiap.techchallenge.dto.VisitanteDTO;
import br.com.fiap.techchallenge.entities.VisitanteEntity;
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
                -> new ControllerNotFoundException("Visitante não encontrado."));
        return toVisitanteDTO(visitante);
    }

    public VisitanteDTO save(VisitanteDTO visitanteDTO) {
        VisitanteEntity visitanteEntity = toVisitanteEntity(visitanteDTO);
        visitanteEntity = visitanteRepository.save(visitanteEntity);
        return toVisitanteDTO(visitanteEntity);
    }

    public VisitanteDTO updateById(UUID id, VisitanteDTO visitanteDTO) {
        try {
            VisitanteEntity buscaProduto = visitanteRepository.getReferenceById(id);
            buscaProduto.setNome(visitanteDTO.nome());
            buscaProduto.setDocumento(visitanteDTO.documento());
            buscaProduto.setTelefone(visitanteDTO.telefone());
            buscaProduto = visitanteRepository.save(buscaProduto);
            return toVisitanteDTO(buscaProduto);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Visitante não encontrado.");
        }
    }

    public void deleteById(UUID id) {
        visitanteRepository.deleteById(id);
    }

    private VisitanteDTO toVisitanteDTO(VisitanteEntity visitanteEntity) {
        return new VisitanteDTO(
                visitanteEntity.getId(),
                visitanteEntity.getNome(),
                visitanteEntity.getDocumento(),
                visitanteEntity.getTelefone()
        );
    }

    private VisitanteEntity toVisitanteEntity(VisitanteDTO produtoDTO) {
        return new VisitanteEntity(
                produtoDTO.id(),
                produtoDTO.nome(),
                produtoDTO.documento(),
                produtoDTO.telefone()
        );
    }
}
