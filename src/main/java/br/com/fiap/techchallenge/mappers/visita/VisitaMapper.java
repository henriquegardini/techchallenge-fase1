package br.com.fiap.techchallenge.mappers.visita;

import br.com.fiap.techchallenge.dto.visita.VisitaRequestDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaUpdateDTO;
import br.com.fiap.techchallenge.dto.visitante.VisitanteUpdateDTO;
import br.com.fiap.techchallenge.entities.Visita;
import br.com.fiap.techchallenge.entities.Visitante;

import static java.util.Objects.isNull;

public interface VisitaMapper {

    static Visita toVisitaEntity(final VisitaRequestDTO visitaDTO) {
        return new Visita(
                visitaDTO.apartamento(),
                visitaDTO.andar(),
                visitaDTO.torre(),
                visitaDTO.expiracao()
        );
    }

    static VisitaResponseDTO toVisitaResponseDTO(final Visita visita) {
        return new VisitaResponseDTO(
                visita.getId(),
                visita.getApartamento(),
                visita.getAndar(),
                visita.getTorre(),
                visita.getInclusao(),
                visita.getExpiracao(),
                visita.getVisitante().getNome()
        );
    }

    static Visita toUpdatedVisitaEntity(final VisitaUpdateDTO visitaRequestDTO,
                                        final Visita visitaToBeUpdated) {
        visitaToBeUpdated.setApartamento(
                isNull(visitaRequestDTO.apartamento())
                        ? visitaToBeUpdated.getApartamento()
                        : visitaRequestDTO.apartamento()
        );
        visitaToBeUpdated.setAndar(
                isNull(visitaRequestDTO.andar())
                        ? visitaToBeUpdated.getAndar()
                        : visitaRequestDTO.andar()
        );
        visitaToBeUpdated.setTorre(
                isNull(visitaRequestDTO.torre())
                        ? visitaToBeUpdated.getTorre()
                        : visitaRequestDTO.torre()
        );
        visitaToBeUpdated.setExpiracao(
                isNull(visitaRequestDTO.expiracao())
                        ? visitaToBeUpdated.getExpiracao()
                        : visitaRequestDTO.expiracao()
        );
        return visitaToBeUpdated;
    }

}
