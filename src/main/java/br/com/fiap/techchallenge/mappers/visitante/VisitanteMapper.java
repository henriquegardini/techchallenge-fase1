package br.com.fiap.techchallenge.mappers.visitante;

import br.com.fiap.techchallenge.dto.visitante.VisitanteRequestDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteResponseDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteUpdateRequestDTO;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.mappers.visita.VisitaMapper;

import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public interface VisitanteMapper {


    static VisitanteResponseDTO toVisitanteResponseDTO(final Visitante visitante) {
        return new VisitanteResponseDTO(
                visitante.getId(),
                visitante.getNome(),
                visitante.getDocumento(),
                visitante.getTelefone(),
                visitante.getVisitas().stream().
                        map(VisitaMapper::toVisitaResponseDTO)
                        .collect(Collectors.toList()));
    }

    static Visitante toVisitanteEntity(final VisitanteRequestDTO visitanteRequestDTO) {
        Visitante visitante = new Visitante(
                visitanteRequestDTO.nome(),
                visitanteRequestDTO.documento(),
                visitanteRequestDTO.telefone()
        );
        visitanteRequestDTO.visitas().forEach(visita ->
                visitante.addVisita(VisitaMapper.toVisitaEntity(visita)));
        return visitante;
    }

    static Visitante toUpdatedVisitanteEntity(final VisitanteUpdateRequestDTO visitanteRequestDTO,
                                              final Visitante visitanteToBeUpdated) {
        visitanteToBeUpdated.setNome(
                isNull(visitanteRequestDTO.nome())
                        ? visitanteToBeUpdated.getNome()
                        : visitanteRequestDTO.nome()
        );
        visitanteToBeUpdated.setDocumento(
                isNull(visitanteRequestDTO.documento())
                        ? visitanteToBeUpdated.getDocumento()
                        : visitanteRequestDTO.documento());
        visitanteToBeUpdated.setTelefone(
                isNull(visitanteRequestDTO.telefone())
                        ? visitanteToBeUpdated.getTelefone()
                        : visitanteRequestDTO.telefone());
        return visitanteToBeUpdated;
    }
}
