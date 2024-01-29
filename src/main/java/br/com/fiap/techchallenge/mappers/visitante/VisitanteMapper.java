package br.com.fiap.techchallenge.mappers.visitante;

import br.com.fiap.techchallenge.dto.visitante.VisitanteRequestDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteResponseDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteUpdateDTO;
import br.com.fiap.techchallenge.entities.Visitante;
import br.com.fiap.techchallenge.mappers.visita.VisitaMapper;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public interface VisitanteMapper {

    static VisitanteResponseDTO toVisitanteResponseDTO(final Visitante visitante) {
        return new VisitanteResponseDTO(
                visitante.getDocumento(),
                visitante.getNome(),
                visitante.getTelefone(),
                visitante.getVisitas().stream().
                        map(VisitaMapper::toVisitaResponseDTO)
                        .collect(Collectors.toList()));
    }

    static Visitante toVisitanteEntity(final VisitanteRequestDTO visitanteRequestDTO) {
        Visitante visitante = new Visitante(
                visitanteRequestDTO.documento(),
                visitanteRequestDTO.nome(),
                visitanteRequestDTO.telefone()
        );
        visitanteRequestDTO.visitas().forEach(visita ->
                visitante.addVisita(VisitaMapper.toVisitaEntity(visita)));
        return visitante;
    }

    static Visitante toUpdatedVisitanteEntity(final VisitanteUpdateDTO visitanteRequestDTO,
                                              final Visitante visitanteToBeUpdated) {
        visitanteToBeUpdated.setNome(
                isNull(visitanteRequestDTO.nome())
                        ? visitanteToBeUpdated.getNome()
                        : visitanteRequestDTO.nome()
        );
        visitanteToBeUpdated.setTelefone(
                isNull(visitanteRequestDTO.telefone())
                        ? visitanteToBeUpdated.getTelefone()
                        : visitanteRequestDTO.telefone());
        return visitanteToBeUpdated;
    }
}
